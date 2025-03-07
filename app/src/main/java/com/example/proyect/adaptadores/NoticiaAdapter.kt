package com.example.proyect

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoticiaAdapter(private val noticias: List<Noticia>) :
    RecyclerView.Adapter<NoticiaAdapter.NoticiaViewHolder>() {

    class NoticiaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(R.id.tvTituloNoticia)
        val descripcion: TextView = itemView.findViewById(R.id.tvDescripcionNoticia)
        val imagen: ImageView = itemView.findViewById(R.id.ivNoticiaImagen) // Agregar ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_noticia, parent, false)
        return NoticiaViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoticiaViewHolder, position: Int) {
        val noticia = noticias[position]
        holder.titulo.text = noticia.titulo
        holder.descripcion.text = noticia.descripcion

        // Mostrar imagen si existe
        if (noticia.imagenUri != null) {
            holder.imagen.setImageURI(noticia.imagenUri)
            holder.imagen.visibility = View.VISIBLE
        } else {
            holder.imagen.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = noticias.size
}
