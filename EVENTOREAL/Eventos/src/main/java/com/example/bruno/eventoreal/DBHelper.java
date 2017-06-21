package com.example.bruno.eventoreal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.bruno.eventoreal.Evento.TABLE;

/**
 * Created by bruno on 6/12/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 6;

    private static final String DATABASE_NAME = "crud.db";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabla = "CREATE TABLE " + TABLE  + "("
                + Evento.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Evento.KEY_nombre + " TEXT, "
                + Evento.KEY_fecha + " TEXT, "
                + Evento.KEY_hora + " TEXT, "
                + Evento.KEY_cupos + " INTEGER, "
                + Evento.KEY_descripcion + " TEXT )";

        db.execSQL(tabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Evento.TABLE);
        onCreate(db);

    }
}
