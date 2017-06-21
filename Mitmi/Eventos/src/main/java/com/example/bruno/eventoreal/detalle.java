package com.example.bruno.eventoreal;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class detalle extends AppCompatActivity implements android.view.View.OnClickListener {

    Button bt_modificar;
    EditText ET_nombre, ET_fecha, ET_hora, ET_cupos, ET_descripcion;

    private int _Evento_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        bt_modificar = (Button) findViewById(R.id.bt_modificar);

        ET_nombre = (EditText) findViewById(R.id.ET_nombre);
        ET_fecha = (EditText) findViewById(R.id.ET_fecha);
        ET_hora = (EditText) findViewById(R.id.ET_hora);
        ET_cupos = (EditText) findViewById(R.id.ET_cupos);
        ET_descripcion = (EditText) findViewById(R.id.ET_descripcion);

        bt_modificar.setOnClickListener(this);

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

        if (getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onClick(View view) {

        if (view == findViewById(R.id.bt_modificar)){
            EventoREPO repo = new EventoREPO(this);
            Evento evento = new Evento();
            evento.cupos= Integer.parseInt(ET_cupos.getText().toString());
            evento.nombre=ET_nombre.getText().toString();
            evento.fecha=ET_fecha.getText().toString();
            evento.hora=ET_hora.getText().toString();
            evento.descripcion=ET_descripcion.getText().toString();
            evento.evento_id=_Evento_Id;

            if (_Evento_Id==0) {
                _Evento_Id = repo.insert(evento);

                if (_Evento_Id != 0) {

                    Toast.makeText(this, "Evento registrado", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "llene todas las casillas", Toast.LENGTH_SHORT).show();
                }


            }

        }
    }
}
