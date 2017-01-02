package crib;

public class Hand {
	Card[] cards = new Card[6];
	int[][] combos = new int[][]
			{{0,1,2,3},
			{0,1,2,4},
			{0,1,2,5},
			{0,1,3,4},
			{0,1,3,5},
			{0,1,4,5},
			{0,2,3,4},
			{0,2,3,5},
			{0,2,4,5},
			{0,3,4,5},
			{1,2,3,4},
			{1,2,3,5},
			{1,3,4,5},
			{2,3,4,5},
			{1,2,4,5}};
	public  Hand() {


	}
//	public theHand getDealerHand() {
//
//
//	}
	public theHand getPoneHand() {
		theHand trialHand = new theHand();
		int maxPos=0;
		int maxScore = 0;
		for (int i=0; i<15; i++) {
			for (int j=0; j<4;j++) {
				trialHand.cards[j]=cards[combos[i][j]];
			}
			if (trialHand.score(new Card('z',99))>maxScore) {
				maxScore = trialHand.score(new Card('z',99));
				maxPos = i;
			}
		}

		for (int j=0; j<4;j++) {
			trialHand.cards[j]=cards[combos[maxPos][j]];
		}
		return trialHand;

	}

	public String toString() {
		String s="";
		for (int i=0; i<cards.length; i++) {
			s += cards[i].suit  + ""+cards[i].rank + " ";
		}
		return s;
	}

}

//int[][] combos = new int[][]
//{{0,1,2,3},
//{0,1,2,4},
//{0,1,2,5},
//{0,1,3,4},
//{0,1,3,5},
//{0,1,4,5},
//{0,2,3,4},
//{0,2,3,5},
//{0,2,4,5},
//{0,3,4,5},
//{1,2,3,4},
//{1,2,3,5},
//{1,3,4,5},
//{2,3,4,5},
//{0,1,2,3}};
