package crib;
import java.util.Arrays;
public class EV {

	//int[] cards = new int[52];

	public static Deck mkCrds() {
		Deck deck= new Deck();
		int count = 0;
		char[] suits = {'c', 'd', 'h', 's'};
		for (int o=0; o<4; o++) {
			for (int i=1; i<14; i++) {
				deck.cards[count]= new Card(suits[o], i);
				count++;
			}
		} return deck;
	}
	public Card mkC( char c, int v) {
		return new Card(c , v);
	}
	public static void main(String[] args)
	{
		Deck myDeck= new Deck();
		myDeck = mkCrds();
		System.out.println(myDeck.toString());
		myDeck.shuffle();
		System.out.println(myDeck.toString());
	}


}
