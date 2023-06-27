package game.player;

import java.util.LinkedList;
import java.util.Random;

public class Deck
{
    private Card suitTrump         = new Card();       // Козырная масть 
    private LinkedList<Card> deck  = new LinkedList(); // Карты в деке
    
    // Конструктор инициализации карт
    public Deck()
    {
        //
        // Инициализация карт масти "крести"
        //
        deck.add(AddCard(0, "6","../Game Durak/src/image/6_clubs.png", "clubs"));
        deck.add(AddCard(1, "7","../Game Durak/src/image/7_clubs.png", "clubs"));
        deck.add(AddCard(2, "8","../Game Durak/src/image/8_clubs.png", "clubs"));
        deck.add(AddCard(3, "9","../Game Durak/src/image/9_clubs.png", "clubs"));
        deck.add(AddCard(4, "10","../Game Durak/src/image/10_clubs.png", "clubs"));
        deck.add(AddCard(5, "J","../Game Durak/src/image/j_clubs.png", "clubs"));
        deck.add(AddCard(6, "Q","../Game Durak/src/image/q_clubs.png", "clubs"));
        deck.add(AddCard(7, "K","../Game Durak/src/image/k_clubs.png", "clubs"));
        deck.add(AddCard(8, "A","../Game Durak/src/image/ace_clubs.png", "clubs"));
        
        //
        // Инициализация карт масти "буби"
        //
        deck.add(AddCard(0, "6","../Game Durak/src/image/6_diams.png", "diams"));
        deck.add(AddCard(1, "7","../Game Durak/src/image/7_diams.png", "diams"));
        deck.add(AddCard(2, "8","../Game Durak/src/image/8_diams.png", "diams"));
        deck.add(AddCard(3, "9","../Game Durak/src/image/9_diams.png", "diams"));
        deck.add(AddCard(4, "10","../Game Durak/src/image/10_diams.png", "diams"));
        deck.add(AddCard(5, "J","../Game Durak/src/image/j_diams.png", "diams"));
        deck.add(AddCard(6, "Q","../Game Durak/src/image/q_diams.png", "diams"));
        deck.add(AddCard(7, "K","../Game Durak/src/image/k_diams.png", "diams"));
        deck.add(AddCard(8, "A","../Game Durak/src/image/ace_diams.png", "diams"));
        
        //
        // Инициализация карт масти "черви"
        //
        deck.add(AddCard(0, "6","../Game Durak/src/image/6_hearts.png", "hearts"));
        deck.add(AddCard(1, "7","../Game Durak/src/image/7_hearts.png", "hearts"));
        deck.add(AddCard(2, "8","../Game Durak/src/image/8_hearts.png", "hearts"));
        deck.add(AddCard(3, "9","../Game Durak/src/image/9_hearts.png", "hearts"));
        deck.add(AddCard(4, "10","../Game Durak/src/image/10_hearts.png", "hearts"));
        deck.add(AddCard(5, "J","../Game Durak/src/image/j_hearts.png", "hearts"));
        deck.add(AddCard(6, "Q","../Game Durak/src/image/q_hearts.png", "hearts"));
        deck.add(AddCard(7, "K","../Game Durak/src/image/k_hearts.png", "hearts"));
        deck.add(AddCard(8, "A","../Game Durak/src/image/ace_hearts.png", "hearts"));
        
        //
        // Инициализация карт масти "вини"
        //
        deck.add(AddCard(0, "6","../Game Durak/src/image/6_spades.png", "spades"));
        deck.add(AddCard(1, "7","../Game Durak/src/image/7_spades.png", "spades"));
        deck.add(AddCard(2, "8", "../Game Durak/src/image/8_spades.png", "spades"));
        deck.add(AddCard(3, "9", "../Game Durak/src/image/9_spades.png", "spades"));
        deck.add(AddCard(4, "10", "../Game Durak/src/image/10_spades.png", "spades"));
        deck.add(AddCard(5, "J", "../Game Durak/src/image/j_spades.png", "spades"));
        deck.add(AddCard(6, "Q", "../Game Durak/src/image/q_spades.png", "spades"));
        deck.add(AddCard(7, "K", "../Game Durak/src/image/k_spades.png", "spades"));
        deck.add(AddCard(8, "A", "../Game Durak/src/image/ace_spades.png", "spades"));
    }
    
    // Добавление карт в коллекцию
    private Card AddCard(int power, String nominals, String pathInIcon, String suit)
    {
        Card filling = new Card();
        
        filling.power      = power;
        filling.suit       = suit;
        filling.nominals   = nominals;
        filling.pathInIcon = pathInIcon;
        
        return filling;
    }
    
    // Метод сортировки карт в колоде
    public void SortCard()
    {
        LinkedList<Card> newDeck = new LinkedList();
        int[] arr = new int[36]; 
        Random random = new Random();
        
        for (int i = 0; i < 36; i++)
            arr[i] = i;
        

        for(int i = 0; i < arr.length; i++) 
        {
            int index = i + random.nextInt(arr.length - i);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        
        for (int i = 0; i < arr.length; i++)
        {
            Card card = new Card();
            card = deck.get(arr[i]);
            newDeck.add(card);
        }
         
        deck = newDeck;
    }
    
    // Получаем карту и удаляем её из коллекции
    public Card pollCard()
    {
        return deck.pollFirst();
    }
    
    // Получаем карту
    public Card getCard(int index)
    {
        return deck.get(index);
    }
    // Получение количества карт в колоде
    public int getNumberCards()
    {
        return deck.size();
    }
    
    
    // Метод определения козыря 
    public Card getTrump(int nubmerPlayers)
    {
        if (nubmerPlayers == 6)
        {
            suitTrump = deck.get(nubmerPlayers * 6 - 1);
            return deck.get(nubmerPlayers * 6 - 1);
        }
        suitTrump = deck.get(nubmerPlayers * 6);

        return deck.get(nubmerPlayers * 6);
    }
      
    // Метод, который перемещает козырь в цонец колоды
    public void MoveTrump()
    {
        Card card = deck.pollFirst();
        deck.add(card); 
    }
    
    // Увеличение силы козырных карт
    public void BoostTrump()
    {
        for (int i = 0; i < deck.size(); i++) 
        {
            if (deck.get(i).suit.equals(suitTrump.suit))
            {
                deck.get(i).power += 9;
            }   
        }
    }
    
    public Card getSuitCard()
    {
        return suitTrump;
    }
    
    public String getSuitTrump()
    {
        return suitTrump.suit;
    }
    
    public int getCardInDeck()
    {
        return deck.size();
    }
}
