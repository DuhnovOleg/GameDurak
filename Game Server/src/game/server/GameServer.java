package game.server;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;

public class GameServer
{
    
    public static void main(String[] args) throws IOException 
    {
        ArrayList<GameSession> dataGameSession = new ArrayList();

        try (ServerSocket serverSocket = new ServerSocket(8080)) 
        {
           
            System.out.println("Сервер полноценно заработал.");
            while(true)
            {
                System.out.println(serverSocket);
                try(Socket socket = serverSocket.accept())
                {
                    System.out.println("Пользователь зашёл.");
                    dataGameSession = ServerLogic.selector(socket, dataGameSession);
                    
                }
                System.out.println("Пользователь вышел.");
            }
        }
        catch(IOException exception)
        {
            throw new RuntimeException(exception);
        }
    }
}
