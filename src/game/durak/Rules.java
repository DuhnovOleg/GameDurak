package game.durak;


// Клас правил игры
public class Rules 
{
    // Добавление карты на стол. True - можно добавить, false - нельзя
    public boolean PutCard(Card card, GameTable gameTable)
    {
        if (gameTable.getSize() == 0)
        {
            return true;
        }
        else
        {
            for (int i = 0; i < gameTable.getSize(); i++)
            {
                if (gameTable.getStatus(i) == true)
                {
                    Card flipCard   = new Card();
                    Card brokenCard = new Card();

                    flipCard   = gameTable.getFlipCard(i);
                    brokenCard = gameTable.getBrokenCard(i);
                    if (flipCard.nominals.equals(card.nominals) || brokenCard.nominals.equals(card.nominals))
                    {
                        return true;
                    }
                }
                else
                {
                    Card flipCard = new Card();
                    flipCard      = gameTable.getFlipCard(i);
                    
                    if (flipCard.nominals.equals(card.nominals))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    
    // Отбивание карты
    public boolean BeatCard(Card beatCard, Card card)
    {
        if (beatCard.power > 8 && beatCard.power > card.power)
        {
            return true;
        }
        else if(beatCard.suit.equals(card.suit) && beatCard.power > card.power)
        {
            return true;
        }
        return false;
    }
}
