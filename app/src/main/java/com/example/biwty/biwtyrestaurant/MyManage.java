package com.example.biwty.biwtyrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User on 19/3/2559.
 */
public class MyManage {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String user_table = "userTABLE";
    public static final String column_id = "_id";
    public static final String column_User = "User";
    public static final String column_Password = "Password";
    public static final String column_Name = "Name";


    public static final String food_table = "foodTABEL";
    public static final String column_Food = "Food";
    public static final String column_Price = "Price";
    public static final String column_Source = "Source";


    public MyManage(Context context) {
        //Create &Connected SQLite
        myOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = myOpenHelper.getReadableDatabase();
        readSqLiteDatabase = myOpenHelper.getReadableDatabase();


    }//Constructor


    public long addValue(int intTABLE,
                         String strColumn2,
                         String strColumn3,
                         String strColumn4){

        ContentValues contentValues = new ContentValues();

        long myLong = 0;

        switch (intTABLE) {
            case 1:
                //For userTABLE
                contentValues.put(column_User, strColumn2);
                contentValues.put(column_Password, strColumn3);
                contentValues.put(column_Name, strColumn4);

                myLong = writeSqLiteDatabase.insert(user_table, null, contentValues);

                break;
            case 2:
                //For foodTABLE
                contentValues.put(column_Food ,strColumn2);
                contentValues.put(column_Price,strColumn3);
                contentValues.put(column_Source,strColumn4);

                myLong = writeSqLiteDatabase.insert(food_table, null, contentValues);


                break;
        }


        return 0;
    }


}//Main Class
