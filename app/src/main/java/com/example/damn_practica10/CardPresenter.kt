package com.example.damn_practica10

import android.graphics.Color
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.leanback.widget.BaseCardView
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.ImageCardView

/**
 * Este Presenter se encarga de crear y mostrar cada "tarjeta" de consejo.
 * Usamos una ImageCardView para un estilo visual atractivo y estándar en TV.
 */
class CardPresenter : Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val cardView = object : ImageCardView(parent.context) {
            override fun setSelected(selected: Boolean) {
                // Cambiamos el color del borde cuando la tarjeta se selecciona
                val color = if (selected) {
                    ContextCompat.getColor(context, android.R.color.holo_blue_bright)
                } else {
                    Color.TRANSPARENT
                }
                findViewById<BaseCardView>(androidx.leanback.R.id.info_field).setBackgroundColor(color)
                super.setSelected(selected)
            }
        }
        cardView.isFocusable = true
        cardView.isFocusableInTouchMode = true
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
        val tip = item as String
        val cardView = viewHolder.view as ImageCardView

        // Configuramos el tamaño de la tarjeta
        cardView.setMainImageDimensions(313, 176) // Formato 16:9
        cardView.titleText = tip // El texto principal es el consejo
        cardView.contentText = "" // No necesitamos texto de contenido

        // Ponemos una imagen genérica o un color de fondo
        cardView.mainImageView.setBackgroundColor(ContextCompat.getColor(cardView.context, android.R.color.darker_gray))
        // CAMBIO AQUÍ: Usamos el ícono de la aplicación por defecto
        cardView.setMainImage(ContextCompat.getDrawable(cardView.context, R.mipmap.ic_launcher))
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        val cardView = viewHolder.view as ImageCardView
        // Liberamos recursos
        cardView.badgeImage = null
        cardView.mainImage = null
    }
}