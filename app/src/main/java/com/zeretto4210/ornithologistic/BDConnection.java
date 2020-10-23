package com.zeretto4210.ornithologistic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDConnection extends SQLiteOpenHelper {
    private final String userDB = "CREATE TABLE usuario (id INTEGER, nombre TEXT, apellido TEXT, genero TEXT, fecha TEXT)";
    private final String birdsDB = "CREATE TABLE registros (id INTEGER, nombre TEXT, fecha TEXT, comentario TEXT)";

    public BDConnection(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(userDB);
        db.execSQL(birdsDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE IF EXISTS registros");
        onCreate(db);
    }
}
