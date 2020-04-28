package com.example.shoppinglistapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class List1DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "List1DBHelper";

    private static final String TABLE_NAME = "Lista1";
    private static final String COL1 = "ID";
    private static final String COL2 = "Vonalkód";
    private static final String COL3 = "Név";
    private static final String COL4 = "Egység_ár";
    private static final String COL5 = "Darab_szám";

    public List1DBHelper (Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 +
                " INT NOT NULL, " + COL3 + " VARCHAR(30) NOT NULL, " +
                COL4 + " INT NOT NULL, " + COL5 + " INT NOT NULL)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String barcode, String name, String price, String piece) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, barcode);
        contentValues.put(COL3, name);
        contentValues.put(COL4, price);
        contentValues.put(COL5, piece);

        Log.d(TAG, "addData: Adding " + barcode + ", " + name +
                ", " + price + ", " + piece + " to " + TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1) {
            return false;
        } else {
            return  true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public boolean updateItem(String barCode, String newName, String newPrice, String newPiece) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL2, barCode);
        cv.put(COL3, newName);
        cv.put(COL4, newPrice);
        cv.put(COL5, newPiece);
        db.update(TABLE_NAME, cv, "Vonalkód = ?", new String[] {barCode});
        return true;
    }

    public boolean updateName(String barCode, String newName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL2, barCode);
        cv.put(COL3, newName);
        db.update(TABLE_NAME, cv, "Vonalkód = ?", new String[] {barCode});
        return true;
    }

    public boolean updatePrice(String barCode, String newPrice) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL2, barCode);
        cv.put(COL4, newPrice);
        db.update(TABLE_NAME, cv, "Vonalkód = ?", new String[] {barCode});
        return true;
    }

    public boolean updatePiece(String barCode, String newPiece) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL2, barCode);
        cv.put(COL5, newPiece);
        db.update(TABLE_NAME, cv, "Vonalkód = ?", new String[] {barCode});
        return true;
    }


    public void deleteItem(String barCode) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COL2 + " = '" + barCode + "'";
        Log.d(TAG, "deleteItem: query: " + query);
        Log.d(TAG, "deleteItem: Deleting: " + barCode + "from database.");
        db.execSQL(query);
    }

}
