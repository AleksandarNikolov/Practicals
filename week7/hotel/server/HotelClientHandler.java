package ss.week7.hotel.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import ss.week3.bill.SysoutPrinter;
import ss.week3.hotel.PricedSafe;
import ss.week7.hotel.exceptions.ServerUnavailableException;
import ss.week7.hotel.protocol.ProtocolMessages;

/**
 * HotelClientHandler for the Hotel Server application.
 * This class can handle the communication with one
 * client. 
 * 
 * @author Wim Kamerman
 */
public class HotelClientHandler implements Runnable {

	/** The socket and In- and OutputStreams */
	private BufferedReader in;
	private BufferedWriter out;
	private Socket sock;
	
	/** The connected HotelServer */
	private HotelServer srv;

	/** Name of this ClientHandler */
	private String name;

	/**
	 * Constructs a new HotelClientHandler. Opens the In- and OutputStreams.
	 * 
	 * @param sock The client socket
	 * @param srv  The connected server
	 * @param name The name of this ClientHandler
	 */
	public HotelClientHandler(Socket sock, HotelServer srv, String name) {
		try {
			in = new BufferedReader(
					new InputStreamReader(sock.getInputStream()));
			out = new BufferedWriter(
					new OutputStreamWriter(sock.getOutputStream()));
			this.sock = sock;
			this.srv = srv;
			this.name = name;
		} catch (IOException e) {
			shutdown();
		}
	}

	/**
	 * Continuously listens to client input and forwards the input to the
	 * {@link #handleCommand(String)} method.
	 */
	public void run() {
		String msg;
		try {
			msg = in.readLine();
			while (msg != null) {
				System.out.println("> [" + name + "] Incoming: " + msg);
				handleCommand(msg);
				out.newLine();
				out.flush();
				msg = in.readLine();
			}
			shutdown();
		} catch (IOException | ServerUnavailableException e) {
			shutdown();
		}
	}

	/**
	 * Handles commands received from the client by calling the according 
	 * methods at the HotelServer. For example, when the message "i Name" 
	 * is received, the method doIn() of HotelServer should be called 
	 * and the output must be sent to the client.
	 * 
	 * If the received input is not valid, send an "Unknown Command" 
	 * message to the server.
	 * 
	 * @param msg command from client
	 * @throws IOException if an IO errors occur.
	 * @throws ServerUnavailableException 
	 */
	private void handleCommand(String msg) throws IOException, ServerUnavailableException {
		String[] message = msg.split(ProtocolMessages.DELIMITER);
		char command = 'q';
		String param1 = null;
		String param2 = null;
		if (message.length > 0) {
			command = message[0].charAt(0);
		}
		if (message.length > 1) {
			param1 = message[1];
		}
		if (message.length > 2) {
			param2 = message[2];
		}
		switch (command) {
			case ProtocolMessages.HELLO:
				this.out.write(srv.getHello());
				break;
			case ProtocolMessages.IN:
				this.out.write(srv.doIn(param1));
				break;
			case ProtocolMessages.OUT:
				this.out.write(srv.doOut(param1));
				break;
			case ProtocolMessages.ROOM:
				this.out.write(srv.doRoom(param1));
				break;
			case ProtocolMessages.ACT:
				this.out.write(srv.doAct(param1, param2));
				break;
			case ProtocolMessages.BILL:
				this.out.write(srv.doBill(param1, param2));
				this.out.write(System.lineSeparator());
				this.out.write("--EOT--");
				break;
			case ProtocolMessages.PRINT:
				this.out.write(srv.doPrint());
				this.out.write(System.lineSeparator());
				this.out.write("--EOT--");
				break;
			case ProtocolMessages.EXIT:
				shutdown();
				break;
			default:
				this.out.write("Unknown Command");
				break;
		}
	}

	/**
	 * Shut down the connection to this client by closing the socket and 
	 * the In- and OutputStreams.
	 */
	private void shutdown() {
		System.out.println("> [" + name + "] Shutting down.");
		try {
			in.close();
			out.close();
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		srv.removeClient(this);
	}
}
