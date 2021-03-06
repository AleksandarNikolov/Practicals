
package ss.week7.cmdline;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";

    /** Starts a Server-application. */
    public static void main(String[] args) {
    	ServerSocket serverSock = null;
    	
    	if (args.length != 2) {
            System.out.println(USAGE);
            System.exit(0);
        }

        String name = args[0];
        int port = 0;

        // parse args[1] - the port
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: port " + args[1]
            		           + " is not an integer");
            System.exit(0);
        }

        // try to make a ServerSocket
        try {
            serverSock = new ServerSocket(port);
        	System.out.println("Created socket on port: " + serverSock.getLocalPort());
        } catch (IOException e) {
            System.out.println("ERROR: could not create a socket on port " + port);
        }

        // create Peer object and start the two-way communication
        try {
        	System.out.println("Waiting for client...");
        	Socket sock = serverSock.accept();
        	
        	System.out.println("Got a connection from: " + sock.getInetAddress().getHostAddress());
        	
            Peer client = new Peer(name, sock);
            Thread streamInputHandler = new Thread(client);
            streamInputHandler.start();
            client.handleTerminalInput();
            client.shutDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

} // end of class Server
