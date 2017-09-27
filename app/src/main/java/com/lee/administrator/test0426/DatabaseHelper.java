package com.lee.administrator.test0426;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 李国杰 on 2016/4/28.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }
    public DatabaseHelper(Context context, String name, int version)
    {
        this(context, name, null, version);
    }
    public DatabaseHelper(Context context, String name)
    {
        this(context,name,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("creat a DataBase");
        db.execSQL("create table user(tem int,time datatime);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("updata a Database");
    }
}
