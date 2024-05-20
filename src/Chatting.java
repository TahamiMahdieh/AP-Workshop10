import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Chatting implements Runnable{
    private Socket socket;
    private User user;
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    public Chatting(Socket socket, User u){
        try {
            user = u;
            this.socket = socket;
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException e){
            System.out.println("user couldn't connect");
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                Message message = (Message) in.readObject();
                System.out.println(user.getName() + " : " + message.toString());
            }
            catch (IOException ioe) {
                System.out.println("user disconnected");
            }
            catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
