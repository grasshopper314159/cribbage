package crib;
import java.util.Arrays;
public class Deck {
	Card[] cards = new Card[52];
	public  Deck() {
//		for (int i = 0; i<52; i++) {
//			cards[i]= new Card('c', 1);
//		}

	}
	public String toString() {
		String s="";
		for (int i=0; i<cards.length; i++) {
			s += cards[i].suit  + ""+cards[i].rank + " ";
		}
		return s;
	}
	public void shuffle () {
		double lowOrd = cards[0].order;
		int lowPos = 0;
		Card c = new Card('a',1);
		for (int i = 0; i<52; i++) {
			lowOrd = cards[i].order;
			lowPos = i;
			for (int j=i; j<52; j++) {
				if (cards[j].order<lowOrd) {
					lowPos = j;
					lowOrd = cards[j].order;
				}
			}
			c = cards[i];
			cards[i] = cards[lowPos];
			cards[lowPos]  = c;

		}

	}

}
