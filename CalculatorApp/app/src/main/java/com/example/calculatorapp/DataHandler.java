package com.example.calculatorapp;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by werne on 2017/03/27.
 */

public class DataHandler extends SQLiteOpenHelper {

    List<String> allsums = new ArrayList<String>();
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AllCalulations.db";
    private static final String TABLE_ALLCALULATION = "AllCalculations";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CALCULATIONS = "calculations";
    List<KeepRecordClass> SumsInDB = new ArrayList<>();

    public DataHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_ALLCALCULATION = "CREATE TABLE " + TABLE_ALLCALULATION + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_CALCULATIONS
                + " TEXT " + ")";

        db.execSQL(CREATE_TABLE_ALLCALCULATION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("REMOVE TABLE FROM DATABASE " + TABLE_ALLCALULATION);
        onCreate(db);
    }

    public void InsertCalculations(List<KeepRecordClass> allCalculations)
    {

        ContentValues values = new ContentValues();
        for (KeepRecordClass item: allCalculations)
        {
            values.put(COLUMN_CALCULATIONS, item.getCalculations());
        }

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_ALLCALULATION, null, values);
        db.close();
    }

    public List<KeepRecordClass> SelectAllItems()
    {
        String query = "SELECT * FROM " + TABLE_ALLCALULATION;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);
        //KeepRecordClass keepRecordClass = new KeepRecordClass();



        //for (int i = 0; i <= allCalculations.size(); i++)
       // {
            if (cursor.moveToFirst())
            {
                int count = cursor.getCount();
                do{

                    SumsInDB.add(new KeepRecordClass(cursor.getString(1)));
                }
                while (cursor.moveToNext());
                //cursor.move(count);
                //for (int i = 0; i <= count; i++)
                //{
                //    allsums.add(cursor.getString(i));

                //}

                cursor.close();
            }
            else
            {
                SumsInDB = null;
            }
        //}


        db.close();
        return SumsInDB;
    }
}
