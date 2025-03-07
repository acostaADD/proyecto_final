package com.example.proyect
import android.net.Uri

data class Noticia(
    val titulo: String,
    val descripcion: String,
    val imagenUri: Uri? = null
)
