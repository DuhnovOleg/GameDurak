package game.player;

import java.util.ArrayList;

public class Player 
{
    public boolean beat;      // Бита
    private String userName;  // Имя игрока 
    public  int    turnOrder; // Определение возможности хода. 0 - ходить нельзя, 1 - можно ходить или подкидывать, 2 можно отбиваться
    
    private ArrayList<Card> hand = new ArrayList(); // Рука игрока
    
    // Получить имя игрока
    public String getUserName()
    {
        return userName;
    }
    
    // установить имя игрока
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    
    // Получение одной карты
    public Card getHand(int index)
    {
        return hand.get(index);
    }
    
    // Получение всех карт
    public ArrayList<Card> getAllHand()
    {
        return hand;
    }
    
    // Установка карт
    public void setHand(Card card)
    {
        hand.add(card);
    }
    
    public Card poolCard(int index)
    {
        Card card = new Card();
        card = hand.get(index);
        hand.remove(index);
        return card;
    }
    
    public int getSizeHand()
    {
        return hand.size();
    }
    
}
