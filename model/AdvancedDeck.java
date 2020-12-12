package model;

public class AdvancedDeck implements Deck{
    
    private Card [] cards = {Card.FORWARD, Card.LEFT, Card.RIGHT, Card.LASER, Card.FROG};
    private int [] quantity = {18, 8, 8, 5, 5};
    private int [] available = quantity.clone();

    public boolean use (Card card){
        for (int i = 0; i < cards.length; i++)
            if (cards[i].equals(card) && available[i] > 0){
                available[i]--;
                return true;
            }
        return false;
    }

    public boolean use (int cardIndex){
        return use(getCard(cardIndex));
    }


    public boolean putBack (Card card){
        for (int i = 0; i < cards.length; i++)
            if (cards[i].equals(card) && available[i] < quantity[i]){
                available[i]++;
                return true;
            }
        return false;
    }

    public boolean putBack (int cardIndex){
        return putBack(getCard(cardIndex));
    }


    public Card getCard(int cardIndex){
        if (cardIndex >= 0 && cardIndex < cards.length)
            return cards[cardIndex];
        return null;
    }

    public Card [] getCards(int [] cardIndex){
        if (cardIndex == null || cardIndex.length == 0) return null;
        Card[] results = new Card[cardIndex.length];
        for (int i = 0; i < results.length; i++)
            if (cardIndex[i] >= 0 && cardIndex[i] < cards.length)
                results[i] = cards[cardIndex[i]];
        return results;
    }

    public String [] getDeck (){
        String[] deck = new String[cards.length];
        for(int i = 0; i < cards.length; i++)
            deck[i] = String.format("%-7s [%d]\n", cards[i], available[i]);
        return deck;    
    }

    public int numOfTypes(){
        return cards.length;
    }
}

