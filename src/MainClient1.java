import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainClient1 {
    public static void main (String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            while (!s.equals("#exit")) {
                String temp = s.nextLine();
                Message m = new Message(temp);

            }
        }
        catch (IOException i){
            System.out.println("couldn't connect");
        }
    }
}
