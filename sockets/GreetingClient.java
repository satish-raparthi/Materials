import java.io.*;
import java.net.*;
public class FileClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

	//fn to start the connection
    public void startConnection(String ip, int port) {
		try{
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		}catch(Exception ex){
			ex.getMessage();
		}
    }

	//fn to send the message
    public String sendMessage(String msg) {
        String resp=null;
		try{
        out.println(msg);
			resp = in.readLine();

		}catch(Exception ex){
			ex.getMessage();
		}
        return resp;
    }
	
	// fn to stop the connection
    public void stopConnection() {
		try{
        in.close();
        out.close();
        clientSocket.close();
		}catch(Exception ex){
			ex.getMessage();
		}
    }
    public static void main(String[] args) {
       FileClient client = new FileClient();
       client.startConnection("127.0.0.1", 5006);
       String response = client.sendMessage("hello server");
       System.out.println(response);
   }
}