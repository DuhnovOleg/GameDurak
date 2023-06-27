package game.server;

import game.action.Action;
import game.player.Card;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerLogic 
{
    public static ArrayList<GameSession> selector(Socket socket, ArrayList<GameSession> dataGameSession) throws IOException
    {
        try
            (
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));   // Принимает пакеты (читает)
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // Отправляет пакеты (записывает)
            )
        {
            int numberAction = reader.read();
        
            switch(numberAction)
            {
                case Action.CREATE_GAME:
                {
                    String userName    = reader.readLine();
                    String nameSession = reader.readLine();
                    int numberPlayers  = reader.read();
                    if (SearchSession(dataGameSession, nameSession) == -1)
                    {
                        GameSession newGameSession = new GameSession(numberPlayers, nameSession, userName);
                        dataGameSession.add(newGameSession);
                        writer.write("Сессия успешно создалась!");
                    }
                    else
                    {
                        writer.write("Ошибка! Сессия с таким названием уже есть!");
                    }
                    break;
                }
                case Action.CONNECT_SESSIONS:
                {
                    String userName    = reader.readLine();
                    String nameSession = reader.readLine();
                    
                    int nubmerSession = SearchSession(dataGameSession, nameSession); // Номер сессии в коллекции, к которй нужно подключиться
                    if (nubmerSession  != -1 && dataGameSession.get(nubmerSession).GetStatusGame() == false)
                    {
                        dataGameSession.get(nubmerSession).ConnectionToSession(userName);
                        writer.write("Подключение к сессии...");
                        if (dataGameSession.get(nubmerSession).NumberPlayers == dataGameSession.get(nubmerSession).NumberConnections)
                        {
                            dataGameSession.get(nubmerSession).statusSession = true;
                            dataGameSession.get(nubmerSession).InitDeck();
                            
                            for (int i = 0; i < 6; i++)
                            {
                                for (int j = 0; j < dataGameSession.get(nubmerSession).NumberPlayers; j++) 
                                {
                                    Card card = new Card();
                                    card = dataGameSession.get(nubmerSession).deck.pollCard();
                                    dataGameSession.get(nubmerSession).setHand(j, card);
                                }
                            }
                            dataGameSession.get(nubmerSession).MoveDetection();
                            dataGameSession.get(nubmerSession).deck.MoveTrump();
                        }
                    }
                    else
                    {
                        writer.write("Ошибка подключения! Сессии с таким названием не существует!");
                    }
                    break;
                }
                case Action.PUT_CARDS:
                {
                    String nameSession = reader.readLine();
                    String namePlayer  = reader.readLine();
                    int nubmerSession  = SearchSession(dataGameSession, nameSession);
                    int numberPlayers  = SearchPlayer(dataGameSession, namePlayer, nubmerSession);
                    int indexCard      = reader.read();
                    
                    Card card = new Card();
                    
                    card = dataGameSession.get(nubmerSession).dataPlayers.get(numberPlayers).poolCard(indexCard);
                    dataGameSession.get(nubmerSession).gameTable.addCardTable(card);
                    
                    for (int i = 0; i < dataGameSession.get(nubmerSession).dataPlayers.size(); i++)
                    {
                        dataGameSession.get(nubmerSession).dataPlayers.get(i).beat = false;
                    }
                    
                    int numberPlayerBut = DefinePlayer(dataGameSession, nubmerSession, namePlayer);
                    if (numberPlayerBut != -1)
                    {
                        dataGameSession.get(nubmerSession).gameTable.indexPlayerBut = numberPlayerBut;
                        dataGameSession.get(nubmerSession).dataPlayers.get(numberPlayerBut).turnOrder = 2;
                    }
                    break;
                }
                case Action.FIND_CARDS:
                {
                    String nameSession = reader.readLine();
                    String namePlayer  = reader.readLine();
                    int nubmerSession  = SearchSession(dataGameSession, nameSession);
                    int numberPlayers  = SearchPlayer(dataGameSession, namePlayer, nubmerSession);
                    
                    // ... !!Добавить отправку количества карт у игроков!!... //
                    writer.write(dataGameSession.get(nubmerSession).gameTable.round);
                    writer.flush();
                    if (dataGameSession.get(nubmerSession).gameTable.getBut == false)
                    {
                        writer.write(0);
                    }
                    else
                    {
                        writer.write(1);
                    }
                    writer.flush();
                    
                    writer.write(dataGameSession.get(nubmerSession).dataPlayers.get(numberPlayers).turnOrder);
                    writer.flush();
                    
                    for (int i = 0; i < dataGameSession.get(nubmerSession).gameTable.getSize(); i++)
                    {
                        boolean status = dataGameSession.get(nubmerSession).gameTable.getStatus(i);
                        
                        if (status == true)
                        {
                            Card flipCard   = new Card();
                            Card brokenCard = new Card();
                            
                            writer.write(1);
                            flipCard   = dataGameSession.get(nubmerSession).gameTable.getFlipCard(i);
                            brokenCard = dataGameSession.get(nubmerSession).gameTable.getBrokenCard(i);
                            
                            writer.write(flipCard.nominals);
                            writer.newLine();
                            writer.write(flipCard.pathInIcon);
                            writer.newLine();
                            writer.write(flipCard.suit);
                            writer.newLine();
                            writer.write(flipCard.power);
                            
                                                        
                            writer.write(brokenCard.nominals);
                            writer.newLine();
                            writer.write(brokenCard.pathInIcon);
                            writer.newLine();
                            writer.write(brokenCard.suit);
                            writer.newLine();
                            writer.write(brokenCard.power);
                        }
                        else
                        {
                            Card flipCard   = new Card();
                            writer.write(0);
                            flipCard   = dataGameSession.get(nubmerSession).gameTable.getFlipCard(i);
                            
                            writer.write(flipCard.nominals);
                            writer.newLine();
                            writer.write(flipCard.pathInIcon);
                            writer.newLine();
                            writer.write(flipCard.suit);
                            writer.newLine();
                            writer.write(flipCard.power);
                        }
                        writer.flush();
                    }

                    break;
                }
                case Action.WAITING_CONNECTION:
                {
                    String nameSession = reader.readLine();
                    int nubmerSession = SearchSession(dataGameSession, nameSession);
                    
                    if (dataGameSession.get(nubmerSession).GetStatusGame() == true)
                    {
                        writer.write("Подключение");
                    }
                    else
                    {
                        writer.write("Ожидайте остальных игроков!");
                    }
                    break;
                }
                case Action.SESSION_DATA_INITAL:
                {
                    String namePlayer  = reader.readLine();
                    String nameSession = reader.readLine();
                    
                    int nubmerSession  = SearchSession(dataGameSession, nameSession);
                    
                    if (nubmerSession != -1)
                    {
                        for (int i = 0; i < dataGameSession.get(nubmerSession).dataPlayers.size(); i++)
                        {
                            writer.write(dataGameSession.get(nubmerSession).dataPlayers.get(i).getUserName());
                            writer.newLine();
                        }
                        writer.write("NULL");
                        writer.newLine();
                        writer.flush(); 
                        
                        int numberPlayer = SearchPlayer(dataGameSession, namePlayer, nubmerSession);
                        if (dataGameSession.get(nubmerSession).NumberPlayers != 6)
                        {
                            Card card = new Card();
                            card = dataGameSession.get(nubmerSession).deck.getSuitCard();
                            writer.write(card.nominals);
                            writer.newLine();
                            writer.write(card.pathInIcon);
                            writer.newLine();
                            writer.write(card.suit);
                            writer.newLine();
                            writer.write(card.power);
                        }
                        else
                        {
                            writer.write(dataGameSession.get(nubmerSession).deck.getSuitTrump());
                        }
                        for (int i = 0; i < 6; i++)
                        {
                            Card card = new Card();
                            card = dataGameSession.get(nubmerSession).dataPlayers.get(numberPlayer).getHand(i);                     
                            writer.write(card.nominals);
                            writer.newLine();
                            writer.write(card.pathInIcon);
                            writer.newLine();
                            writer.write(card.suit);
                            writer.newLine();
                            writer.write(card.power);
                        }
                        writer.write("NULL");
                        writer.newLine();
                        writer.flush(); 
                        
                        int numberCard = dataGameSession.get(nubmerSession).deck.getCardInDeck();
                        writer.write(numberCard);
                        writer.write(dataGameSession.get(nubmerSession).dataPlayers.get(numberPlayer).turnOrder);
                        writer.flush(); 
                    }
                    else 
                    {
                        writer.write("Такой сессии не существует!");
                        writer.newLine();
                        writer.flush(); 
                    }

                    break;
                }
                case Action.BUT_CARDS:
                {
                    String nameSession = reader.readLine();
                    String namePlayer  = reader.readLine();
                    
                    int nubmerSession  = SearchSession(dataGameSession, nameSession);
                    int indexCardHand  = reader.read();
                    int indexCardTable = reader.read();
                    int numberPlayer   = SearchPlayer(dataGameSession, namePlayer, nubmerSession);
                    
                    Card butCard = new Card();
                    
                    butCard.nominals   = reader.readLine();
                    butCard.pathInIcon = reader.readLine();
                    butCard.suit       = reader.readLine();
                    butCard.power      = reader.read();
                    
                    dataGameSession.get(nubmerSession).gameTable.BeatCardTable(indexCardTable, butCard);
                    dataGameSession.get(nubmerSession).dataPlayers.get(numberPlayer).poolCard(indexCardHand);
                    break;
                }
                case Action.I_TAKE_CARD:
                {
                    String nameSession = reader.readLine();
                    String namePlayer  = reader.readLine();
                    
                    int nubmerSession  = SearchSession(dataGameSession, nameSession);
                    int numberPlayer   = SearchPlayer(dataGameSession, namePlayer, nubmerSession);
                    
                    dataGameSession.get(nubmerSession).indexTakePlayer = numberPlayer;
                    dataGameSession.get(nubmerSession).gameTable.getBut = true;
                    
                    boolean result = CheckBeat(dataGameSession, nubmerSession);
                    if (result == true)
                    {
                        writer.write(1);
                        for (int i = 0; i < dataGameSession.get(nubmerSession).gameTable.getSize(); i++)
                        {
                            if (dataGameSession.get(nubmerSession).gameTable.getStatus(i) == true)
                            {
                                dataGameSession.get(nubmerSession).dataPlayers.get(numberPlayer).setHand(dataGameSession.get(nubmerSession).gameTable.getFlipCard(i));
                                dataGameSession.get(nubmerSession).dataPlayers.get(numberPlayer).setHand(dataGameSession.get(nubmerSession).gameTable.getBrokenCard(i));
                            }
                            else
                            {
                                dataGameSession.get(nubmerSession).dataPlayers.get(numberPlayer).setHand(dataGameSession.get(nubmerSession).gameTable.getFlipCard(i));
                            }
                        }
                        dataGameSession.get(nubmerSession).gameTable.ClearTable();
                        dataGameSession.get(nubmerSession).indexTakePlayer = -1;
                        dataGameSession.get(nubmerSession).gameTable.getBut = false;
                        dataGameSession.get(nubmerSession).gameTable.round++;
                        dataGameSession.get(nubmerSession).gameTable.indexPlayerBut = -1;
                    }
                    else
                    {
                        writer.write(0);
                    }
                    writer.flush();
                    break;
                }
                case Action.BEAT_CARD:
                {
                    String nameSession = reader.readLine();
                    String namePlayer  = reader.readLine();
                    
                    int nubmerSession  = SearchSession(dataGameSession, nameSession);
                    int numberPlayer   = SearchPlayer(dataGameSession, namePlayer, nubmerSession);
                    
                    dataGameSession.get(nubmerSession).dataPlayers.get(numberPlayer).beat = true;
                    
                    int transitionPlayer = StrokeTransition(dataGameSession, nubmerSession, dataGameSession.get(nubmerSession).gameTable.indexPlayerBut);
                    if (transitionPlayer != -1)
                    {
                        dataGameSession.get(nubmerSession).dataPlayers.get(transitionPlayer).turnOrder = 1;
                    }
                    
                    boolean result = CheckBeat(dataGameSession, nubmerSession);
                    if (result == true && dataGameSession.get(nubmerSession).indexTakePlayer == -1)
                    {
                        dataGameSession.get(nubmerSession).gameTable.ClearTable();
                        for (int i = 0; i < dataGameSession.get(nubmerSession).NumberPlayers; i++)
                        {
                            if (i == dataGameSession.get(nubmerSession).gameTable.indexPlayerBut)
                            {
                                dataGameSession.get(nubmerSession).dataPlayers.get(i).turnOrder = 1;
                            }
                            else
                            {
                                dataGameSession.get(nubmerSession).dataPlayers.get(i).turnOrder = 0;
                            }
                        }
                        dataGameSession.get(nubmerSession).gameTable.round++;
                        dataGameSession.get(nubmerSession).gameTable.indexPlayerBut = -1;
                    }
                    break;
                }
                case Action.UPDATE_DATA:
                {
                    String nameSession = reader.readLine();
                    String namePlayer  = reader.readLine();
                    
                    int nubmerSession  = SearchSession(dataGameSession, nameSession);
                    int numberPlayer   = SearchPlayer(dataGameSession, namePlayer, nubmerSession);
                    
                    boolean check = false;
                    while (dataGameSession.get(nubmerSession).dataPlayers.get(numberPlayer).getSizeHand() < 6)
                    {
                        if (dataGameSession.get(nubmerSession).deck.getNumberCards() == 0)
                        {
                            break;
                        }
                        check = true;
                        dataGameSession.get(nubmerSession).dataPlayers.get(numberPlayer).setHand(dataGameSession.get(nubmerSession).deck.pollCard());
                    }

                    int number = 0;
                    for (int i = 0; i < dataGameSession.get(nubmerSession).NumberPlayers; i++)
                    {
                        if (dataGameSession.get(nubmerSession).dataPlayers.get(i).getSizeHand() < 6)
                        {
                            number += 6 - dataGameSession.get(nubmerSession).dataPlayers.get(i).getSizeHand();
                        }
                    }
                    number = dataGameSession.get(nubmerSession).deck.getNumberCards() - number;
                    if (number <= 0)
                    {
                        number = 0;
                    }
                    writer.write(number);
                    writer.flush();
                    
                    
                    if (check == true)
                    {
                        writer.write(1);
                    }
                    else
                    {
                        writer.write(0);
                    }
                    writer.flush();
                    
                    if (check == true)
                    {
                        for (int i = 0; i < dataGameSession.get(nubmerSession).dataPlayers.get(numberPlayer).getSizeHand(); i++)
                        {
                            Card card = new Card();
                            card = dataGameSession.get(nubmerSession).dataPlayers.get(numberPlayer).getHand(i);
                            writer.write(card.nominals);
                            writer.newLine();
                            writer.write(card.pathInIcon);
                            writer.newLine();
                            writer.write(card.suit);
                            writer.newLine();
                            writer.write(card.power);
                        }
                        writer.write("NULL");
                        writer.newLine();
                        writer.flush(); 
                    }

                    writer.write(dataGameSession.get(nubmerSession).dataPlayers.get(numberPlayer).turnOrder);
                    writer.flush(); 
                    


                }
            }
            return dataGameSession;
        }
    }
    
    // Поиск существующей сессии
    // Возвращает номер сессии, если такая сессия есть. Если нет, то возвращает -1
    private static int SearchSession(ArrayList<GameSession> dataGameSession, String nameSession)
    {
        for (int i = 0; i < dataGameSession.size(); i++) 
        {
            if (dataGameSession.get(i).nameSessions == null ? nameSession == null : dataGameSession.get(i).nameSessions.equals(nameSession))
            {
                return i;
            }
        }
        return -1;
    }
    
    // Поиск нужного игрока
    private static int SearchPlayer(ArrayList<GameSession> dataGameSession, String namePlayer, int numberSession)
    {
        for (int i = 0; i < dataGameSession.get(numberSession).dataPlayers.size(); i++) 
        {
            if (dataGameSession.get(numberSession).dataPlayers.get(i).getUserName().equals(namePlayer))
                return i;
        }
        return -1;
    }
    
    // Определить игрока, который будет отбиваться
    private static int DefinePlayer(ArrayList<GameSession> dataGameSession, int numberSession, String namePlayer)
    {
        if (dataGameSession.get(numberSession).gameTable.indexPlayerBut == -1)
        {
            int numberPlayer = SearchPlayer(dataGameSession, namePlayer, numberSession);
            if (dataGameSession.get(numberSession).dataPlayers.size() == numberPlayer + 1)
            {
                return 0;
            }
            else
            {
                return numberPlayer + 1;
            }
        }
        return -1;
    }
    
    // Определить игрока, кому переходит ход
    private static int StrokeTransition(ArrayList<GameSession> dataGameSession, int numberSession, int beatPlayer)
    {
        if (dataGameSession.get(numberSession).NumberPlayers == 2)
        {
            return -1;
        }
        else
        {
            if (dataGameSession.get(numberSession).dataPlayers.size() == beatPlayer + 1)
            {
                return 0;
            }
            else
            {
                return beatPlayer + 1;
            }
        }
    }
    
    // Проверка на биту
    private static boolean CheckBeat(ArrayList<GameSession> dataGameSession, int numberSession)
    {
        for (int i = 0; i < dataGameSession.get(numberSession).dataPlayers.size(); i++) 
        {
            if (dataGameSession.get(numberSession).dataPlayers.get(i).turnOrder == 1 && dataGameSession.get(numberSession).dataPlayers.get(i).beat != true)
            {
                return false;
            }
        }
        return true;
    }
    
        // Определить игрока, кому переходит ход
    private static int StrokeTransitionNext(ArrayList<GameSession> dataGameSession, int numberSession, int beatPlayer)
    {
        if (dataGameSession.get(numberSession).NumberPlayers == 2)
        {
            if (beatPlayer == 0)
            {
                return 1;
            }
            return 0;
        }
        else
        {
            if (dataGameSession.get(numberSession).dataPlayers.size() == beatPlayer + 1)
            {
                return 0;
            }
            
            return beatPlayer + 1;
        }
    }
}
