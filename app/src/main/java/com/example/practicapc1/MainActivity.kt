package com.example.practicapc1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var notaParcialEditText: EditText
    private lateinit var notaTareaAcademicaEditText: EditText
    private lateinit var notaExamenFinalEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        notaParcialEditText = findViewById(R.id.nota1input);
        notaExamenFinalEditText = findViewById(R.id.nota2input);
        notaTareaAcademicaEditText = findViewById(R.id.nota3input)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
        //Limpia los campos de las notas ingresadas
        notaParcialEditText.text.clear()
        notaExamenFinalEditText.text.clear()
        notaTareaAcademicaEditText.text.clear()
    }

    fun CalcularPromedio(view: View) {
        val NotaParcial = notaParcialEditText.text.toString().toDouble()
        val NotaExFinal = notaExamenFinalEditText.text.toString().toDouble()
        val notaTareaAcademica = notaTareaAcademicaEditText.text.toString().toDouble()


        val PromedioFinal =
            (NotaParcial * 0.20) + (NotaExFinal * 0.20) + (notaTareaAcademica * 0.60)
        val aprobado = PromedioFinal >= 11
        val intent = Intent(this, Result_Activity2::class.java).apply {
            putExtra("PROMEDIO", PromedioFinal)
            putExtra("APROBADO", aprobado)


        }

        startActivity(intent)
    }
}