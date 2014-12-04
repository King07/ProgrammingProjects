package com.example.androiddevelopmentproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.DateFormat;
import android.util.Log;

/**
* Creates application database.
*
* @author group 1
*
*/

public class DBHelper extends SQLiteOpenHelper 
{

	// Logcat tag
    private static final String LOG = "DatabaseHelper";
    
    // Database Name
    private static final String DATABASE_NAME = "Tournament_db";
	
    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_ROUND = "round";
    private static final String KEY_ID_PLAYER_WHITE = "id_player_white";    
    private static final String KEY_ID_PLAYER_BLACK = "id_player_black";    
    private static final String KEY_WINNER_ID = "winner_id";        
    private static final String KEY_CREATED_AT = "creat_at";   
    private static final String KEY_UPDATED_AT = "update_at"; 
    
    // Table next five matches
    private static final String KEY_FIRST = "first";
    private static final String KEY_SECOND = "second";    
    private static final String KEY_THIRD = "third";  
    private static final String KEY_FOURTH = "fourth";
    private static final String KEY_FIFTH = "fifth";     
    
    
    
    
	// ------------------Table Players------------------
	
    // Table Name
    private static final String TABLE_PLAYERS = "Players";
     
    // column names
    private static final String KEY_FIRSTNAME = "fistname";
    private static final String KEY_LASTNAME = "lastname";    
    private static final String KEY_PRESENT = "present";    
    private static final String KEY_NEXT_PARING = "next_paring";   
    private static final String KEY_POINTS = "points"; 
    private static final String KEY_CURRENT_RATING = "current_rating";    
    private static final String KEY_RATING_START_OF_SEASON = "ratingStartOfSeason";     
    private static final String KEY_ISADMIN = "is_admin"; 
    private static final String KEY_ACTIVE = "active"; 
    private static final String KEY_MATCH_WHITE = "matches_white"; 
    private static final String KEY_MATCH_WHITE_WINS = "matches_white_win";
    private static final String KEY_MATCH_WHITE_DRAW = "matches_white_draw";
    private static final String KEY_MATCH_BLACK = "matches_black"; 
    private static final String KEY_MATCH_BLACK_WINS = "matches_black_win";
    private static final String KEY_MATCH_BLACK_DRAW = "matches_black_draw";
    
    
    // Table Create Statements
    private static final String CREATE_TABLE_PLAYERS = "CREATE TABLE "+ TABLE_PLAYERS 		
    								+ " ( " 
    								+ KEY_ID + " TEXT PRIMARY KEY, "  
    								+ KEY_FIRSTNAME + " TEXT NULL, " 
    								+ KEY_LASTNAME + " TEXT NULL, " 
    								//+ KEY_PRESENT + " BOOLEAN, " 
    								+ KEY_NEXT_PARING + " STRING, "
    								+ KEY_POINTS + " INTEGER NULL, "
    								+ KEY_CURRENT_RATING + " INTEGER NULL, "
    								//+ KEY_RATING_START_OF_SEASON + " INTEGER NULL, "
    								+ KEY_ISADMIN + " INTEGER NULL, "
    								+ KEY_ACTIVE + " INTEGER NULL, "
    								+ KEY_MATCH_WHITE + " INTEGER NULL, "
    								+ KEY_MATCH_WHITE_WINS + " INTEGER NULL, "
    								+ KEY_MATCH_WHITE_DRAW + " INTEGER NULL, "
    								+ KEY_MATCH_BLACK + " INTEGER NULL, "
    								+ KEY_MATCH_BLACK_WINS + " INTEGER NULL, "
    								+ KEY_MATCH_BLACK_DRAW + " INTEGER NULL, "
    								+ KEY_CREATED_AT + " TIME NULL, "
    								+ KEY_UPDATED_AT + " TIME NULL "	
    								+ ")";
 // ------------------Matches beker ------------------//
	
     // Table Name
     private static final String TABLE_MATCHES_BEKER = "matches_beker";
 
     // Table Create Statements
     private static final String CREATE_TABLE_MATCHES_BEKER = "CREATE TABLE "+ TABLE_MATCHES_BEKER 		
     								+ " ( " 
     								+ KEY_ID + " INTEGER PRIMARY KEY, "  
     								+ KEY_ROUND + " INTEGER, " 
     								+ KEY_ID_PLAYER_WHITE + " VARCHAR(3), " 
     								+ KEY_ID_PLAYER_BLACK + " VARCHAR(3), " 
     								+ KEY_WINNER_ID + " VARCHAR(3), "
     								+ KEY_CREATED_AT + " TIME NULL, "
     								+ KEY_UPDATED_AT + " TIME NULL "	
     								+ ")";
     
  // ------------------Matches Internal ------------------//
 	
     // Table Name
     private static final String TABLE_MATCHES_INTERNAL = "matches_internal";
       
     // Table Create Statements
     private static final String CREATE_TABLE_MATCHES_INTERNAL = "CREATE TABLE "+ TABLE_MATCHES_INTERNAL		
     								+ " ( " 
     								+ KEY_ID + " INTEGER PRIMARY KEY, "  
     								+ KEY_ROUND + " INTEGER, " 
     								+ KEY_ID_PLAYER_WHITE + " VARCHAR(3), " 
     								+ KEY_ID_PLAYER_BLACK + " VARCHAR(3), " 
     								+ KEY_WINNER_ID + " VARCHAR(3), "
     								+ KEY_CREATED_AT + " TIME NULL, "
     								+ KEY_UPDATED_AT + " TIME NULL "	
     								+ ")";    

     // ------------------Matches Kroongroup ------------------//
  	
     // Table Name
     private static final String TABLE_MATCHES_KROONGROUP = "matches_Kroongroup";
           
     // Table Create Statements
     private static final String CREATE_TABLE_MATCHES_KROONGROUP = "CREATE TABLE "+ TABLE_MATCHES_KROONGROUP 		
     								+ " ( " 
     								+ KEY_ID + " INTEGER PRIMARY KEY, "  
     								+ KEY_ROUND + " INTEGER, " 
     								+ KEY_ID_PLAYER_WHITE + " VARCHAR(3), " 
     								+ KEY_ID_PLAYER_BLACK + " VARCHAR(3), " 
     								+ KEY_WINNER_ID + " VARCHAR(3), "
     								+ KEY_CREATED_AT + " TIME NULL, "
     								+ KEY_UPDATED_AT + " TIME NULL "	
     								+ ")";      

     // ------------------Next five matches ------------------//
   	
     // Table Name
     private static final String TABLE_NEXT_FIVE_MATCHES = "next_Five_Matches";
           
     // Table Create Statements
     private static final String CREATE_TABLE_NEXT_FIVE_MATCHES = "CREATE TABLE "+ TABLE_NEXT_FIVE_MATCHES 		
     								+ " ( " 
     								+ KEY_ID + " VARCHAR(10) PRIMARY KEY, "  
     								+ KEY_FIRST + " VARCHAR(4), " 
     								+ KEY_SECOND+ " VARCHAR(4), "
     								+ KEY_THIRD + " VARCHAR(4), "
     								+ KEY_FOURTH + " VARCHAR(4), "
     								+ KEY_FIFTH + " VARCHAR(4) "
     								+ ")";       
     
   public DBHelper(Context context) 
   {
       // Databse: todos_db, Version: 1
       super(context, DATABASE_NAME, null, 1);
   }
 
  
   @Override
   public void onCreate(SQLiteDatabase db) 
   {
       // Execute create table SQL
       db.execSQL(CREATE_TABLE_PLAYERS);
       db.execSQL(CREATE_TABLE_MATCHES_BEKER);
       db.execSQL(CREATE_TABLE_MATCHES_INTERNAL);
       db.execSQL(CREATE_TABLE_MATCHES_KROONGROUP);
       db.execSQL(CREATE_TABLE_NEXT_FIVE_MATCHES);
   }
 
   /**
    * Recreates table
    */
   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer)
   {
	// on upgrade drop older tables
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATCHES_INTERNAL);
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATCHES_BEKER);
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATCHES_KROONGROUP);
       db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_NEXT_FIVE_MATCHES);
       onCreate(db);
   }
   
   // ------------------------ "Players" table methods ----------------//
   
   /*
    * Creating new player
    */
   public void createPlayer(Player Player) 
   {
   	SQLiteDatabase db = this.getWritableDatabase();
   	ContentValues values = new ContentValues();
   	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
   	long now = System.currentTimeMillis();
   	Calendar calendar = Calendar.getInstance();
   	calendar.setTimeInMillis(now);
   	values.put(KEY_ID, Player.getId());   	
   	values.put(KEY_FIRSTNAME, Player.getFirstName());
   	values.put(KEY_LASTNAME, Player.getLastName());
   //	values.put(KEY_PRESENT, Player.getStatus());
   	values.put(KEY_NEXT_PARING, Player.getNextPairing());
   	values.put(KEY_POINTS, Player.getPoints());
   	values.put(KEY_CURRENT_RATING, Player.getCurrentRating());
   //	values.put(KEY_RATING_START_OF_SEASON, Player.getCurrentRating());
   	values.put(KEY_ACTIVE, Player.getActive());
   	values.put(KEY_ISADMIN, Player.getIsAdmin());
   	values.put(KEY_MATCH_WHITE, Player.getMatchWhitePlayed());
   	values.put(KEY_MATCH_WHITE_WINS, Player.getMatchWhitePlayedWin());
   	values.put(KEY_MATCH_WHITE_DRAW, Player.getMatchWhitePlayedDraw());
   	values.put(KEY_MATCH_BLACK, Player.getMatchBlackPlayed());
   	values.put(KEY_MATCH_BLACK_WINS, Player.getMatchBlackPlayedWin());
   	values.put(KEY_MATCH_BLACK_DRAW, Player.getMatchBlackPlayedDraw());
   	values.put(KEY_CREATED_AT, formatter.format(calendar.getTime()));
   	//values.put(+KEY_UPDATED_AT, null);   	
    
   	   	
   	// Inserting Row
   	System.out.println("Player "+ Player);
   	db.insert(TABLE_PLAYERS, null, values);
   	
   	db.close(); //Closing the connection...
   }
   
  
  
   /*
    * Updating a Player
    */
   public int updatePlayer(Player player) 
   {
       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues values = new ContentValues();
       System.out.println("player "+player);
       values.put(KEY_ID, player.getId());   	
      	values.put(KEY_FIRSTNAME, player.getFirstName());
      	values.put(KEY_LASTNAME, player.getLastName());
      	//values.put(KEY_PRESENT, player.getStatus());
      	values.put(KEY_NEXT_PARING, player.getNextPairing());
      	values.put(KEY_POINTS, player.getPoints());
      	values.put(KEY_CURRENT_RATING, player.getCurrentRating());
      	//values.put(KEY_RATING_START_OF_SEASON, player.getCurrentRating());
      	values.put(KEY_ACTIVE, player.getActive());
      	values.put(KEY_ISADMIN, player.getIsAdmin());
      	values.put(KEY_MATCH_WHITE, player.getMatchWhitePlayed());
       	values.put(KEY_MATCH_WHITE_WINS, player.getMatchWhitePlayedWin());
       	values.put(KEY_MATCH_WHITE_DRAW, player.getMatchWhitePlayedDraw());
       	values.put(KEY_MATCH_BLACK, player.getMatchBlackPlayed());
       	values.put(KEY_MATCH_BLACK_WINS, player.getMatchBlackPlayedWin());
       	values.put(KEY_MATCH_BLACK_DRAW, player.getMatchBlackPlayedDraw());
      	//values.put(+KEY_UPDATED_AT, null);   	
       
      	 int update = db.update(TABLE_PLAYERS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(player.getId()) });
      	
      	 db.close(); //Closing the connection...
       // updating row
       return update;
   }
   
   /*
    * Retrieve a Player
    */
   
	public Player getPlayer(String PlayerId) 
   	{
        SQLiteDatabase db = this.getReadableDatabase();
     
        String selectQuery = "SELECT  * FROM " + TABLE_PLAYERS+ " WHERE "
                + KEY_ID + " = " + PlayerId;
     
        Log.e(LOG, selectQuery);
     
        Cursor c = db.rawQuery(selectQuery, null);
     
        if (c != null)
            c.moveToFirst();
     
        Player player = new Player();
        player.setId(c.getString(c.getColumnIndex(KEY_ID)));
        player.setFirstName((c.getString(c.getColumnIndex(KEY_FIRSTNAME))));
        player.setLastName(c.getString(c.getColumnIndex(KEY_LASTNAME)));
       // player.setStatus((c.getInt(c.getColumnIndex(KEY_PRESENT))));
        player.setNextPairing((c.getString(c.getColumnIndex(KEY_NEXT_PARING))));
        player.setPoints((c.getInt(c.getColumnIndex(KEY_POINTS))));
        player.setCurrentRating(c.getInt(c.getColumnIndex(KEY_CURRENT_RATING)));
        player.setIsAdmin((c.getInt(c.getColumnIndex(KEY_ISADMIN))));
        player.setActive((c.getInt(c.getColumnIndex(KEY_ACTIVE))));
        player.setMatchWhitePlayed((c.getInt(c.getColumnIndex(KEY_MATCH_WHITE))));
        player.setMatchWhitePlayedWin((c.getInt(c.getColumnIndex(KEY_MATCH_WHITE_WINS))));
        player.setMatchWhitePlayedDraw((c.getInt(c.getColumnIndex(KEY_MATCH_WHITE_DRAW))));
        player.setMatchBlackPlayed((c.getInt(c.getColumnIndex(KEY_MATCH_BLACK))));
        player.setMatchBlackPlayedWin((c.getInt(c.getColumnIndex(KEY_MATCH_BLACK_WINS))));
        player.setMatchBlackPlayedDraw((c.getInt(c.getColumnIndex(KEY_MATCH_BLACK_DRAW))));
        db.close(); //Closing the connection...
        return player;
        

       	
    }
	/*
	    * getting all Player
	    */
   	public ArrayList<Player> getAllPlayer() 
   	{
 	   SQLiteDatabase db = this.getWritableDatabase();
 	   ArrayList<Player> PlayerList = new ArrayList<Player>();
  
        
     // Select All Query
        String selectQuery = "SELECT  * FROM  "+TABLE_PLAYERS;
  
        // Query the database
        
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
  
        
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
         	   Player player = new Player();
         	   player.setId(cursor.getString(0));
         	   player.setFirstName(cursor.getString(1));
         	   player.setLastName(cursor.getString(2));
         	  // player.setS (Boolean.getBoolean(cursor.getString(3)));
         	   player.setNextPairing((cursor.getString(3)));
         	   player.setPoints((Integer.parseInt(cursor.getString(4))));
         	   player.setCurrentRating(Integer.parseInt(cursor.getString(5)));
         	   player.setIsAdmin(Integer.parseInt(cursor.getString(6)));
         	   player.setActive(Integer.parseInt(cursor.getString(7)));
         	   player.setMatchWhitePlayed(cursor.getInt(8));
         	   player.setMatchWhitePlayedWin(cursor.getInt(9));
         	   player.setMatchWhitePlayedDraw(cursor.getInt(10));
         	   player.setMatchWhitePlayedLost(cursor.getInt(8)-(cursor.getInt(9)+cursor.getInt(10)));
         	  player.setMatchBlackPlayed(cursor.getInt(11));
        	   player.setMatchBlackPlayedWin(cursor.getInt(12));
        	   player.setMatchBlackPlayedDraw(cursor.getInt(13));
        	   player.setMatchBlackPlayedLost(cursor.getInt(11)-(cursor.getInt(12)+cursor.getInt(13)));
         	   	
                // Adding contact to list
         	   PlayerList.add(player);
            } while (cursor.moveToNext());
        }
        db.close(); //Closing the connection...
        return PlayerList;
   	
   }
   
   
   /*
    * Deleting a Player
    */
   public void deletePlayer(Player player) 
   {
       SQLiteDatabase db = this.getWritableDatabase();
       db.delete(TABLE_PLAYERS, KEY_ID + " = ?",
               new String[] { String.valueOf(player.getId()) });
   }
   
  
   
// ------------------------ "Matches beker" table methods ----------------//
   
   /*
    * Creating beker match
    */
   public void createBekerMatch(MatchBeker MB) 
   {
   	
	SQLiteDatabase db = this.getWritableDatabase();
   	ContentValues values = new ContentValues();
   	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
   	long now = System.currentTimeMillis();
   	Calendar calendar = Calendar.getInstance();
   	calendar.setTimeInMillis(now);
   //	values.put(KEY_ID, MB.getId());   	
   	values.put(KEY_ID_PLAYER_WHITE, MB.getPlayerIdWhite());
   	values.put(KEY_ID_PLAYER_BLACK, MB.getPlayerIdBlack());
   	values.put(KEY_ROUND, MB.getRound());
   	values.put(KEY_WINNER_ID, MB.getWinnerId());
   	values.put(KEY_CREATED_AT, formatter.format(calendar.getTime()));
    //values.put(+KEY_UPDATED_AT, null);   	
    
   	   	
   	// Inserting Row
   	System.out.println("Match Berker "+ MB);
   	db.insert(TABLE_MATCHES_BEKER, null, values);
   	db.close(); //Closing the connection...
   	
   }
   
	/*
    * getting all MatchBeker
    */
	public ArrayList<MatchBeker> getAllMatchBaker() 
	{
	   SQLiteDatabase db = this.getWritableDatabase();
	   ArrayList<MatchBeker> allMatchBeker = new ArrayList<MatchBeker>();

    
 // Select All Query
    String selectQuery = "SELECT  * FROM  "+TABLE_MATCHES_BEKER;

    // Query the database
    
    Cursor cursor = db.rawQuery(selectQuery, null);
    cursor.moveToFirst();

    
    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
     	   MatchBeker matchBaker = new MatchBeker();
     	  matchBaker.setId(cursor.getInt(0));
     	 matchBaker.setRound(cursor.getInt(1));
     	matchBaker.setPlayerIdWhite(cursor.getString(2));
     	  // player.setS (Boolean.getBoolean(cursor.getString(3)));
     	matchBaker.setPlayerIdBlack((cursor.getString(3)));
     	matchBaker.setWinnerId((cursor.getString(4)));
     	   	
            // Adding contact to list
     	   allMatchBeker.add(matchBaker);
        } while (cursor.moveToNext());
    }
    db.close(); //Closing the connection...
    return allMatchBeker;
	
}
  
   /*
    * Updating a Matche_Beker
    */
   public int updateMatchBeker(MatchBeker MB) 
   {
       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues values = new ContentValues();
       System.out.println("match beker "+ MB);
        values.put(KEY_ID, MB.getId());   	
      	values.put(KEY_ID_PLAYER_WHITE, MB.getPlayerIdWhite());
      	values.put(KEY_ID_PLAYER_BLACK, MB.getPlayerIdBlack());
      	values.put(KEY_ROUND, MB.getRound());
      	values.put(KEY_WINNER_ID, MB.getWinnerId());
      	//values.put(+KEY_UPDATED_AT, null);   	
       
      	 int update = db.update(TABLE_MATCHES_BEKER, values, KEY_ID + " = ?",
                                new String[] { String.valueOf(MB.getId()) });
      	
      	 db.close(); //Closing the connection...
       // updating row
       return update;
   }
   
   /*
    * Deleting a match beker
    */
   public void deleteMatchBeker(MatchBeker MB) 
   {
       SQLiteDatabase db = this.getWritableDatabase();
       db.delete(TABLE_MATCHES_BEKER, KEY_ID + " = ?",
               new String[] { String.valueOf(MB.getId()) });
   }
   
// ------------------------ "Matches Internal" table methods ----------------//
   
   /*
    * Creating Internal Match
    */
   public void createInternalMatch(MatchInternal MI) 
   {
   	
	SQLiteDatabase db = this.getWritableDatabase();
   	ContentValues values = new ContentValues();
   	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
   	long now = System.currentTimeMillis();
   	Calendar calendar = Calendar.getInstance();
   	calendar.setTimeInMillis(now);
   	//values.put(KEY_ID, MI.getId());   	
   	values.put(KEY_ID_PLAYER_WHITE, MI.getPlayerIdWhite());
   	values.put(KEY_ID_PLAYER_BLACK, MI.getPlayerIdBlack());
   	values.put(KEY_ROUND, MI.getRound());
   	values.put(KEY_WINNER_ID, MI.getWinnerId());
   	values.put(KEY_CREATED_AT, formatter.format(calendar.getTime()));
    //values.put(+KEY_UPDATED_AT, null);   	
    
   	   	
   	// Inserting Row
   	System.out.println("Match Internal "+ MI);
   	db.insert(TABLE_MATCHES_INTERNAL, null, values);
   	db.close(); //Closing the connection...
   	
   }
   
   /*
    * getting all MatchInternal
    */
	public ArrayList<MatchInternal> getAllMatchInternal() 
	{
	   SQLiteDatabase db = this.getWritableDatabase();
	   ArrayList<MatchInternal> allMatchInternal = new ArrayList<MatchInternal>();

    
 // Select All Query
    String selectQuery = "SELECT  * FROM  "+TABLE_MATCHES_INTERNAL;

    // Query the database
    
    Cursor cursor = db.rawQuery(selectQuery, null);
    cursor.moveToFirst();

    
    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
     	   MatchInternal matchInternal = new MatchInternal();
     	  matchInternal.setId(cursor.getInt(0));
     	 matchInternal.setRound(cursor.getInt(1));
     	matchInternal.setPlayerIdWhite(cursor.getString(2));
     	  // player.setS (Boolean.getBoolean(cursor.getString(3)));
     	matchInternal.setPlayerIdBlack((cursor.getString(3)));
     	matchInternal.setWinnerId((cursor.getString(4)));
     	   	
            // Adding contact to list
     	   allMatchInternal.add(matchInternal);
        } while (cursor.moveToNext());
    }
    db.close(); //Closing the connection...
    return allMatchInternal;
	
}
  
   /*
    * Updating a Internal Matches
    */
   public int updateInternalMatch(MatchInternal MI) 
   {
       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues values = new ContentValues();
       System.out.println("match Internal "+ MI);
        values.put(KEY_ID, MI.getId());   	
      	values.put(KEY_ID_PLAYER_WHITE, MI.getPlayerIdWhite());
      	values.put(KEY_ID_PLAYER_BLACK, MI.getPlayerIdBlack());
      	values.put(KEY_ROUND, MI.getRound());
      	values.put(KEY_WINNER_ID, MI.getWinnerId());
      	//values.put(+KEY_UPDATED_AT, null);   	
       
      	 int update = db.update(TABLE_MATCHES_INTERNAL, values, KEY_ID + " = ?",
                                new String[] { String.valueOf(MI.getId()) });
      	
      	 db.close(); //Closing the connection...
       // updating row
       return update;
   }
   
   /*
    * Deleting Internal Matches
    */
   public void deleteMatchInternal(MatchInternal MI) 
   {
       SQLiteDatabase db = this.getWritableDatabase();
       db.delete(TABLE_MATCHES_INTERNAL, KEY_ID + " = ?",
               new String[] { String.valueOf(MI.getId()) });
   }
   
// ------------------------ "Matches Kroongroup" table methods ----------------//
   
   /*
    * Creating Kroongroup Match
    */
   public void createKroongroupMatch(MatchKroongroup MK) 
   {
   	
	SQLiteDatabase db = this.getWritableDatabase();
   	ContentValues values = new ContentValues();
   	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
   	long now = System.currentTimeMillis();
   	Calendar calendar = Calendar.getInstance();
   	calendar.setTimeInMillis(now);
   //	values.put(KEY_ID, MK.getId());   	
   	values.put(KEY_ID_PLAYER_WHITE, MK.getPlayerIdWhite());
   	values.put(KEY_ID_PLAYER_BLACK, MK.getPlayerIdBlack());
   	values.put(KEY_ROUND, MK.getRound());
   	values.put(KEY_WINNER_ID, MK.getWinnerId());
   	values.put(KEY_CREATED_AT, formatter.format(calendar.getTime()));
    //values.put(+KEY_UPDATED_AT, null);   	
    
   	   	
   	// Inserting Row
   	System.out.println("Match Kroongroup "+ MK);
   	db.insert(TABLE_MATCHES_KROONGROUP, null, values);
   	db.close(); //Closing the connection...
   	
   }
   
  
   /*
    * getting all MatchKroongroup
    */
	public ArrayList<MatchKroongroup> getAllMatchKroongroup() 
	{
	   SQLiteDatabase db = this.getWritableDatabase();
	   ArrayList<MatchKroongroup> allMatchKroongroup = new ArrayList<MatchKroongroup>();

    
 // Select All Query
    String selectQuery = "SELECT  * FROM  "+TABLE_MATCHES_KROONGROUP;

    // Query the database
    
    Cursor cursor = db.rawQuery(selectQuery, null);
    cursor.moveToFirst();

    
    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
     	   MatchKroongroup matchKroongroup = new MatchKroongroup();
     	  matchKroongroup.setId(cursor.getInt(0));
     	 matchKroongroup.setRound(cursor.getInt(1));
     	matchKroongroup.setPlayerIdWhite(cursor.getString(2));
     	  // player.setS (Boolean.getBoolean(cursor.getString(3)));
     	matchKroongroup.setPlayerIdBlack((cursor.getString(3)));
     	matchKroongroup.setWinnerId((cursor.getString(4)));
     	   	
            // Adding contact to list
     	   allMatchKroongroup.add(matchKroongroup);
        } while (cursor.moveToNext());
    }
    db.close(); //Closing the connection...
    return allMatchKroongroup;
	
}
   /*
    * Updating a Kroongroup Matches
    */
   public int updateKroongroupMatch(MatchKroongroup MK) 
   {
       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues values = new ContentValues();
       System.out.println("match Kroongroup "+ MK);
        values.put(KEY_ID, MK.getId());   	
      	values.put(KEY_ID_PLAYER_WHITE, MK.getPlayerIdWhite());
      	values.put(KEY_ID_PLAYER_BLACK, MK.getPlayerIdBlack());
      	values.put(KEY_ROUND, MK.getRound());
      	values.put(KEY_WINNER_ID, MK.getWinnerId());
      	//values.put(+KEY_UPDATED_AT, null);   	
       
      	 int update = db.update(TABLE_MATCHES_KROONGROUP, values, KEY_ID + " = ?",
                                new String[] { String.valueOf(MK.getId()) });
      	
      	 db.close(); //Closing the connection...
       // updating row
       return update;
   }
   
   /*
    * Deleting Kroongroup Matches
    */
   public void deleteMatchKroongroup(MatchKroongroup MK) 
   {
       SQLiteDatabase db = this.getWritableDatabase();
       db.delete(TABLE_MATCHES_KROONGROUP, KEY_ID + " = ?",
               new String[] { String.valueOf(MK.getId()) });
   }   
   
// ------------------------ "Next 5 matches" table methods ----------------//
   
   /*
    * Creating Next Five Matches
    */
   public void createNextFiveMatch(NextFiveRound NFM)
   {
   	
	SQLiteDatabase db = this.getWritableDatabase();
   	ContentValues values = new ContentValues();
   //	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
   	long now = System.currentTimeMillis();
   	Calendar calendar = Calendar.getInstance();
   	calendar.setTimeInMillis(now);
   	values.put(KEY_ID, NFM.getId());   	
   	values.put(KEY_FIRST, NFM.getFirst());
   	values.put(KEY_SECOND, NFM.getSecond());
   	values.put(KEY_THIRD, NFM.getThird());
   	values.put(KEY_FOURTH, NFM.getFourth());
   	values.put(KEY_THIRD, NFM.getFourth());
   	//values.put(KEY_CREATED_AT, formatter.format(calendar.getTime()));
    //values.put(+KEY_UPDATED_AT, null);   	
    
   	   	
   	// Inserting Row
   	System.out.println("Next five matches "+ NFM);
   	db.insert(TABLE_NEXT_FIVE_MATCHES, null, values);
   	db.close(); //Closing the connection...
   	
   }
   
  
  
   /*
    * Updating a Next Five Matches
    */
   public int updateNextFiveMatch(NextFiveRound NFM) 
   {
       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues values = new ContentValues();
       System.out.println("match Kroongroup "+ NFM);
      	values.put(KEY_ID, NFM.getId());   	
       	values.put(KEY_FIRST, NFM.getFirst());
       	values.put(KEY_SECOND, NFM.getSecond());
       	values.put(KEY_THIRD, NFM.getThird());
       	values.put(KEY_FOURTH, NFM.getFourth());
       	values.put(KEY_THIRD, NFM.getFourth());
      	//values.put(+KEY_UPDATED_AT, null);   	
       
      	 int update = db.update(TABLE_NEXT_FIVE_MATCHES, values, KEY_ID + " = ?",
                                new String[] { String.valueOf(NFM.getId()) });
      	
      	 db.close(); //Closing the connection...
       // updating row
       return update;
   }
   
   /*
    * Deleting Next Five Matches
    */
   public void deleteNextFiveMatch(NextFiveRound NFM) 
   {
       SQLiteDatabase db = this.getWritableDatabase();
       db.delete(TABLE_NEXT_FIVE_MATCHES, KEY_ID + " = ?",
               new String[] { String.valueOf(NFM.getId()) });
   }  
   
   //-------------------------- Other methods-----------------------------------//
   
   /*
    *  Master Rest
    */
   
   public void masterRest( )
   {
       SQLiteDatabase db = this.getWritableDatabase();
	   db.execSQL("DROP TABLE " + TABLE_PLAYERS);
       db.execSQL("DROP TABLE " + TABLE_MATCHES_INTERNAL);
       db.execSQL("DROP TABLE " + TABLE_MATCHES_BEKER);
       db.execSQL("DROP TABLE " + TABLE_MATCHES_KROONGROUP);
       db.execSQL("DROP TABLE " + TABLE_NEXT_FIVE_MATCHES);       
       onCreate(db);
	
   }
   
}
