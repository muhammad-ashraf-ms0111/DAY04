import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
  
  public static void main(String[] args) {
    int PORT = 12345;
    try{
      Socket socket = new Socket("localhost", PORT);

//Get the I/O streams
OutputStream os = socket.getOutputStream();
BufferedOutputStream bos = new BufferedOutputStream(os);
DataOutputStream dos = new DataOutputStream(bos);

Scanner inputSc = new Scanner(System.in);
String line;
while ((line = inputSc.nextLine()) != null){
  if (line.equalsIgnoreCase("close")) {
    System.out.println("Exit from shell");
    break;
  }
  dos.writeUTF(line);
  dos.flush();
  System.out.println("MSG sent to Server : " + line);
}
// dos.writeUTF("Hello world from Client");
// dos.writeUTF("Do you get it?");
// dos.flush();
// System.out.println("MESSAGE SENT TO SERVER");
socket.close();

    } catch (UnknownHostException e){
System.out.println("Unable to reach the HOST");
} catch (IOException e) {
  System.out.println("IO Error");
}
  }
}
