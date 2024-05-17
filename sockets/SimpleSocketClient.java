import java.io.*;
import java.net.*;
public class SimpleSocketClient {


    public static void main(String[] args) {
	   Socket clientSocket=null;
  	   PrintWriter pw=null;

	try{
	
	 //create socket to server for the given ip and port
           clientSocket = new Socket("127.0.0.1", 1234);

	 //create printwriter to socket to write content
        pw = new PrintWriter(clientSocket.getOutputStream(), true);

	pw.println(args[0]);

		}catch(Exception ex){
			ex.getMessage();
		}

   }
}