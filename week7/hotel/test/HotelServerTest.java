package ss.week7.hotel.test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import org.junit.jupiter.api.*;

import ss.week7.hotel.client.HotelClient;
import ss.week7.hotel.exceptions.ExitProgram;
import ss.week7.hotel.exceptions.ProtocolException;
import ss.week7.hotel.exceptions.ServerUnavailableException;


class HotelServerTest {
	
	@Test
	void testServer() throws IOException {
	   var sock = new Socket(InetAddress.getByName("127.0.0.1"), 8888);
	   try (var out = new PrintWriter(sock.getOutputStream());
	       var in = new BufferedReader(new InputStreamReader(sock.getInputStream()))) {
	      // Send hello
	      out.println("h");
	      out.flush();
	      assertThat(in.readLine(), containsString("h;"));
	      // Check in a guest
	      out.println("i;John;");
	      out.flush();
	      assertThat(in.readLine(), containsString("CheckIn successful in room 101"));	
	      // Activate safe of GUEST1
	      out.println("a;John;");
	      out.flush();
	      assertThat(in.readLine(), containsString("Safe has been activated"));
	      // Retrieve room information of GUEST1
	      out.println("r;John;");
	      out.flush();
	      assertThat(in.readLine(), containsString("John has room " + "101"));
	      // Retrieve room information of a non existing guest
	      out.println("r;Peet;");
	      out.flush();
	      assertThat(in.readLine(), containsString("Peet has room " + "101"));
	      // Check in a second guest
	      out.println("i;Emily;");
	      out.flush();
	      assertThat(in.readLine(), containsString("CheckIn successful in room 101"));	
	      // Retrieve the state of the hotel
	      out.println("p");
	      out.flush();
	      assertThat(in.readLine(), containsString("The hotel is very full"));
	      assertThat(in.readLine(), containsString("--EOT--"));
	      // Get the bill of guest 1 for a certain number of nights
	      out.println("b;John;4");
	      out.flush();
	      assertThat(in.readLine(), containsString("This is the bill./n Go pay"));
	      assertThat(in.readLine(), containsString("--EOT--"));
	      // Check out GUEST1
	      out.println("o;John");
	      out.flush();
	      assertThat(in.readLine(), containsString("CheckOut successful"));
	   }
	}	
}
