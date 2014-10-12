package com.neucode.pitch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

public class MainPanel extends SurfaceView implements
SurfaceHolder.Callback{
	protected static final int DECK_SIZE = 52;
	
	protected Card[] deck; 
	
	protected Point screenSize;
	
	protected MainThread thread;
	
	protected int speed;
	
	protected Dealer dealer;
	
	public MainPanel(Context context) {
		super(context);
		
		getHolder().addCallback(this);
		
		Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		screenSize = new Point();
		display.getSize(screenSize);
		
		dealer = new Dealer();
		
		deck = new Card[DECK_SIZE];
		Bitmap originalCard = BitmapFactory.decodeResource(getResources(),R.drawable.card_back);
		
		for(int i = 0; i < DECK_SIZE; i ++) {
			deck[i] = new Card(
					Bitmap.createScaledBitmap(
							originalCard,
							(int)(screenSize.x * .2),
							(int)(screenSize.x * .26),
							true),
					new Point(
							(int) (screenSize.x * .2),
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
		canvas.drawColor(Color.rgb(39, 119, 20));

		Matrix matrix = new Matrix();
		matrix.postRotate(90);
		for(int i = 0; i < 36; i++) {
			switch(i/9) {
			case 0:
				deck[i].location.x = (int) ((getWidth() * .2) + (deck[i].image.getWidth() * i * .35));
				deck[i].location.y = (int) (getHeight() * .8);
				break;
			case 1:
				deck[i].image = Bitmap.createBitmap(deck[i].image, 0, 0, deck[i].image.getWidth(), deck[i].image.getHeight(), matrix, true);

				deck[i].location.x = (int) (getWidth() * .2);
				deck[i].location.y = (int) ((getHeight() * .2) + (deck[i].image.getWidth() * (i - 9) * .35));
				break;
			case 2:
				deck[i].image = Bitmap.createBitmap(deck[i].image, 0, 0, deck[i].image.getWidth(), deck[i].image.getHeight(), matrix, true);
				
				deck[i].location.x = (int) (getWidth() * .8);
				deck[i].location.y = (int) ((getHeight() * .2) + (deck[i].image.getWidth() * (i - 18) * .35));
				break;
			case 3:
				deck[i].location.x = (int) ((getWidth() * .2) + (deck[i].image.getWidth() * (i - 27) * .35));
				deck[i].location.y = (int) (getHeight() * .2);
				break;
			default:
				break;
			}
			
			deck[i].draw(canvas);
		}
		Log.d("pitch", "done");
		this.thread.setRunning(false);
	}

	/**
	 * This is the game update method. It iterates through all the objects
	 * and calls their update method if they have one or calls specific
	 * engine's update method.
	 */
	public void update() {
//		switch (dealer.currentState) {
//		case first9:
//			for(int i = dealer.topCard; i < dealer.topCard + 3; i++) {
//				deck[i].update();
//			}
//			if(dealer.topCard >= 9) {
//				this.thread.setRunning(false);
//			}
//			break;
//		case bidding:
//			break;
//		case dealt:
//			break;
//		case drawUp:
//			break;
//		case giveWidow:
//			break;
//		default:
//			break;
//		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}
}
