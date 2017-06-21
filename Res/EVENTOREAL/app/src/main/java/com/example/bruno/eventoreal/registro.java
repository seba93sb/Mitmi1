package com.example.bruno.eventoreal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registro extends AppCompatActivity implements android.view.View.OnClickListener {

    Button bt_registro;
    TextView ET_fecha, ET_hora, ET_cupos, ET_descripcion;
    TextView ET_nombre;


    private int _Evento_Id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        bt_registro = (Button) findViewById(R.id.bt_registro);

        ET_nombre = (TextView) findViewById(R.id.ET_nombre);
        ET_fecha = (TextView) findViewById(R.id.ET_fecha);
        ET_hora = (TextView) findViewById(R.id.ET_hora);
        ET_cupos = (TextView) findViewById(R.id.ET_cupos);
        ET_descripcion = (TextView) findViewById(R.id.ET_descripcion);

        bt_registro.setOnClickListener(this);

        _Evento_Id =0;
        Intent intent = getIntent();
        _Evento_Id =intent.getIntExtra("id_evento", 0);
        EventoREPO repo = new EventoREPO(this);
        Evento evento = new Evento();
        evento = repo.getEventbyId(_Evento_Id);

        ET_nombre.setText(evento.nombre);
        ET_fecha.setText(evento.fecha);
        ET_hora.setText(evento.hora);
        ET_cupos.setText(String.valueOf(evento.cupos));
        ET_descripcion.setText(evento.descripcion);

    }

    @Override
    public void onClick(View view) {

        if (view== findViewById(R.id.bt_registro)){
            finish();

        }
        }

}
