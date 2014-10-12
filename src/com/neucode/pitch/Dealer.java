package com.neucode.pitch;

public class Dealer {
	/**
	 * holds the current state of the game. Possible values:
	 * first9
	 * bidding
	 * drawUp - making sure each player has 6 cards
	 * giveWidow
	 * dealt
	 */
	public CurrentState currentState = CurrentState.first9;
	
	public int topCard = 0;
}
