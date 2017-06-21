package com.example.bruno.eventoreal;

/**
 * Created by bruno on 6/12/2017.
 */

public class Evento {
    // Labels table name
    public static final String TABLE = "Evento";

    // Labels Table Columns names
    public static final String KEY_ID = "ID";
    public static final String KEY_nombre = "NOMBRE";
    public static final String KEY_fecha = "FECHA";
    public static final String KEY_hora = "HORA";
    public static final String KEY_cupos = "CUPOS";
    public static final String KEY_descripcion = "DESCRIPCION";

    // property help us to keep data
    public int evento_id;
    public String nombre;
    public String fecha;
    public String hora;
    public int cupos;
    public String descripcion;

}