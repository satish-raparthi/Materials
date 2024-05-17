import java.io.*;
import java.net.*;
public class FileServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
	 private int port;

	public FileServer(int p){
		port=p;
	}

	//fn to start the socket
    public void start() {
	  try{
		 //create server socket
        serverSocket = new ServerSocket(port);

		 //start listening
        clientSocket = serverSocket.accept();

		 //create output stream to write
        out = new PrintWriter(clientSocket.getOutputStream(), true);

		//create input stream to read from the socket
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		//
        String greeting = in.readLine();
            if ("hello server".equals(greeting)) {
                out.println("hello client");
            }
            else {
                out.println("unrecognised greeting");
            }
		}catch(Exception ex){
			System.out.println(ex.getMessage());
	   }
    }

	//fun to stop the socket
    public void stop() {
	  try{
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
	   }
    }
    public static void main(String[] args) {
	  try{
	    //accept the port no
		 int port=Integer.parseInt(args[0]);
		
		 //create the server
        FileServer fs=new FileServer(port);

		 //start listening
        fs.start();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
	   }
    }
}
