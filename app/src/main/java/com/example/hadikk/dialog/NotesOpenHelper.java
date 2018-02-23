package com.example.hadikk.dialog;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hadikk on 23/02/18.
 */

public class NotesOpenHelper extends SQLiteOpenHelper {

    public NotesOpenHelper(Context context)
    {
        super(context,"Database",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE todo (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
        db.execSQL("INSERT INTO todo (name) VALUES ('bonjour ! Bases de données crée')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
