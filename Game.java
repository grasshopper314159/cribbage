package crib;

public class Game {


	public static void main(String[] args) {
		Deck myDeck= new Deck();
		myDeck = EV.mkCrds();
		System.out.println(myDeck.toString());
		myDeck.shuffle();
		System.out.println(myDeck.toString());

		theHand hand1 = new theHand();
		theHand hand2 = new theHand();
		theHand hand3 = new theHand();
		for (int i = 0; i<4; i++) {
			hand1.cards[i]=myDeck.cards[i];
			hand2.cards[i]=myDeck.cards[i+6];

		}
		
		hand3.cards[0]= new Card('h', 7);
		hand3.cards[1]= new Card('s', 7);
		hand3.cards[2]= new Card('c', 7);
		hand3.cards[3]= new Card('d', 8);
		
		
		System.out.println();
		System.out.println(myDeck.cards[13].val);
		System.out.println(hand1.toString());
		System.out.println("Score1:  "+ hand1.score(myDeck.cards[13]));
		System.out.println(hand2.toString());
		System.out.println("Score2:  "+ hand2.score(myDeck.cards[13]));
		System.out.println(hand3.toString());
		System.out.println("Score3:  "+ hand3.score(new Card('d', 8)));

		int loops =1000000;
		double total=0;
		Hand dealerHand = new Hand();
		Hand poneHand = new Hand();
		for (int j = 0; j<loops; j++) {
			myDeck = EV.mkCrds();
			myDeck.shuffle();
			dealerHand = new Hand();
			poneHand  = new Hand();
			for (int i = 0; i<6; i++) {
				dealerHand.cards[i]=myDeck.cards[i];
				poneHand.cards[i]=myDeck.cards[i+6];
				}
			hand1=dealerHand.getPoneHand();
			hand2=poneHand.getPoneHand();
			total+=hand1.score(myDeck.cards[13]);
			total+=hand2.score(myDeck.cards[13]);
			}
		
		System.out.println("Average:  "+ total/(loops*2));
	}

}
