package com.example.bruno.eventoreal;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity implements android.view.View.OnClickListener {

    Button bt_guardar, bt_mostrar;
    TextView id_evento;


    @Override
    public void onClick(View view) {
        if (view== findViewById(R.id.bt_guardar)){

            Intent intent = new Intent(this,detalle.class);
            intent.putExtra("id_evento",0);
            startActivity(intent);


        }else {


            EventoREPO repo = new EventoREPO(this);

            ArrayList<HashMap<String, String>> eventList = repo.getEventList();
            if (eventList.size() != 0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        id_evento = (TextView) view.findViewById(R.id.id_evento);
                        String eventID = id_evento.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(), registro.class);
                        objIndent.putExtra("id_evento", Integer.parseInt(eventID));
                        startActivity(objIndent);
                    }
                });
                ListAdapter adapter = new SimpleAdapter(MainActivity.this, eventList, R.layout.agenda, new String[]{"id", "nombre"}, new int[]{R.id.id_evento, R.id.nombre_evento});
                setListAdapter(adapter);
            } else {
                Toast.makeText(this, "No hay eventos registrados", Toast.LENGTH_SHORT).show();
            }
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_guardar = (Button) findViewById(R.id.bt_guardar);
        bt_guardar.setOnClickListener(this);

        bt_mostrar = (Button) findViewById(R.id.bt_mostrar);
        bt_mostrar.setOnClickListener(this);

    }


}
