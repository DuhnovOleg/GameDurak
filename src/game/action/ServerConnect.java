package game.action;

import game.durak.Card;
import game.durak.GameTable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedList;


public class ServerConnect 
{
    public int turnOrder;
    public int round;
    public int numberCards;
    public int check;
    // Отправить на сервер карту, которой игрок походил
    public boolean PutConnectServer(String sessionToConnect, String namePlayer, int indexCard) throws IOException
    {
        try(Socket socket = new Socket("127.0.0.1", 8080))
        {
            try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())))
            {
                writer.write(Action.PUT_CARDS);
                writer.write(sessionToConnect);
                writer.newLine();
                writer.write(namePlayer);
                writer.newLine();
                writer.write(indexCard);
                writer.flush();
            }
        }
        catch(IOException ex)
        {
            System.out.println("Идёт отправка карты...");
            try 
            {
                Thread.sleep(500);
            } 
            catch(InterruptedException ie) {}
            PutConnectServer(sessionToConnect, namePlayer, indexCard);
        }
        return true;
    }
    
    // Получение состояния игрового стола
    public GameTable FindConnectServer(String sessionToConnect, String namePlayer)
    {
        GameTable newGameTable = new GameTable();
        try(Socket socket = new Socket("127.0.0.1", 8080))
        {
            try
                (
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                )
            {
                writer.write(Action.FIND_CARDS);
                writer.write(sessionToConnect);
                writer.newLine();
                writer.write(namePlayer);
                writer.newLine();
                writer.flush();
                
                int status = 0;
                int index  = 0;
                round      = reader.read();
                
                newGameTable.checkTakePlayer = reader.read();
                
                turnOrder = reader.read();
                while (status != -1)
                {
                    status = reader.read();
                    if (status == 1)
                    {
                        Card flipCard   = new Card();
                        Card brokenCard = new Card();
                        
                        flipCard.nominals   = reader.readLine();
                        flipCard.pathInIcon = reader.readLine();
                        flipCard.suit       = reader.readLine();
                        flipCard.power      = reader.read();

                        brokenCard.nominals   = reader.readLine();
                        brokenCard.pathInIcon = reader.readLine();
                        brokenCard.suit       = reader.readLine();
                        brokenCard.power      = reader.read();
                        
                        newGameTable.addCardTable(flipCard);
                        newGameTable.setBrokenCard(brokenCard, index);
                        newGameTable.setStatus(index, true);
                    }
                    else if (status == 0)
                    {
                        Card flipCard   = new Card();
                        
                        flipCard.nominals   = reader.readLine();
                        flipCard.pathInIcon = reader.readLine();
                        flipCard.suit       = reader.readLine();
                        flipCard.power      = reader.read();
                        
                        newGameTable.addCardTable(flipCard);
                        newGameTable.setStatus(index, false);
                    }
                    index++;
                }
                
            }
        }
        catch(IOException ex)
        {
            System.out.println("Идёт получение карты...");
            try
            {
                Thread.sleep(2500);
            } 
            catch(InterruptedException ie) {}
            FindConnectServer(sessionToConnect, namePlayer);
        }
        return newGameTable;
    }
    
    
    // Отбить карту противника
    public void ButConnectServer(String sessionToConnect, String namePlayer, int indexCardTable, Card butCard, int indexCardHand) throws IOException
    {
        try (Socket socket = new Socket("127.0.0.1", 8080))
        {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())))
            {
                writer.write(Action.BUT_CARDS);
                writer.write(sessionToConnect);
                writer.newLine();
                writer.write(namePlayer);
                writer.newLine();
                writer.write(indexCardHand);
                writer.flush();
                
                writer.write(indexCardTable);
                
                writer.write(butCard.nominals);
                writer.newLine();
                writer.write(butCard.pathInIcon);
                writer.newLine();
                writer.write(butCard.suit);
                writer.newLine();
                writer.write(butCard.power);
                
                writer.flush();
            }
        }
        catch(IOException ex)
        {
            System.out.println("Идёт отбитие карты...");
            try
            {
                Thread.sleep(2500);
            } 
            catch(InterruptedException ie) {}
            ButConnectServer(sessionToConnect, namePlayer, indexCardTable, butCard, indexCardHand);
        }
    }
    
    // Послать сообщение на сервер о том, что взял карты со стола
    public boolean ITakeSessionConnect(String sessionToConnect, String namePlayer) throws IOException
    {
        try (Socket socket = new Socket("127.0.0.1", 8080))
        {
            try 
                (
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                )
            {
                writer.write(Action.I_TAKE_CARD);
                writer.write(sessionToConnect);
                writer.newLine();
                writer.write(namePlayer);
                writer.newLine();
                writer.flush();
                
                int result = reader.read();
                if (result == 1)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
    }
    
    public void BeatCardSessionConnection(String sessionToConnect, String namePlayer) throws IOException
    {
        try (Socket socket = new Socket("127.0.0.1", 8080))
        {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())))
            {
                writer.write(Action.BEAT_CARD);
                writer.write(sessionToConnect);
                writer.newLine();
                writer.write(namePlayer);
                writer.newLine();
                writer.flush();
            }
        }
        catch(IOException ex)
        {
            System.out.println("Сейчас отобьём...");
            try
            {
                Thread.sleep(2500);
            } 
            catch(InterruptedException ie) {}
            BeatCardSessionConnection(sessionToConnect, namePlayer);
        }
    }
    
    
    public LinkedList<Card> UpdateDataSessionConnection(String sessionToConnect, String namePlayer)
    {
        LinkedList<Card> newHand = new LinkedList();
        try (Socket socket = new Socket("127.0.0.1", 8080))
        {
            try 
                (
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                )
            {
                writer.write(Action.UPDATE_DATA);
                writer.write(sessionToConnect);
                writer.newLine();
                writer.write(namePlayer);
                writer.newLine();
                writer.flush();
                
                numberCards = reader.read();
                
                check = reader.read();
                
                if (check == 1)
                {  
                    String nominals;
                    while (true)
                    {
                        Card card = new Card();
                        nominals = reader.readLine();

                        if (nominals.equals("NULL"))
                            break;

                        card.nominals   = nominals;
                        card.pathInIcon = reader.readLine();
                        card.suit       = reader.readLine();
                        card.power      = reader.read();

                        newHand.add(card);
                    }
                }
                turnOrder   = reader.read();       
            }
        }
        catch(IOException ex)
        {
            System.out.println("Сейчас отобьём...");
            try
            {
                Thread.sleep(2500);
            } 
            catch(InterruptedException ie) {}
            UpdateDataSessionConnection(sessionToConnect, namePlayer);
        }
        return newHand;
    }
}
