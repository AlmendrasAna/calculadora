package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText numero1 = findViewById(R.id.numero1editText);
        EditText numero2 = findViewById(R.id.numero2EditText);

        Button sumaB = findViewById(R.id.sumaButton);
        Button restaB = findViewById(R.id.restaButton);
        Button divicionB = findViewById(R.id.divicionButton);
        Button multiplicacionB =  findViewById(R.id.multiplicarButton);
        ImageButton salirB =  findViewById(R.id.salir);

        salirB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAndRemoveTask();
            }
        });

       sumaB.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               calcular("+",numero1,numero2);
           }
       });

        restaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            calcular("-",numero1,numero2);
            }
        });

        divicionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular("/",numero1,numero2);
            }
        });


        multiplicacionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular("*",numero1,numero2);
            }
        });



    }

    private void calcular(String signo, EditText numb1EditTxT, EditText numb2EditTxT) {

        float resultado=0;



        if(numb1EditTxT.getText().toString().isEmpty() || numb2EditTxT.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(),"Rellenar los campos vacios.", Toast.LENGTH_LONG).show();
        }else {
            Integer numb1 = Integer.parseInt(numb1EditTxT.getText().toString());
            Integer numb2 = Integer.parseInt(numb2EditTxT.getText().toString());

            if(signo.equals("/")&& numb1 == 0 ){
                Toast.makeText(getBaseContext(),  "no se puede dividir por 0: " , Toast.LENGTH_SHORT).show();

            }else {
            switch (signo) {
            case "+":
                resultado = numb1 + numb2;
                break;
            case "-":
                resultado = numb1 - numb2;
                break;
            case "/":
                    resultado = numb1 / numb2;
                break;

            case "*":
                resultado = numb1 * numb2;
                break;
            }

                String mensaje = numb1 + " " + signo + " " + numb2+ " = " + resultado;

                Toast.makeText(getBaseContext(),mensaje, Toast.LENGTH_SHORT).show();


            }
        }
    }


}