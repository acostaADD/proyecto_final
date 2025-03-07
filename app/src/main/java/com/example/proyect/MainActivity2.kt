package com.example.proyect

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var noticiaAdapter: NoticiaAdapter
    private val noticias = mutableListOf<Noticia>()
    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView = findViewById(R.id.recyclerViewNews)
        noticiaAdapter = NoticiaAdapter(noticias)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = noticiaAdapter

        findViewById<Button>(R.id.btnAddNews).setOnClickListener {
            mostrarDialogoAgregarNoticia()
        }
    }

    private fun mostrarDialogoAgregarNoticia() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Agregar Noticia")

        val view = layoutInflater.inflate(R.layout.dialog_add_noticia, null)
        val etTitulo = view.findViewById<EditText>(R.id.etTituloNoticia)
        val etDescripcion = view.findViewById<EditText>(R.id.etDescripcionNoticia)
        val btnSeleccionarImagen = view.findViewById<Button>(R.id.btnSeleccionarImagen)
        val ivPreviewNoticia = view.findViewById<ImageView>(R.id.ivPreviewNoticia)

        btnSeleccionarImagen.setOnClickListener {
            seleccionarImagen()
        }

        builder.setView(view)
        builder.setPositiveButton("Agregar") { _, _ ->
            val titulo = etTitulo.text.toString()
            val descripcion = etDescripcion.text.toString()
            if (titulo.isNotEmpty() && descripcion.isNotEmpty()) {
                noticias.add(Noticia(titulo, descripcion, selectedImageUri))
                noticiaAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }

    private fun seleccionarImagen() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        imagePickerLauncher.launch(intent)
    }

    private val imagePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            selectedImageUri = result.data?.data
        }
    }
}