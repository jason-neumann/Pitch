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
	protected Bitmap cardback1;
	protected Bitmap cardback2;
	protected Point cardSpot;
	
	protected Point screenSize;
	
	protected MainThread thread;
	
	protected int speed;
	
	public MainPanel(Context context) {
		super(context);
		
		getHolder().addCallback(this);
		
		Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		screenSize = new Point();
		display.getSize(screenSize);
		
		Bitmap originalCard = BitmapFactory.decodeResource(getResources(),R.drawable.card_back);
		cardback1 = Bitmap.createScaledBitmap(originalCard, (int)(screenSize.x * .1), (int)(screenSize.x * .13), true);
		cardback2 = Bitmap.createScaledBitmap(originalCard, (int)(screenSize.x * .1), (int)(screenSize.x * .13), true);
		
		cardSpot = new Point();
		cardSpot.x = (int) (screenSize.x * .1);
		cardSpot.y = (int) (screenSize.y * .1);
		
		// create the game loop thread
		thread = new MainThread(getHolder(), this);
				
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}
	
	public void setCardSpot(int x,int y) {
		cardSpot.x = x;
		cardSpot.y = y;
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
		canvas.drawBitmap(cardback1,
				cardSpot.x,
				cardSpot.y,
				null);
		canvas.drawBitmap(cardback2, (int)(screenSize.x * .1), (int)(screenSize.y * .1), null);
	}

	/**
	 * This is the game update method. It iterates through all the objects
	 * and calls their update method if they have one or calls specific
	 * engine's update method.
	 */
	public void update() {
		cardSpot.y += 7;
		
		if(cardSpot.y > (getHeight() * .8)) {
			thread.setRunning(false);
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}
}
