package com.neucode.pitch;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

public class Card {
	public Bitmap image;
	public Point location;
	
	protected int resourceId;
	protected int cardValue = 0;
	protected String suite;

	public Card(Bitmap image, Point location, int resourceId, String suite, int value) {
		this.image = image;
		this.location = location;
		this.resourceId = resourceId;
		this.suite = suite;
		cardValue = value;
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(image, location.x, location.y, null);
	}
	
	public void update() {
		location.y += 5;
	}
}
