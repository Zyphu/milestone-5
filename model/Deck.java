package model;

public interface Deck {
    public boolean use (Card card);
    public boolean use (int cardIndex);
    public boolean putBack (Card card);
    public boolean putBack (int cardIndex);
    public Card getCard(int cardIndex);
    public Card[] getCards(int[] cardIndex);
    public String [] getDeck ();
    public int numOfTypes();
}
