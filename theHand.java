package crib;

public class theHand {
	Card[] cards = new Card[4];
	public  theHand() {
		}
	public int score(Card c) {
		int score = 0;
		score += count15s(c);
		score += countPairs(c);
		score += countRuns(c);
		score += nobs(c);
		return score;

	}
	public int nobs(Card c) {
		for (int i=0; i<4; i++) {
			if ((cards[i].rank == 11) && (cards[i].suit == c.suit)) return 1;
		}
		return 0;
	}
	public int count15s(Card c) {
		int points = 0;
		Card[] hand = new Card[5];
		for (int i = 0; i<4;i++) {
			hand[i] = cards[i];
		}
		hand[4] = c;
		for (int i =0; i<4; i++) {
			for (int j =i+1; j<5; j++) {
				if (hand[i].val + hand[j].val == 15) {
					points +=2;
				}
				else 
					for (int k = j+1; k<5;k++) {
						if (j<4) {
							if (hand[i].val + hand[j].val + hand[k].val == 15) {
								points +=2;
							}
							else
								for (int l = k+1; l<5;l++) {
									if ((l<5)) {
										if (hand[i].val + hand[j].val + hand[k].val + hand[l].val == 15) {
											points +=2;
										}
									}
								}
						}
					}
				}
		}
		if (hand[0].val + hand[1].val + hand[2].val + hand[3].val + hand[4].val== 15) {
			points +=2;
		}				
		return points;
	}

	public int countPairs(Card c) {
		int points = 0;
		int starter = c.rank;

		for (int i =0; i<4; i++) {

			for (int j =i+1; j<4; j++) {
				if (cards[i].rank == cards[j].rank) {
					points +=2;
				}
			}
			if (cards[i].rank == starter) {
				points +=2;
			}

		}
		return points;

	}
	public int min(int r0, int r1, int r2) {
		int min=0;
		if (r0<r1) {
			if (r0<r2) min = r0;
			else min = r2;
		}
		else {
			if (r1<r2) min =r1;
			else min = r2;
		}
		return min;
	}
	
	public int max(int r0, int r1, int r2) {
		int max=0;
		if (r0>r1) {
			if (r0>r2) max = r0;
			else max = r2;
		}
		else {
			if (r1>r2) max =r1;
			else max = r2;
		}
		return max;
	}
	public int min(double r0, double r1, double r2) {
		double min=0;
		if (r0<r1) {
			if (r0<r2) min = r0;
			else min = r2;
		}
		else {
			if (r1<r2) min =r1;
			else min = r2;
		}
		return (int)min;
	}
	
	public int max(double r0, double r1, double r2) {
		double max=0;
		if (r0>r1) {
			if (r0>r2) max = r0;
			else max = r2;
		}
		else {
			if (r1>r2) max =r1;
			else max = r2;
		}
		return (int) max;
	}
	public boolean consec(double c1, double c2, double c3) {
		if ((c1 != c2) && (max(c1, c2,c3) - min(c1, c2,c3)==2)) {
			if  (((c1+c2)/2.0)==c3)   return true;
			if  (((c1+c3)/2.0)==c2) return true;
			if  (((c3+c2)/2.0)==c1) return true;
		}

		return false;
	}

	public boolean sameSuit(char c1, char c2, char c3) {
		if  ((c1 == c2) && (c2 == c3)) return true;
		return false;

	}

//	public int[] pos(int a, int b, int c) {
//		int[] p = new int[3];
//		p[0] = a;
//		p[1] = b;
//		p[2] = c;
//		return p;


//	}

	public int countRuns(Card c) {
		Card[] hand = new Card[5];
		for (int i = 0; i<4;i++) {
			hand[i] = cards[i];
		}
		hand[4] = c;
		int points = 0;
		int r0, r1, r2, r3, r4 = 0;
		int min, max, bonus =0;
//		int starterRank = c.rank;
//		char starterSuit = c.suit;
//		int[][] pos = new int[10][3];
//		String combos = "123124125134135145234235245345";
//		int count = 0;
		int[][] pos = new int [][] {{0,1,2,3,4},{0,1,3,2,4},{0,1,4,3,2},
			{0,2,3,1,4}, {0,2,4,1,3},{0,3,4,1,2},{1,2,3,0,4},{1,2,4,0,3},
			{1,3,4,0,2},{2,3,4,0,1}};
		for (int i =0; i<10; i++) {
			r0 = hand[pos[i][0]].rank;
			r1 = hand[pos[i][1]].rank;
			r2 = hand[pos[i][2]].rank;
			r3 = hand[pos[i][3]].rank;
			r4 = hand[pos[i][4]].rank;
					
			if (consec((double)r0,(double)r1, (double)r2)) {
				bonus=3;
				min = min(r0,r1,r2);
				max = max(r0,r1,r2); 
//				if (r0<r1) {
//					if (r0<r2) min = r0;
//					else min = r2;
//				}
//				else {
//					if (r1<r2) min =r1;
//					else min = r2;
//				}
//				if (r0>r1) {
//					if (r0>r2) max = r0;
//					else max = r2;
//				}
//				else {
//					if (r1>r2) max =r1;
//					else max = r2;
//				}
				if (r3 == min-1){
					if (r4 == r3 -1) {
						bonus=5;
					}
					else if (r4 == max +1) {
						bonus = 5;
					}
					else bonus = 4;
				}

				if (r4 == min-1){
					if (r3 == r4 -1) {
						bonus=5;
					}
					else if (r3 == max +1) {
						bonus = 5;
					}
					else bonus = 4;
				}
			//	************************
				if (r3 == max +1){
					if (r4 == r3 +1) {
						bonus=5;
					}
					else if (r4 == min-1) {
						bonus = 5;
					}
					else bonus = 4;
				}

				if (r4 == max +1){
					if (r3 == r4 +1) {
						bonus=5;
					}
					else if (r3 == min-1) {
						bonus = 5;
					}
					else bonus = 4;
				}


				
				points +=bonus;
				if (bonus==5) return points;
				if (bonus==4) {
					if (countPairs(c)==2) return 8;
				}
			}

		}
		return points;

	}

	public String toString() {
		String s="";
		for (int i=0; i<cards.length; i++) {
			s += cards[i].suit  + ""+cards[i].rank + " ";
		}
		return s;
	}
}

//123124125134135145234235245345
