import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainServer {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8080);
        ExecutorService e = Executors.newCachedThreadPool();
        while (true) {
            try {
                Socket connection = serverSocket.accept();
                System.out.print("enter your name: ");
                String name = s.nextLine();
                User temp = new User(name);
                System.out.println(name + " joined the group");
                Chatting c = new Chatting(connection, temp);
                e.execute(c);
            }
            catch (IOException ee){
                System.out.println("couldn't connect");
            }
        }

    }
}