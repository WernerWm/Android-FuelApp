package com.example.fuelconsuption;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by werne on 2017/03/18.
 */

public class Datahandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserDB.db";
    private static final String TABLE_USER = "user";
    private static final String TABLE_CARDETAILS = "Car";
    private static final String TABLE_FILLUP = "fillUp";

    private static final String COLUMN_USERID = "userid";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_USERPASSWORD = "password";
    private static final String COLUMN_CARNAME = "name";
    private static final String COLUMN_FUELSTATION = "fuelstation";
    private static final String COLUMN_FUELTYPE = "fueltype";
    private static final String COLUMN_FUELPRICE = "fuelprice";
    private static final String COLUMN_FUELUSAGE = "fuelusage";
    private static final String COLUMN_ODOMETERREADING = "odometerreading";
    private static final String COLUMN_AVERAGEFUELCONSUMPTION = "averagefuelconsumption";
    //private static final String COLUMN_CARIMAGE = "carimage";
    private static final String COLUMN_CARID = "carid";
    private static final String COLUMN_MODELYEAR = "modelyear";
    //private static final String COLUMN_USERIMAGE = "userimage";
    private static final String COLUMN_FAMILYNAME = "familyname";
    private static final String COLUMN_FAMIlYPASSWORD = "familypassword";
    //private static final String COLUMN_FAMILYIMAGE = "familtyImage";
    private static final String COLUMN_USERCOUNTRY = "country";



    public Datahandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER
                + "(" + COLUMN_USERID + " INTEGER PRIMARY KEY," +
                COLUMN_FAMILYNAME + " TEXT," + COLUMN_FAMIlYPASSWORD +
                " TEXT," + COLUMN_USERNAME + " TEXT," + COLUMN_USERPASSWORD + " TEXT,"
                + COLUMN_USERCOUNTRY + " TEXT" + ")";
        String CREATE_CARDETAIL_TABLE = "CREATE TABLE " + TABLE_CARDETAILS
                + "(" + COLUMN_CARID + " INTEGER PRIMARY KEY,"
                + COLUMN_FAMILYNAME + " TEXT," + COLUMN_CARNAME + " TEXT," + COLUMN_MODELYEAR
                + " INTEGER," + COLUMN_FUELTYPE + " TEXT," + COLUMN_USERID +  " INTEGER," + " FOREIGN KEY"
                + "(" + COLUMN_USERID + ")" + " REFERENCES " + TABLE_USER + "(" + COLUMN_USERID + ")" + ")";
        String CREATE_FILLUP_TABLE = "CREATE TABLE " + TABLE_FILLUP + "("
                + COLUMN_FUELUSAGE + " TEXT," + COLUMN_FUELPRICE
                + " TEXT," + COLUMN_FUELSTATION + " TEXT," + COLUMN_ODOMETERREADING + "TEXT"
                + COLUMN_AVERAGEFUELCONSUMPTION + " TEXT," + COLUMN_CARID +  " INTEGER,"
                + " FOREIGN KEY" + "(" + COLUMN_CARID + ")" + " REFERENCES "+ TABLE_CARDETAILS
                + "(" + COLUMN_CARID + ")" + ")";

        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_CARDETAIL_TABLE);
        db.execSQL(CREATE_FILLUP_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_USER);
        onCreate(db);
    }

    public Boolean FindUser(String username, String password)
    {
        String query = "SELECT * FROM " + TABLE_USER + " WHERE " +
                COLUMN_USERNAME + "= \"" + username + "\" " + "AND " +
                COLUMN_USERPASSWORD + "= \"" + password + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        User user = new User();

        if (cursor.moveToFirst())
        {
            cursor.moveToFirst();
            user.setUsername(cursor.getString(3));
            user.setPassword(cursor.getString(4));
        }

        String activeUser = user.getUsername();
        String activeUserPassword = user.getPassword();

        if ((activeUser != username) && (activeUserPassword != password) )
        {
            db.close();
            return true;
        }
        else
        {
            return false;
        }

    }

    public String CheckingForFamily(String username, String password)
    {
        String query = "SELECT * FROM " + TABLE_USER + " WHERE " +
                COLUMN_USERNAME + "= \"" + username + "\"" + " AND " +
                COLUMN_USERPASSWORD + "= \"" + password + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        Family family = new Family();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            family.setFamilyName(cursor.getString(1));
        }
        String familyName = family.getFamilyName();

        return familyName;
    }

    public List<CarDetails> UsersCars(String familyName,String username,String password)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        if (familyName == null)
        {
            String query2 = "SELECT * FROM " + TABLE_CARDETAILS + " CD " + "INNER JOIN "
                    + TABLE_USER + " U " + "ON " + "U." + COLUMN_USERID + "= \""
                    + "CD." + COLUMN_USERID + "\"" + " WHERE " + "CD." +
                    COLUMN_FAMILYNAME + "= \"" + familyName + "\"";

            Cursor cursor = db.rawQuery(query2,null);
            CarDetails familyCarsNames = new CarDetails();
            List<CarDetails> carNames = new ArrayList<CarDetails>();

            for (int i = 0; i <= cursor.getCount(); i++) {

                if (cursor.moveToFirst())
                {
                    cursor.moveToFirst();
                    familyCarsNames.setName(cursor.getString(0));
                    carNames.add(new CarDetails(familyCarsNames.getName()));
                }

            }
            return carNames;
        }
        else {
            String query = "SELECT * FROM " + TABLE_CARDETAILS + " CD " + "INNER JOIN "
                    + TABLE_USER + " U " + "ON " + "U." + COLUMN_FAMILYNAME + "= \""
                    + "CD." + COLUMN_FAMILYNAME + "\"" + " WHERE " + "U." + COLUMN_FAMILYNAME
                    + "= \"" + familyName + "\"";
            Cursor cursor = db.rawQuery(query,null);
            CarDetails familyCarsNames = new CarDetails();
            List<CarDetails> carNames = new ArrayList<CarDetails>();

            for (int i = 0; i <= cursor.getCount(); i++) {

                if (cursor.moveToFirst())
                {
                    cursor.moveToFirst();
                    familyCarsNames.setName(cursor.getString(0));
                    carNames.add(new CarDetails(familyCarsNames.getName()));
                }
            }
            return carNames;
        }

    }

    public List<User> Users(String familyName)
    {

        String query = "SELECT * FROM " + TABLE_USER + "WHERE" +
                COLUMN_FAMILYNAME + "= \"" + "= \"" + familyName + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        User user = new User();
        List<User> users = new ArrayList<User>();

        for (int i = 0; i <= cursor.getCount(); i++) {

            user.setUsername(cursor.getString(5));
            users.add(new User(user.getUsername()));
        }
        return users;
    }

    public void InsertData(User u,CarDetails cd)
    {
        ContentValues users = new ContentValues();
        ContentValues carDetails = new ContentValues();
        users.put(COLUMN_USERNAME,u.getUsername());
        users.put(COLUMN_USERPASSWORD,u.getPassword());
        users.put(COLUMN_USERCOUNTRY,u.getCountry());
        users.put(COLUMN_FAMILYNAME,u.getFamilyName());
        users.put(COLUMN_FAMIlYPASSWORD,u.getFamilyPassword());
        carDetails.put(COLUMN_CARNAME, cd.getName());
        carDetails.put(COLUMN_FUELTYPE, cd.getFuelType());
        carDetails.put(COLUMN_MODELYEAR,cd.getModelYear());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_USER,null,users);
        db.insert(TABLE_CARDETAILS,null,carDetails);
        db.close();
    }

    public void InsertFillUpData(FillUpDetails fUp)
    {
        ContentValues fillup = new ContentValues();
        fillup.put(COLUMN_FUELUSAGE,fUp.getFuelUsage());
        fillup.put(COLUMN_FUELPRICE,fUp.getPrice());
        fillup.put(COLUMN_AVERAGEFUELCONSUMPTION,fUp.getAverageFuelConsumption());
        fillup.put(COLUMN_FUELSTATION,fUp.getFuelStation());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_FILLUP,null,fillup);
        db.close();
    }
}
