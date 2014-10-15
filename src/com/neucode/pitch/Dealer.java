package com.neucode.pitch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

public class Dealer {
	public static final int DECK_SIZE = 52;
	/**
	 * holds the current state of the game. Possible values: first9 bidding
	 * drawUp - making sure each player has 6 cards giveWidow dealt
	 */
	public CurrentState currentState = CurrentState.first9;

	public int topCard = 0;

	protected Resources r;

	protected List<Card> cards;

	public Dealer(Resources resources) {
		r = resources;
		
		Bitmap cardBackVertical = BitmapFactory.decodeResource(r,R.drawable.card_back_vertical);

		cards = new ArrayList<Card>();
		cards.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.c2, "Clubs", 2));
		
		
		//find/replace the below fields to match the above field
		
		
		
		cards.add(R.drawable.c3);
		cards.add(R.drawable.c4);
		cards.add(R.drawable.c5);
		cards.add(R.drawable.c6);
		cards.add(R.drawable.c7);
		cards.add(R.drawable.c8);
		cards.add(R.drawable.c9);
		cards.add(R.drawable.c10);
		cards.add(R.drawable.cj);

		cards.add(R.drawable.cq);
		cards.add(R.drawable.ck);
		cards.add(R.drawable.ca);

		cards.add(R.drawable.d2);
		cards.add(R.drawable.d3);
		cards.add(R.drawable.d4);
		cards.add(R.drawable.d5);
		cards.add(R.drawable.d6);

		cards.add(R.drawable.d7);
		cards.add(R.drawable.d8);
		cards.add(R.drawable.d9);
		cards.add(R.drawable.d10);
		cards.add(R.drawable.dj);

		cards.add(R.drawable.dq);
		cards.add(R.drawable.dk);
		cards.add(R.drawable.da);

		cards.add(R.drawable.h2);
		cards.add(R.drawable.h3);
		cards.add(R.drawable.h4);
		cards.add(R.drawable.h5);
		cards.add(R.drawable.h6);

		cards.add(R.drawable.h7);
		cards.add(R.drawable.h8);
		cards.add(R.drawable.h9);
		cards.add(R.drawable.h10);
		cards.add(R.drawable.hj);

		cards.add(R.drawable.hq);
		cards.add(R.drawable.hk);
		cards.add(R.drawable.ha);

		cards.add(R.drawable.s2);
		cards.add(R.drawable.s3);
		cards.add(R.drawable.s4);
		cards.add(R.drawable.s5);
		cards.add(R.drawable.s6);

		cards.add(R.drawable.s7);
		cards.add(R.drawable.s8);
		cards.add(R.drawable.s9);
		cards.add(R.drawable.s10);
		cards.add(R.drawable.sj);

		cards.add(R.drawable.sq);
		cards.add(R.drawable.sk);
		cards.add(R.drawable.sa);

		cards.add(R.drawable.bj);
		cards.add(R.drawable.lj);

		Collections.shuffle(cards);
		// Shuffle the list.
	}

	public void chooseCard(Card card) {
		card.image = BitmapFactory.decodeResource(r, cards.remove(0));
	}
}
