package crib;

public class Card {
	public char suit;
	public int rank;
	public double order;
	public int val;


	public Card (char c, int v) {
		suit = c;
		rank = v;
		order = Math.random();
		if (rank>10) val = 10;
		else val = rank;

	}
	//point

}
