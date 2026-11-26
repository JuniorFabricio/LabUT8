package com.isengard.labut8

import android.os.Bundle
import android.widget.Button
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
            v.setPadding(systemBars.left + 16, systemBars.top + 16, systemBars.right + 16, systemBars.bottom + 16)
            insets
        }

        if (savedInstanceState == null) {
            cargarCronica(
                heroe = "Gandalf el Gris",
                linaje = "Istari (Orden de los Magos)",
                mensaje = "\"El Anillo Único debe ser destruido en las grietas del Monte del Destino.\"",
                agregarAlHistorial = false
            )
        }

        // Botones de la parte superior
        findViewById<Button>(R.id.btnGandalf).setOnClickListener {
            cargarCronica(
                heroe = "Gandalf el Gris",
                linaje = "Istari (Orden de los Magos)",
                mensaje = "\"El Anillo Único debe ser destruido en las grietas del Monte del Destino.\"",
                agregarAlHistorial = true
            )
        }

        findViewById<Button>(R.id.btnAragorn).setOnClickListener {
            cargarCronica(
                heroe = "Aragorn",
                linaje = "Heredero de Isildur",
                mensaje = "\"Si con mi vida o mi muerte puedo protegerte, lo haré. Cuenta con mi espada.\"",
                agregarAlHistorial = true
            )
        }

        findViewById<Button>(R.id.btnLegolas).setOnClickListener {
            cargarCronica(
                heroe = "Legolas",
                linaje = "Reino del Bosque Negro",
                mensaje = "\"Las sombras crecen en el Este; los elfos marcharán junto a los hombres.\"",
                agregarAlHistorial = true
            )
        }
    }

    //Funcion para cargar dicha cronica

    private fun cargarCronica(
        heroe: String,
        linaje: String,
        mensaje: String,
        agregarAlHistorial: Boolean
    ) {
        val fragment = ConsejoFragment.newInstance(heroe, linaje, mensaje)
        val transaccion = supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainer, fragment)

        if (agregarAlHistorial) {
            transaccion.addToBackStack(null)
        }

        transaccion.commit()
    }
}
