package com.neucode.pitch;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class LocalDb extends SQLiteOpenHelper {
	public static final int DB_VERSION = 1;

	public LocalDb(Context context) {
		super(context, "pitch", null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d("pitch", "creating db");
		db.execSQL("CREATE TABLE users ( " +
				"userId INT UNSIGNED NOT NULL PRIMARY KEY, " +
				"userName VARCHAR(255) NOT NULL, " +
				"password CHAR(32) NOT NULL);");

		db.execSQL("CREATE TABLE teams (" +
				"teamId INT UNSIGNED NOT NULL PRIMARY KEY," +
				"player1 INT UNSIGNED NOT NULL," +
				"player2 INT UNSIGNED NULL);");

		db.execSQL("CREATE TABLE games (" +
				"gameId INT UNSIGNED NOT NULL PRIMARY KEY," +
			    "team1 INT UNSIGNED NOT NULL," +
			    "team2 INT UNSIGNED NULL," +
			    "gameState VARCHAR(25)," +
			    "orderOfPlay VARCHAR(40) NULL," +
			    "currentPlayerTurn INT UNSIGNED NULL," +
			    "team1Score TINYINT NOT NULL DEFAULT 0," +
			    "team2Score TINYINT NOT NULL DEFAULT 0);");

		db.execSQL("CREATE TABLE rounds (" +
			"roundId INT UNSIGNED NOT NULL PRIMARY KEY," +
		    "trumpSuit VARCHAR(10) NOT NULL DEFAULT ''," +
		    "bid TINYINT UNSIGNED NOT NULL DEFAULT 0);");

		db.execSQL("CREATE TABLE cards (" +
			"cardId INT UNSIGNED NOT NULL PRIMARY KEY," +
		    "suite VARCHAR(10)," +
		    "value INT UNSIGNED NOT NULL DEFAULT 0);");

		db.execSQL("CREATE TABLE books (" +
			"bookId INT UNSIGNED NOT NULL PRIMARY KEY," +
		    "roundId INT UNSIGNED NOT NULL," +
		    "playerId INT UNSIGNED NOT NULL," +
		    "cardId INT UNSIGNED NULL," +
		    "winningTeam INT UNSIGNED NULL);");

		db.execSQL("CREATE TABLE playerRoundCardMap (" +
			"roundId INT UNSIGNED NOT NULL," +
		    "playerId INT UNSIGNED NULL," +
		    "cardId INT UNSIGNED NOT NULL);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
