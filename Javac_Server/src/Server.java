import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
    List<PrintStream> clients;
    private final Object lock = new Object();

    public Server(){
        clients = new ArrayList<>();

    }
    void start()
    {
        try {
            ServerSocket serverSocket = new ServerSocket(3500);
            while (true)
            {
                Socket client = serverSocket.accept();
                Thread clientThread= new Thread(() ->
                {
                    try {
                        Scanner in = new Scanner(client.getInputStream());
                        PrintStream out = new PrintStream(client.getOutputStream());
                        synchronized (lock){
                            clients.add(out);
                        }

                        while (true)
                        {
                            String line = in.nextLine();
                            if (line.contains("quit"))
                            {
                                synchronized (lock){
                                    clients.remove(out);
                                }
                                return;
                            }
                            synchronized (lock){
                                for (PrintStream c : clients){
                                    c.println(line);
                                }


                            }
                            System.out.println(line);

                        }
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                });
                clientThread.start();

            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

