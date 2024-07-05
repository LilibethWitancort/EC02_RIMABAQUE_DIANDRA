package com.AC2_DIANDRA_RIMABAQUE

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var registroButton: Button
    private lateinit var formularioButton: Button
    private lateinit var listadoButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        agregarReferenciasPrincipal()
    }

    private fun agregarReferenciasPrincipal() {
        registroButton = findViewById(R.id.registro)
        registroButton.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        formularioButton = findViewById(R.id.formulario)
        formularioButton.setOnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            startActivity(intent)
        }

        listadoButton = findViewById(R.id.listado)
        listadoButton.setOnClickListener {
            val intent = Intent(this, ListadoActivity::class.java)
            startActivity(intent)
        }
    }
}
