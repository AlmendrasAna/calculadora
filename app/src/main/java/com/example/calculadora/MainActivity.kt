package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val numero1 = findViewById<EditText>(R.id.numero1editText)
        val numero2 = findViewById<EditText>(R.id.numero2EditText)
        val sumaB = findViewById<Button>(R.id.sumaButton)
        val restaB = findViewById<Button>(R.id.restaButton)
        val divicionB = findViewById<Button>(R.id.divicionButton)
        val multiplicacionB = findViewById<Button>(R.id.multiplicarButton)
        val salirB = findViewById<ImageButton>(R.id.salir)
        salirB.setOnClickListener { finishAndRemoveTask() }
        sumaB.setOnClickListener { calcular("+", numero1, numero2) }
        restaB.setOnClickListener { calcular("-", numero1, numero2) }
        divicionB.setOnClickListener { calcular("/", numero1, numero2) }
        multiplicacionB.setOnClickListener { calcular("*", numero1, numero2) }
    }

    private fun calcular(signo: String, numb1EditTxT: EditText, numb2EditTxT: EditText) {
        var resultado = 0f
        if (numb1EditTxT.text.toString().isEmpty() || numb2EditTxT.text.toString().isEmpty()) {
            Toast.makeText(baseContext, "Rellenar los campos vacios.", Toast.LENGTH_LONG).show()
        } else {
            val numb1 = numb1EditTxT.text.toString().toInt().toFloat()
            val numb2 = numb2EditTxT.text.toString().toInt().toFloat()
            if (signo == "/" && numb2 == 0f) {
                Toast.makeText(baseContext, "no se puede dividir por 0: ", Toast.LENGTH_SHORT)
                    .show()
            } else {
                when (signo) {
                    "+" -> resultado = numb1 + numb2
                    "-" -> resultado = numb1 - numb2
                    "/" -> resultado = numb1 / numb2
                    "*" -> resultado = numb1 * numb2
                }
                val mensaje = "$numb1 $signo $numb2 = $resultado"
                Toast.makeText(baseContext, mensaje, Toast.LENGTH_SHORT).show()
            }
        }
    }
}