package com.example.damn_practica10

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

/**
 * La MainActivity es el punto de entrada de la aplicación.
 * Su única responsabilidad es cargar el MainFragment, que contiene toda la lógica de la UI.
 */
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Si es la primera vez que se crea la actividad, añadimos el fragmento
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_browse_fragment, MainFragment())
                .commitNow()
        }
    }
}
