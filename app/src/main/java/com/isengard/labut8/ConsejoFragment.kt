package com.isengard.labut8

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class ConsejoFragment : Fragment(R.layout.fragmento_consejo) {

    private var heroe: String = ""
    private var linaje: String = ""
    private var mensaje: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            heroe = bundle.getString(ARG_HEROE)?.trim() ?: "Héroe desconocido"
            linaje = bundle.getString(ARG_LINAJE)?.trim() ?: "Linaje desconocido"
            mensaje = bundle.getString(ARG_MENSAJE)?.trim() ?: ""
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvHeroe = view.findViewById<TextView>(R.id.heroe)
        val tvLinaje = view.findViewById<TextView>(R.id.linaje)
        val tvMensaje = view.findViewById<TextView>(R.id.mensaje)

        tvHeroe.text = heroe
        tvLinaje.text = linaje
        tvMensaje.text = mensaje
    }

    companion object {
        private const val ARG_HEROE = "arg_heroe"
        private const val ARG_LINAJE = "arg_linaje"
        private const val ARG_MENSAJE = "arg_mensaje"

        fun newInstance(heroe: String, linaje: String, mensaje: String): ConsejoFragment {
            return ConsejoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_HEROE, heroe)
                    putString(ARG_LINAJE, linaje)
                    putString(ARG_MENSAJE, mensaje)
                }
            }
        }
    }
}
