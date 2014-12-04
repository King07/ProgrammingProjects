package com.example.political;

import java.util.ArrayList;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
* Creates application database.
*
* @author itcuties
*
*/
public class TodoSQLiteHelper extends SQLiteOpenHelper {
	// Logcat tag
    private static final String LOG = "DatabaseHelper";

	// Database Name
    private static final String DATABASE_NAME = "politicalParties_db";
 
    // Table Names
    private static final String TABLE_POLITICAL_PARTIES = "politicalParties";
    private static final String TABLE_POLITICAL_PROMISES = "PoliticalPromises";
    //private static final String TABLE_POLITICAL_PARTIES_PROMISES = "politicalPartiyPromises";
 
    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_DESCRIPTION = "description";
    
    
 
    // PoliticalParty Table - column nmaes
    private static final String KEY_NAME = "name";
    //private static final String KEY_RELIABILITY_INDEX = "reliable_index";
    // PoliticalPromises Table - column names
    private static final String KEY_PROMISE = "promise";
    private static final String KEY_PLUS = "plus";
    private static final String KEY_MINUS = "minus";
    private static final String KEY_EQUAL = "equal";
    private static final String KEY_IMAGE = "image";
 
    // NOTE_TAGS Table - column names
    private static final String KEY_PROMISE_ID = "politicalPromises_id";
 
    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_POLITICAL_PARTIES = "CREATE TABLE "
            + TABLE_POLITICAL_PARTIES + " ( " + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME
            + " TEXT NULL, " + KEY_DESCRIPTION + " TEXT NULL, " + KEY_PLUS + " TEXT NULL, " + KEY_EQUAL + " TEXT NULL, " + KEY_MINUS + " TEXT NULL, "+ KEY_IMAGE + " INTEGER NULL " + ")";
 
    // Tag table create statement
    private static final String CREATE_TABLE_POLITICAL_PROMISES = "CREATE TABLE " + TABLE_POLITICAL_PROMISES
            + " ( " + KEY_PROMISE_ID + " INTEGER PRIMARY KEY, " + KEY_ID + " INTEGER, " + KEY_PROMISE + " TEXT NULL, "
            + KEY_DESCRIPTION + " TEXT NULL, "+ " CONSTRAINT ppk FOREIGN KEY ("+KEY_ID+") REFERENCES "+TABLE_POLITICAL_PARTIES+ "("+KEY_ID+") ON DELETE CASCADE ON UPDATE CASCADE"+ ")";
 

    
    
 
   public TodoSQLiteHelper(Context context) {
       // Databse: todos_db, Version: 1
       super(context, DATABASE_NAME, null, 1);
   }
 
   /**
    * Create simple table
    * PoliticalParties
    *         _id     - key
    *         name    - text
    *         description   - text
    *         plus - text
    *         minus - text
    *         equal - text
    *         image - int
    *         
    *         
    *         
    * PoliticalPromises
    *         _id     - key
    *         party_id     - Fkey
    *         promise    - text
    *         description   - text
  
    *         
    *         
    */
   @Override
   public void onCreate(SQLiteDatabase db) {
       // Execute create table SQL
       db.execSQL(CREATE_TABLE_POLITICAL_PARTIES);
       db.execSQL(CREATE_TABLE_POLITICAL_PROMISES);
   }
 
   /**
    * Recreates table
    */
   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
	// on upgrade drop older tables
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_POLITICAL_PARTIES);
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_POLITICAL_PROMISES);
       onCreate(db);
   }
   // ------------------------ "Political Parties" table methods ----------------//
   
   // Adding new  Political ITEM
   public void addPoliticalItem(PoliticalParty politicalParty) {
   	
   	SQLiteDatabase db = this.getWritableDatabase();
   	ContentValues values = new ContentValues();
   	values.put(KEY_NAME, politicalParty.getNamet());
   	values.put(KEY_DESCRIPTION, politicalParty.getDecription());
   	values.put(KEY_IMAGE, politicalParty.getImage());
   	values.put(KEY_PLUS, politicalParty.getPlus() );
   	values.put(KEY_EQUAL, politicalParty.getEqual() );
   	values.put(KEY_MINUS, politicalParty.getMinus());
   	// Inserting Row
   	System.out.println("Political "+politicalParty );
   	db.insert(TABLE_POLITICAL_PARTIES, null, values);
   	
   	db.close(); //Closing the connection...
   }
   
   /*
    * get single Political party
    */
   public PoliticalParty getPoliticalParty(int politicalParty_id) {
       SQLiteDatabase db = this.getReadableDatabase();
    
       String selectQuery = "SELECT  * FROM " + TABLE_POLITICAL_PARTIES + " WHERE "
               + KEY_ID + " = " + politicalParty_id;
    
      /// Log.e(LOG, selectQuery);
    
       Cursor c = db.rawQuery(selectQuery, null);
    
       if (c != null)
           c.moveToFirst();
    
       PoliticalParty pp = new PoliticalParty();
       pp.setId(c.getInt(c.getColumnIndex(KEY_ID)));
       pp.setName((c.getString(c.getColumnIndex(KEY_NAME))));
       pp.setDecription(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
       pp.setImage(c.getColumnIndex(KEY_IMAGE));
       pp.setPlus(c.getColumnIndex(KEY_PLUS));
       pp.setEqual(c.getColumnIndex(KEY_EQUAL));
       pp.setMinus(c.getColumnIndex(KEY_DESCRIPTION));
       db.close(); //Closing the connection...
       return pp;
   }
   
   public ArrayList<PoliticalParty> getPoliticalParties() {
	   SQLiteDatabase db = this.getWritableDatabase();
	   ArrayList<PoliticalParty> politicalPartyList = new ArrayList<PoliticalParty>();
 
       // Name of the columns we want to select
     //  String[] tableColumns = new String[] {"_id","todo"};
       
    // Select All Query
       String selectQuery = "SELECT  * FROM  "+TABLE_POLITICAL_PARTIES;
 
       // Query the database
       
       Cursor cursor = db.rawQuery(selectQuery, null);
       cursor.moveToFirst();
 
       
       // looping through all rows and adding to list
       if (cursor.moveToFirst()) {
           do {
        	   PoliticalParty politicalParty = new PoliticalParty();
        	   politicalParty.setId(Integer.parseInt(cursor.getString(0)));
        	   politicalParty.setName(cursor.getString(1));
        	   politicalParty.setDecription(cursor.getString(2));
        	   politicalParty.setPlus(Integer.parseInt(cursor.getString(3)));
        	   politicalParty.setEqual(Integer.parseInt(cursor.getString(4)));
        	   politicalParty.setMinus(Integer.parseInt(cursor.getString(5)));
        	   politicalParty.setImage(cursor.getInt(6));
               
               // Adding contact to list
        	   politicalPartyList.add(politicalParty);
           } while (cursor.moveToNext());
       }
       db.close(); //Closing the connection...
       return politicalPartyList;
   }
   
  
   // Adding new  Political Promises ITEM
   public void addPoliticalPromiseItem(PoliticalPartyPromise politicalPartyPromise, int id) {
   	
   	SQLiteDatabase db = this.getWritableDatabase();
   	ContentValues values = new ContentValues();
   	values.put(KEY_ID, id);
   	values.put(KEY_PROMISE, politicalPartyPromise.getPromise());
   	values.put(KEY_DESCRIPTION, politicalPartyPromise.getDecription());
   	// Inserting Row
   	db.insert(TABLE_POLITICAL_PROMISES, null, values);
   	
   	db.close(); //Closing the connection...
   }
   
   /*
    * get single Political party
    */
   public PoliticalPartyPromise getPoliticalPromise(long politicalPromises_id) {
       SQLiteDatabase db = this.getReadableDatabase();
    
       String selectQuery = "SELECT  * FROM " + TABLE_POLITICAL_PROMISES+ " WHERE "
               + KEY_ID + " = " + politicalPromises_id;
    
       Log.e(LOG, selectQuery);
    
       Cursor c = db.rawQuery(selectQuery, null);
    
       if (c != null)
           c.moveToFirst();
    
       PoliticalPartyPromise pp = new PoliticalPartyPromise();
       pp.setId(c.getInt(c.getColumnIndex(KEY_ID)));
       pp.setPromise((c.getString(c.getColumnIndex(KEY_PROMISE))));
       pp.setDecription(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
       db.close(); //Closing the connection...
       return pp;
   }
   
   public ArrayList<PoliticalPartyPromise> getPoliticalPromise(int id) {
	   SQLiteDatabase db = this.getWritableDatabase();
	   ArrayList<PoliticalPartyPromise> politicalPartyList = new ArrayList<PoliticalPartyPromise>();
 
       // Name of the columns we want to select
     //  String[] tableColumns = new String[] {"_id","todo"};
       
    // Select All Query
       String selectQuery = "SELECT  * FROM  "+TABLE_POLITICAL_PROMISES+ " WHERE "+KEY_ID+" = "+id;
 
       // Query the database
       
       Cursor cursor = db.rawQuery(selectQuery, null);
       cursor.moveToFirst();
 
       
       // looping through all rows and adding to list
       if (cursor.moveToFirst()) {
           do {
        	   PoliticalPartyPromise politicalPartyPromise = new PoliticalPartyPromise();
        	   politicalPartyPromise.setId(Integer.parseInt(cursor.getString(0)));
        	   politicalPartyPromise.setPromise(cursor.getString(2));
        	   politicalPartyPromise.setDecription(cursor.getString(3));
        	   
               
               // Adding contact to list
        	   politicalPartyList.add(politicalPartyPromise);
           } while (cursor.moveToNext());
       }
       db.close(); //Closing the connection...
       return politicalPartyList;
   }
   
   /*
    * Updating a Political party
    */
   public int updatePoliticalParty(PoliticalParty politicalParty) {
       SQLiteDatabase db = this.getWritableDatabase();
       System.out.println("Political "+politicalParty );
       ContentValues values = new ContentValues();
       values.put(KEY_NAME, politicalParty.getNamet());
      	values.put(KEY_DESCRIPTION, politicalParty.getDecription());
      	values.put(KEY_PLUS, politicalParty.getPlus() );
      	values.put(KEY_EQUAL, politicalParty.getEqual() );
      	values.put(KEY_MINUS, politicalParty.getMinus());
      	 int update = db.update(TABLE_POLITICAL_PARTIES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(politicalParty.getId()) });
      	db.close(); //Closing the connection...
       // updating row
       return update;
   }
   
   /*
    * Deleting a Party
    */
   public void deletePoliticalParty(PoliticalParty politicalParty) {
       SQLiteDatabase db = this.getWritableDatabase();
       db.delete(TABLE_POLITICAL_PARTIES, KEY_ID + " = ?",
               new String[] { String.valueOf(politicalParty.getId()) });
   }
 
   /*
    * Deleting a Party Promises
    */
   public void deletePoliticalPartyPromises(PoliticalPartyPromise politicalPartyPromise) {
       SQLiteDatabase db = this.getWritableDatabase();
       db.delete(TABLE_POLITICAL_PROMISES, KEY_ID + " = ?",
               new String[] { String.valueOf(politicalPartyPromise.getId()) });
   }
}
