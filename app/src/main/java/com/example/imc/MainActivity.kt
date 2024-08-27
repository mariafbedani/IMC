package com.example.imc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val peso = findViewById<EditText>(R.id.peso)
        val altura = findViewById<EditText>(R.id.altura)
        val calcular = findViewById<ImageButton>(R.id.calcular)
        val resultado = findViewById<TextView>(R.id.resultado)

        calcular.setOnClickListener{

            val valorpeso = peso.text.toString().toDoubleOrNull()
            val valoraltura = altura.text.toString().toDoubleOrNull()



            if (valorpeso != null && valoraltura != null){

                val imc = valorpeso / (valoraltura * valoraltura)

                val calculo = when {

                    imc < 18.5 -> "Abaixo do Peso"
                    imc in 18.5..24.9 -> "Peso Normal"
                    imc in 25.0..29.9 -> "Sobrepeso"
                    imc in 30.0..34.9 -> "Obesidade"
                    imc in 35.0..39.9 -> "Obesidade Grau II"
                    else -> "Obesidade Mórbida"

                }
                resultado.text = "IMC: ${String.format("%.2f", imc)}: $calculo"
            }else {
                resultado.text = "Por favor, insira o peso e a altura"
            }





        }


    }
}