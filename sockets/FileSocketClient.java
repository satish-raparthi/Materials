import java.io.*;
import java.net.*;
public class FileSocketClient {
    private Socket clientSocket=null;
    private PrintWriter pw=null;
    private BufferedReader br=null;

	//fn to create the connection
    public void createConnection(String ip, int port) {
		try{
		 //create socket to server for the given ip and port
        clientSocket = new Socket(ip, port);

		 //create printwriter to socket to write content
        pw = new PrintWriter(clientSocket.getOutputStream(), true);

		 //create buffered reader to read from the socket
        br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		}catch(Exception ex){
			ex.getMessage();
		}
    }

	//fn to read the File Content from server
    public void getFileContentFromServer(String fn) {
        String resp=null;
		try{
			//send the file name to server through socket
          pw.println(fn);
		
		   //read the file content from socket
			while ((resp=br.readLine())!=null){
				System.out.println(resp);
			}

		}catch(Exception ex){
			ex.getMessage();
		}
    }
	
	// fn to stop the connection
    public void closeConnection() {
		//close the streams 
		//close the sockets
		try{
        br.close();
        pw.close();
        clientSocket.close();
		}catch(Exception ex){
			ex.getMessage();
		}
    }
    public static void main(String[] args) {
		int port;
	    FileSocketClient fsclient=null;
		try{
			//pass the port no
			port=Integer.parseInt(args[0]);

			//create the client socket
    	   fsclient = new FileSocketClient();
   	       fsclient.createConnection("127.0.0.1",port);

			//read the file content from server
       	fsclient.getFileContentFromServer(args[1]);

			//close the connection
			fsclient.closeConnection();
		}catch(Exception ex){
			ex.getMessage();
		}
   }
}