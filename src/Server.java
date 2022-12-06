import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

  public static void main(String[] args) {
    System.out.println("Socket Server: ");
    int PORT = 12345;


    // Create ServerSocket
    try {
      ServerSocket server = new ServerSocket(PORT); 
        //Get socket obj
        Socket socket = server.accept();
        
        InputStream is = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);

        String fromClient = dis.readUTF();
        while (!fromClient.equalsIgnoreCase("close") && fromClient != null); {

        //process the msg
        System.out.println("Received msg from client: " + fromClient);
        //read the next line from the input stream
        fromClient = dis.readUTF();

        }
        // String msg = dis.readUTF(); //if there any msg 
        // System.out.println("MSG resceived -->" + msg);
        // String msg2 = dis.readUTF(); //if there any msg 
        // System.out.println("MSGresceived -->" + msg2);
        // socket.close();
      

    } catch (IOException e) {
      System.out.println("IO Error");
    }





  }




}