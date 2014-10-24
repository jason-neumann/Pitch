package com.neucode.pitch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;

public class Dealer {
	public static final int DECK_SIZE = 52;
	/**
	 * holds the current state of the game. Possible values: first9 bidding
	 * drawUp - making sure each player has 6 cards giveWidow dealt
	 */
	public CurrentState currentState = CurrentState.first9;

	public int topCard = 0;

	protected Resources r;

	protected List<Card> deck;
	
	protected MainPanel surface;

	public Dealer(Resources resources, MainPanel surface) {
		r = resources;
		this.surface = surface;
		Log.d("pitch", "starting over, bleh");
		
		Bitmap cardBackVertical = BitmapFactory.decodeResource(r,R.drawable.card_back_vertical);

		deck = new ArrayList<Card>();
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.c2, "Clubs", 2));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.c3, "Clubs", 3));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.c4, "Clubs", 4));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.c5, "Clubs", 5));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.c6, "Clubs", 6));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.c7, "Clubs", 7));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.c8, "Clubs", 8));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.c9, "Clubs", 9));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.c10, "Clubs", 10));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.cj, "Clubs", 14));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.cq, "Clubs", 15));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.ck, "Clubs", 16));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.ca, "Clubs", 17));

		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.d2, "Diamonds", 2));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.d3, "Diamonds", 3));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.d4, "Diamonds", 4));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.d5, "Diamonds", 5));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.d6, "Diamonds", 6));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.d7, "Diamonds", 7));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.d8, "Diamonds", 8));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.d9, "Diamonds", 9));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.d10, "Diamonds", 10));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.dj, "Diamonds", 14));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.dq, "Diamonds", 15));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.dk, "Diamonds", 16));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.da, "Diamonds", 17));

		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.h2, "Hearts", 2));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.h3, "Hearts", 3));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.h4, "Hearts", 4));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.h5, "Hearts", 5));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.h6, "Hearts", 6));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.h7, "Hearts", 7));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.h8, "Hearts", 8));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.h9, "Hearts", 9));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.h10, "Hearts", 10));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.hj, "Hearts", 14));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.hq, "Hearts", 15));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.hk, "Hearts", 16));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.ha, "Hearts", 17));

		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.s2, "Spades", 2));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.s3, "Spades", 3));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.s4, "Spades", 4));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.s5, "Spades", 5));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.s6, "Spades", 6));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.s7, "Spades", 7));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.s8, "Spades", 8));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.s9, "Spades", 9));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.s10, "Spades", 10));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.sj, "Spades", 14));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.sq, "Spades", 15));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.sk, "Spades", 16));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.sa, "Spades", 17));

		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.lj, "Wild", 11));
		deck.add(new Card(cardBackVertical, new Point(0, 0), R.drawable.bj, "Wild", 12));

		Collections.shuffle(deck);
		// Shuffle the list.
	}
	
	public void render(Canvas canvas) {
		Log.d("pitch",currentState.toString());
		switch (currentState) {
		case first9:
			for(int i = 0; i < 36; i++) {
				switch(i/9) {
				case 0: //users cards
					deck.get(i).image = BitmapFactory.decodeResource(r, deck.get(i).resourceId);
					deck.get(i).location.x = (int) (surface.getWidth() * .1 + (deck.get(i).image.getWidth() + surface.cardSpacingTopBottom) * i);
					deck.get(i).location.y = (int) (surface.getHeight() - deck.get(i).image.getHeight());
					break;
				case 1: //left cards
					deck.get(i).image = surface.cardBackHorizontal;
					deck.get(i).location.x = (int)(- deck.get(i).image.getWidth() / 2);
					deck.get(i).location.y = (int) ((surface.getHeight() * .15) + 
							((deck.get(i).image.getHeight() + surface.cardSpacingLeftRight) * (i - 9)));
					break;
				case 2: //right cards
					deck.get(i).image = surface.cardBackHorizontal;
					deck.get(i).location.x = surface.getWidth() - (deck.get(i).image.getWidth() / 2);
					deck.get(i).location.y = (int) ((surface.getHeight() * .15) + 
							((deck.get(i).image.getHeight() + surface.cardSpacingLeftRight) * (i - 18)));
					break;
				case 3: //top cards
					deck.get(i).location.x = (int) (surface.getWidth() * .1 + (deck.get(i).image.getWidth() + surface.cardSpacingTopBottom) * (i - 27));
					deck.get(i).location.y = (int)(- deck.get(i).image.getHeight() / 2);
					break;
				default:
					break;
				}
				
				deck.get(i).draw(canvas);
			}
			currentState = CurrentState.bidding;
			break;
		default:
			break;
		}
	}

	public void chooseCard(Card card) {
		card.image = BitmapFactory.decodeResource(r, deck.remove(0).resourceId);
	}
}
