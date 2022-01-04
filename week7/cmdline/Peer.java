package ss.week7.cmdline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Peer for a simple client-server application
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {
    public static final String EXIT = "exit";

    protected String name;
    protected Socket sock;
    protected BufferedReader in;
    protected BufferedWriter out;


    /**
     * @requires (nameArg != null) && (sockArg != null) 
     * @param   nameArg name of the Peer process
     * @param   sockArg Socket of the Peer process
     */
    public Peer(String nameArg, Socket sockArg) throws IOException {
    	this.name = nameArg;
    	this.sock = sockArg;
    	this.in = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
    	this.out = new BufferedWriter(new OutputStreamWriter(this.sock.getOutputStream()));
    }

    /**
     * Reads strings of the stream of the socket connection and
     * writes the characters to the default output.
     */
    public void run() {
    	try {
    		String message;
    		while ((message = in.readLine()) != null) {
    			System.out.println(message);
    		}
    	} catch (IOException e) {
    		System.err.println(e.getMessage());
    	}
    }

    /**
     * Reads a string from the console and sends this string over
     * the socket-connection to the Peer process.
     * On Peer.EXIT the method ends
     */
    public void handleTerminalInput() {
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	boolean exit = false;
    	try {
			while (!exit) {
				String message = input.readLine();
				message = this.name + ": " + message;
				if (message.equals("exit")) {
					exit = true;
					break;
				}
				this.out.write(message);
				this.out.newLine();
				this.out.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * Closes the connection, the sockets will be terminated
     */
    public void shutDown() {
    	try {
			this.sock.getInputStream().close();
			this.sock.getOutputStream().close();
			this.sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**  returns name of the peer object*/
    public String getName() {
        return name;
    }

    /** read a line from the default input */
    static public String readString(String text) {
        System.out.print(text);
        String antw = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            antw = in.readLine();
        } catch (IOException e) {
        }

        return (antw == null) ? "" : antw;
    }
}
