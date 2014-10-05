package com.neucode.pitch;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

public class Card {
	public Bitmap image;
	public Point location;

	public Card(Bitmap image, Point location) {
		this.image = image;
		this.location = location;
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(image, location.x - (image.getWidth() / 2), location.y - (image.getHeight() / 2), null);
	}
	
	public void update() {
		location.y += 7;
	}
}
