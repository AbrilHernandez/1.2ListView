package com.example.abril.listview;

import android.content.Intent;
import android.service.carrier.CarrierMessagingService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lvw_list;
    ArrayAdapter<String> adaptador;
    SeekBar sbr_barra;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        sbr_barra = (SeekBar)findViewById(R.id.sbr_barra);
        arrayList = new ArrayList<String>();
        lvw_list = (ListView) findViewById(R.id.lvw_list);
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        lvw_list.setAdapter(adaptador);



        sbr_barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int texto = sbr_barra.getProgress();
                String res2 = "";


                for (int i = 0; i <= 9; i++) {
                    int res = i * texto;
                    //res2 += texto + "x" + i + "=" + (res) + "\n";
                    arrayList.add(res2 + texto + "x" + i + "=" + (res) + "\n");
                    adaptador.notifyDataSetChanged();

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if(!arrayList.isEmpty()){
                    arrayList.clear();
                }

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                //lvw_list.setAdapter(adaptador);
            }
        });
        lvw_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),"Ha seleccionado"+" "+((TextView)view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}

