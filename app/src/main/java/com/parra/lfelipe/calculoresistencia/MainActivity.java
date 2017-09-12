package com.parra.lfelipe.calculoresistencia;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Byte4;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int[] values = {1, 0, 0, 1};
    private Spinner spinner;
    private String franja;
    private LinearLayout franja1, franja2, franja3, franja4;
    private LinearLayout lnegro, lmarron, lrojo, lnaranja, lamarillo, lverde, lazul, lpurpura, lgris, lblanco, ltolmarron, ltolrojo, ltoldorado, ltolplateado;
    private TextView tResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        franja1 = (LinearLayout) findViewById(R.id.llFranja1);
        franja2 = (LinearLayout) findViewById(R.id.llFranja2);
        franja3 = (LinearLayout) findViewById(R.id.llFranja3);
        franja4 = (LinearLayout) findViewById(R.id.llFranja4);
        lnegro = (LinearLayout) findViewById(R.id.llNegro);
        lmarron = (LinearLayout) findViewById(R.id.llMarron);
        lrojo = (LinearLayout) findViewById(R.id.llRojo);
        lnaranja = (LinearLayout) findViewById(R.id.llNaranja);
        lamarillo = (LinearLayout) findViewById(R.id.llAmarilllo);
        lverde = (LinearLayout) findViewById(R.id.llVerde);
        lazul = (LinearLayout) findViewById(R.id.llAzul);
        lpurpura = (LinearLayout) findViewById(R.id.llPurpura);
        lgris = (LinearLayout) findViewById(R.id.llGris);
        lblanco = (LinearLayout) findViewById(R.id.llBlanco);
        ltolmarron = (LinearLayout) findViewById(R.id.lltolMarron);
        ltolrojo = (LinearLayout) findViewById(R.id.lltolRojo);
        ltoldorado = (LinearLayout) findViewById(R.id.lltolDorado);
        ltolplateado = (LinearLayout) findViewById(R.id.lltolPlateado);
        tResult = (TextView) findViewById(R.id.tResult);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.franjas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 franja = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void generarColor(View view) {
        int id = getResources().getIdentifier("ll"+franja, "id", getPackageName());
        LinearLayout x = (LinearLayout) findViewById(id);
        int index = 0;
        if(!franja.equals("Sin selección") && !franja.equals("Franja4")){
            if(franja.equals("Franja1")){index=0;}
            if(franja.equals("Franja2")){index=1;}
            if(franja.equals("Franja3")){index=2;}
            switch (view.getId()){
                case R.id.llNegro:
                    if(!franja.equals("Fraja1")){
                        x.setBackgroundResource(R.color.black);
                        values[index] = 0;
                    }
                    break;
                case R.id.llMarron:
                    x.setBackgroundResource(R.color.chocolate);
                    values[index] = 1;
                    break;

                case R.id.llRojo:
                    x.setBackgroundResource(R.color.red);
                    values[index] = 2;
                    break;

                case R.id.llNaranja:
                    x.setBackgroundResource(R.color.orangered);
                    values[index] = 3;
                    break;

                case R.id.llAmarilllo:
                    x.setBackgroundResource(R.color.yellow);
                    values[index] = 4;
                    break;

                case R.id.llVerde:
                    x.setBackgroundResource(R.color.green);
                    values[index] = 5;
                    break;

                case R.id.llAzul:
                    x.setBackgroundResource(R.color.blue);
                    values[index] = 6;
                    break;

                case R.id.llPurpura:
                    x.setBackgroundResource(R.color.purple);
                    values[index] = 7;
                    break;

                case R.id.llGris:
                    x.setBackgroundResource(R.color.gray);
                    values[index] = 8;
                    break;

                case R.id.llBlanco:
                    x.setBackgroundResource(R.color.white);
                    values[index] = 9;
                    break;
            }

        }
        else if(franja.equals("Franja4")){
            index = 3;
            switch (view.getId()){
                case R.id.lltolMarron:
                    x.setBackgroundResource(R.color.chocolate);
                    values[index] = 1;
                    break;
                case R.id.lltolRojo:
                    x.setBackgroundResource(R.color.red);
                    values[index] = 2;
                    break;
                case R.id.lltolDorado:
                    x.setBackgroundResource(R.color.gold);
                    values[index] = 5;
                    break;
                case R.id.lltolPlateado:
                    x.setBackgroundResource(R.color.lightgray);
                    values[index] = 10;
                    break;
            }
        }
    }

    private void habilitarColores(){
        lnegro.setOnClickListener(null);
    }

    public void calcularValor(View view) {
        long value = 0;
        value = (values[0]*10+values[1])*(long)Math.pow(10,values[2]);
        tResult.setText(Long.toString(value)+"Ω±"+Integer.toString(values[3])+"%");
    }
}
