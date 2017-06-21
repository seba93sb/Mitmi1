package com.example.bruno.eventoreal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bruno on 6/12/2017.
 */

public class EventoREPO {
    private DBHelper dbHelper;

    public EventoREPO(Context context) {
        dbHelper = new DBHelper(context);
    }


    public int insert(Evento evento) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Evento.KEY_nombre, evento.nombre);
        values.put(Evento.KEY_fecha, evento.fecha);
        values.put(Evento.KEY_hora, evento.hora);
        values.put(Evento.KEY_cupos, evento.cupos);
        values.put(Evento.KEY_descripcion, evento.descripcion);
        if (evento.nombre.length() > 0 && evento.fecha.length() > 0 && evento.hora.length() > 0 && toString().valueOf(evento.cupos).length() > 0) {

            long id_evento = db.insert(Evento.TABLE, null, values);
            db.close();
            return (int) id_evento;

        }

        else return 0;


    }

    public ArrayList<HashMap<String, String>>  getEventList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Evento.KEY_ID + "," +
                Evento.KEY_nombre + "," +
                Evento.KEY_fecha + "," +
                Evento.KEY_hora + "," +
                Evento.KEY_cupos + "," +
                Evento.KEY_descripcion +
                " FROM " + Evento.TABLE;

        ArrayList<HashMap<String, String>> eventList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> evento = new HashMap<String, String>();
                evento.put("id", cursor.getString(cursor.getColumnIndex(Evento.KEY_ID)));
                evento.put("nombre", cursor.getString(cursor.getColumnIndex(Evento.KEY_nombre)));
                eventList.add(evento);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return eventList;

    }

    public Evento getEventbyId(int Id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                Evento.KEY_ID + "," +
                Evento.KEY_nombre + "," +
                Evento.KEY_fecha + "," +
                Evento.KEY_hora + "," +
                Evento.KEY_cupos + "," +
                Evento.KEY_descripcion +
                " FROM " + Evento.TABLE
                + " WHERE " +
                Evento.KEY_ID + "=?";

        Evento evento = new Evento();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(Id)});
        if (cursor.moveToFirst()) {
            do {
                evento.evento_id = cursor.getInt(cursor.getColumnIndex(Evento.KEY_ID));
                evento.nombre = cursor.getString(cursor.getColumnIndex(Evento.KEY_nombre));
                evento.fecha = cursor.getString(cursor.getColumnIndex(Evento.KEY_fecha));
                evento.hora = cursor.getString(cursor.getColumnIndex(Evento.KEY_hora));
                evento.cupos = cursor.getInt(cursor.getColumnIndex(Evento.KEY_cupos));
                evento.descripcion = cursor.getString(cursor.getColumnIndex(Evento.KEY_descripcion));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return evento;
    }

}

