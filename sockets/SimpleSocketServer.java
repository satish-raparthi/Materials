import java.io.*;
import java.net.*;
public class SimpleSocketServer {

    public static void main(String[] args) {

       ServerSocket serverSocket = null;
       Socket socket = null;

       BufferedReader in;

	  try{

		 //create server socket with my own port no
	        serverSocket = new ServerSocket(1234);

		//start listening in a loop and process the request
      	  while (true) {
          		System.out.println("Waiting for client request...");

		   //start listening for input
          	   socket = serverSocket.accept();
          	   System.out.println("Accepted connection : " + socket);

		  //create buffered reader to read from socket
          	 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		   //read file name from client
		  String txt = in.readLine();

		   System.out.println("Input recieved :"+txt);

		//close all the streams and sockets
        	  if (socket!=null) 
			socket.close();
	    }

  	   }catch(Exception ex){
			System.out.println(ex.getMessage());
	   }

    }
}
