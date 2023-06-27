package game.server;

import game.player.Card;
import game.player.Deck;
import game.player.GameTable;
import game.player.Player;
import java.util.ArrayList;

public class GameSession
{
    int     indexTakePlayer = -1;   // Индекс игрока, который берёт карты
    int     indexBeatPlayer = -1;   // Индекс игрока, который отбивает карты
    int     NumberConnections;      // Количество подключенных игроков к сессии
    int     NumberPlayers;          // Общее количество игроков, которое должно быть в игре
    String  portName;               // Имя порта
    String  nameSessions;           // Имя сессии
    boolean statusSession;          // Создана игра или нет
    
    ArrayList<Player> dataPlayers = new ArrayList(); // Данные об игроках
    
    GameTable gameTable = new GameTable(); // Игровой стол  
    Deck      deck      = new Deck();      // Игровая колода 
    
    
    GameSession(int NumberPlayers, String nameSessions, String userName)
    {
        this.NumberConnections = 1;
        this.NumberPlayers     = NumberPlayers;
        this.nameSessions      = nameSessions;
        
        Player player = new Player();
        player.setUserName(userName);
        
        this.dataPlayers.add(player);
    }
    
    // Получение информации о том, сколько игроков подключилось
    public boolean GetStatusGame()
    {
        return NumberPlayers == NumberConnections;
    }
    
    // Определение, какой игрок будет ходить
    public void MoveDetection()
    {
        class tempInt
        {
            int power;
        }
        ArrayList<tempInt> powerCard = new ArrayList();

        for (int i = 0; i < dataPlayers.size(); i++)
        {
            tempInt temp = new tempInt();
            temp.power = 30;
            powerCard.add(temp);
            for (int j = 0; j < 6; j++)
            {
                Card card = new Card();
                card = dataPlayers.get(i).getHand(j);
                if (card.power >= 9 && card.power < powerCard.get(i).power)
                {
                    powerCard.get(i).power = card.power;
                }
            }
        }
        
        int tempPower   = 30;
        int indexPlayer = 0;
        for (int i = 0; i < powerCard.size(); i++)
        {
            if (powerCard.get(i).power < tempPower)
            {
                tempPower = powerCard.get(i).power;
                indexPlayer = i;
            }
        }
        
        dataPlayers.get(indexPlayer).turnOrder = 1;
    }
    
    // Подключение к игровой сессии
    public void ConnectionToSession(String userName)
    {
        NumberConnections++;
        
        Player player = new Player();
        player.setUserName(userName);
        this.dataPlayers.add(player);
    }
    
    public void InitDeck()
    {
        deck.SortCard();
        deck.getTrump(NumberPlayers);
        deck.BoostTrump();
    }
    
    public void setHand(int indexPlayer, Card card)
    {
        dataPlayers.get(indexPlayer).setHand(card);
    }
    
        // Установить модификацию возможности хода
    public void setTurnOrder(int modifier, int indexPlayer)
    {
        dataPlayers.get(indexPlayer).turnOrder = modifier;
    }
    
    // Узнать модификацию возможности хода
    public int getTurnOrder(int indexPlayer)
    {
        return dataPlayers.get(indexPlayer).turnOrder;
    }
}
