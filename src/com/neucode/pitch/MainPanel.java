package com.neucode.pitch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

public class MainPanel extends SurfaceView implements
SurfaceHolder.Callback{
	protected Card[] deck; 
	
	protected Point screenSize;
	
	protected MainThread thread;
	
	protected int speed;
	
	public MainPanel(Context context) {
		super(context);
		
		getHolder().addCallback(this);
		
		Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		screenSize = new Point();
		display.getSize(screenSize);
		
		deck = new Card[52];
		Bitmap originalCard = BitmapFactory.decodeResource(getResources(),R.drawable.card_back);
		
		for(int i = 0; i < 52; i ++) {
			deck[i] = new Card(
					Bitmap.createScaledBitmap(
							originalCard,
							(int)(screenSize.x * .1),
							(int)(screenSize.x * .13),
							true),
					new Point(
							(int) (screenSize.x * .1),
							(int) (screenSize.y * .1))
			);
		}
		
		// create the game loop thread
		thread = new MainThread(getHolder(), this);
				
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// at this point the surface is created and
		// we can safely start the game loop
		thread.setRunning(true);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// tell the thread to shut down and wait for it to finish
		// this is a clean shutdown
		boolean retry = true;
		while (retry) {
			try {
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
				// try again shutting down the thread
			}
		}
	}
	
	public void render(Canvas canvas) {
		canvas.drawColor(Color.WHITE);
		for(int i = 0; i < 52; i++) {
			deck[i].draw(canvas);
		}
	}

	/**
	 * This is the game update method. It iterates through all the objects
	 * and calls their update method if they have one or calls specific
	 * engine's update method.
	 */
	public void update() {
		
		for(int i = 0; i < 52; i++) {
			deck[0].update();
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}
}
