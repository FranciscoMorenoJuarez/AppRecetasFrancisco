package com.example.apprecetas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton llevar, domicilio;
    CheckBox huevos, hotcakes, chilaquiles, quesadillas;
    CheckBox naranja, verde, agua, malteada;
    Button calcular, cancelar, pagar, historial;
    TextView ttotal;
    Double totalTotal=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DeveloperBD developerBD=new DeveloperBD(getApplicationContext());

        domicilio = findViewById(R.id.rbdomicilio);
        llevar = findViewById(R.id.rbllevar);
        huevos = findViewById(R.id.chHuevo);
        hotcakes = findViewById(R.id.chHotcakes);
        chilaquiles = findViewById(R.id.chChila);
        quesadillas = findViewById(R.id.chQuesa);
        naranja = findViewById(R.id.chNaranja);
        verde = findViewById(R.id.chJugoVerde);
        agua = findViewById(R.id.chAgua);
        malteada = findViewById(R.id.chMalteada);
        calcular = findViewById(R.id.btnCalcular);
        cancelar = findViewById(R.id.btnCancelar);

        ttotal = findViewById(R.id.txttotal);
        pagar=(Button)findViewById(R.id.btnPagar);


        pagar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                developerBD.agregarCursos(totalTotal);
                Toast.makeText(getApplicationContext(),"SE AGREGO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void calcular (View v){
        Double total = 0.0;
        totalTotal = total;

        if (domicilio.isChecked())
            total = total + 15;
        if (huevos.isChecked())
            total = total + 60;
        if (hotcakes.isChecked())
            total = total + 50;
        if (chilaquiles.isChecked())
            total = total + 65;
        if (quesadillas.isChecked())
            total = total + 45;
        if (naranja.isChecked())
            total = total + 20;
        if (verde.isChecked())
            total = total + 18;
        if (agua.isChecked())
            total = total + 15;
        if (malteada.isChecked())
            total = total + 25;

        ttotal.setText("Total: " + total);
    }

    public void cancelar (View v){
        domicilio.setChecked(false);
        huevos.setChecked(false);
        hotcakes.setChecked(false);
        chilaquiles.setChecked(false);
        quesadillas.setChecked(false);
        naranja.setChecked(false);
        verde.setChecked(false);
        agua.setChecked(false);
        malteada.setChecked(false);

        ttotal.setText("Total = 0.0");
    }

}
