package game.durak;

import java.util.ArrayList;


public class GameTable 
{
    private class CardFlip
    {
        public Card    flipCard;       // Карта, которую нужно отбить
        public Card    brokenCard;     // Карта, которой отбили
        public boolean status;         // Состояние карты. false - ещё не отбита, true - отбита
    }
    
    public ArrayList<CardFlip> cardFlip = new ArrayList();
    public int checkTakePlayer = -1;
    
    public void addCardTable(Card flipCard)
    {
        CardFlip cardFlipTemp = new CardFlip();
        cardFlipTemp.flipCard = flipCard;
        
        cardFlip.add(cardFlipTemp);
    }
    
    public boolean BeatCardTable(int indexCard, Card brokenCard)
    {
        if (cardFlip.get(indexCard).status == false)
        {
            cardFlip.get(indexCard).brokenCard = brokenCard;
            
            cardFlip.get(indexCard).status = true;
            return true;
        }
        return false;
    }
    
    public void setBrokenCard(Card brokenCard, int index)
    {
        cardFlip.get(index).brokenCard = brokenCard;
    }
    
    public Card getFlipCard(int index)
    {
        return cardFlip.get(index).flipCard;
    }
        
    public Card getBrokenCard(int index)
    {
        return cardFlip.get(index).brokenCard;
    }
    
    public int getSize()
    {
        return cardFlip.size();
    }
    
    public boolean getStatus(int index)
    {
        return cardFlip.get(index).status;
    }
    
    public void setGameTable(GameTable newGameTable)
    {
        cardFlip = newGameTable.getGameTable();
    }
    
    public ArrayList<CardFlip> getGameTable()
    {
        return cardFlip;
    }
    
    public void setStatus(int index, boolean status)
    {
        cardFlip.get(index).status = status;
    }
    
    // Очищстка игрового стола
    public void ClearTable()
    {
        cardFlip.clear();
    }
}
