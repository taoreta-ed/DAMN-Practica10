package com.example.damn_practica10

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter

/**
 * Este fragmento es el corazón de la aplicación de TV.
 * Muestra filas de contenido (en nuestro caso, una sola fila de consejos).
 */
class MainFragment : BrowseSupportFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        loadRows()
    }

    private fun setupUI() {
        // Establecemos el título que aparece en la parte superior izquierda
        title = getString(R.string.browse_title)

        // Establecemos el color de fondo del fragmento
        brandColor = ContextCompat.getColor(requireContext(), android.R.color.black)
    }

    private fun loadRows() {
        // Obtenemos la lista de consejos desde el archivo strings.xml
        val tips = resources.getStringArray(R.array.survival_tips).toList()

        // Creamos un adaptador principal para todas las filas de la pantalla
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        // Creamos un adaptador para las tarjetas de nuestra fila de consejos
        val cardPresenter = CardPresenter()
        val listRowAdapter = ArrayObjectAdapter(cardPresenter)

        // Agregamos cada consejo al adaptador de la fila
        for (tip in tips) {
            listRowAdapter.add(tip)
        }

        // Creamos un encabezado para nuestra fila
        val header = HeaderItem(0, "Consejos del día")

        // Añadimos la fila completa (encabezado + tarjetas) al adaptador principal
        rowsAdapter.add(ListRow(header, listRowAdapter))

        // Finalmente, establecemos el adaptador principal en el fragmento
        adapter = rowsAdapter
    }
}
