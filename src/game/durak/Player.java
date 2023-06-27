package game.durak;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player 
{
    private ArrayList<String>     playerNames = new ArrayList();  // Имена всех игроков
    private LinkedList<Card>      playerCard  = new LinkedList(); // Рука игрока
    private ArrayList<InfoPlayer> infoPlayer  = new ArrayList();  // Информация об игроках

    private Card suitTrump = new Card();  // Козырь
    
    private int    turnOrder;           // Определение возможности хода. 0 - ходить нельзя, 1 - можно ходить или подкидывать, 2 можно отбиваться
    private int    numberCardInDeck;    // Количество карт в колоде
    private int    numberPlays;         // Количество игроков в сессии
    private String userName;            // Имя главного игрока
    public String  sessionToConnect;    // Имя сессии, к которой нужно подключаться
    
    // Сортировка имён игроков в нужной последовательности
    public void SortPlayers()
    {
        ArrayList<String> sortPlayerNames = new ArrayList();
        int nameMain = 0;
        while(!playerNames.get(nameMain).equals(userName))
        {
            nameMain++;
        }
        
        for (int i = nameMain; i < playerNames.size(); i++)
        {
            sortPlayerNames.add(playerNames.get(i));
        }
        
        for (int i = 0; i < nameMain; i++)
        {
            sortPlayerNames.add(playerNames.get(i));
        } 
        
        playerNames = sortPlayerNames;
    }
    
    public void setPlayerCard(LinkedList<Card> newPlayerCard)
    {
        playerCard.clear();
        playerCard = newPlayerCard;
    }
    
    public LinkedList<Card> getPlayerCard()
    {
        return playerCard;
    }
    
    // Распределяет иконки между игроками
    public void getIconPath()
    {
        int nameMain = 0;
        while(!playerNames.get(nameMain).equals(userName))
        {
            nameMain++;
        }
        
        for (int i = nameMain; i < playerNames.size(); i++)
        {
            InfoPlayer rival = new InfoPlayer();
            rival.playerPathIcon = "../Game Durak/src/icon/players/" + i + ".png";
            
            infoPlayer.add(rival);
        }
        
        for (int i = 0; i < nameMain; i++)
        {
            InfoPlayer rival = new InfoPlayer();
            rival.playerPathIcon = "../Game Durak/src/icon/players/" + i + ".png";
            
            infoPlayer.add(rival);
        } 
    }
    
    public void setNubmerCard(String name, int numberCard)
    {
        int index = SearchPlayer(name);
        if (index != -1)
        {
            infoPlayer.get(index).numberCardHand = numberCard;
        }
    }
    
    private int SearchPlayer(String name)
    {
        int index = -1;
        for (int i = 0; i < infoPlayer.size(); i++) 
        {
            if (infoPlayer.get(i).playerNames.equals(name))
            {
                index = i;
            }
        }
        return index;
    }
    
    public int getSizePlayerNames()
    {
        return playerNames.size();
    }
    
    public String getPlayerNames(int index)
    {
        return playerNames.get(index);
    }
    
    public void addPlayerNames(String name)
    {
        playerNames.add(name);
    }
    
    
    public int getSizePlayerPathIcon()
    {
        return infoPlayer.size();
    }
    
    public String getPlayerPathIcon(int index)
    {
        return infoPlayer.get(index).playerPathIcon;
    }
    
    public void addPlayerPathIcon(String name)
    {
        InfoPlayer rival = new InfoPlayer();
        rival.playerPathIcon = name;
        infoPlayer.add(rival);
    }
    
    public int getSizeHand()
    {
        return playerCard.size();
    }
    
    public int getNumberPlays()
    {
        return numberPlays;
    }
    
    public void setNumberPlays(int value)
    {
        numberPlays = value;
    }
    
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String str)
    {
        userName = str;
    }
    
    
    public String getSessionToConnect()
    {
        return sessionToConnect;
    }
    
    public void setSessionToConnect(String str)
    {
        sessionToConnect = str;
    }
    
    
    public Card getCard(int index)
    {
        return playerCard.get(index);
    }
    
    // Возвращает и удаляет карту
    public Card poolCard(int index)
    {
        Card card = playerCard.get(index);
        playerCard.remove(index);
        return card;
    }
    
    
    public Card getCardSuitTrump()
    {
        return this.suitTrump;
    }
    
    public String getSuitTrump()
    {
        return this.suitTrump.suit;
    }
    
    public void setSuitTrump(Card suitTrump)
    {
        this.suitTrump = suitTrump;
    }

    public void addCard(Card card) 
    {
        playerCard.add(card);
    }

    
    public void setCardInDeck(int value)
    {
        numberCardInDeck = value;
    }
    
    public int getCardInDeck()
    {
        return numberCardInDeck;
    }
    
    // Количество карт в руке игрока
    public int getNumberCard()
    {
        return playerCard.size();
    }
    
    public void setPressButton(boolean value, int index)
    {
        playerCard.get(index).pressButton = value;
    }
    
    public boolean getPressButton(int index)
    {
        return playerCard.get(index).pressButton;
    }
    
    // Установить модификацию возможности хода
    public void setTurnOrder(int modifier)
    {
        turnOrder = modifier;
    }
    
    // Узнать модификацию возможности хода
    public int getTurnOrder()
    {
        return turnOrder;
    }
}
