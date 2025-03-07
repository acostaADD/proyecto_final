package com.example.proyect

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyect.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Encuentra los botones (TextViews) y configura los listeners
        val noticias = findViewById<TextView>(R.id.noticias)
        noticias.setOnClickListener {
            goToNoticias() // Navegar a la actividad de noticias
        }

        // Encuentra los botones (TextViews) y configura los listeners
        val horario = findViewById<TextView>(R.id.horario)
       horario.setOnClickListener {
            goToHORARIO() // Navegar a la actividad de noticias
        }


        // Encuentra los botones (TextViews) y configura los listeners
        val asignaturas = findViewById<TextView>(R.id.asignaturas)
        asignaturas.setOnClickListener {
            goToAsignaturas() // Navegar a la actividad de noticias
        }

        // Encuentra los botones (TextViews) y configura los listeners
        val notas = findViewById<TextView>(R.id.notas)
        notas.setOnClickListener {
            goToNotas() // Navegar a la actividad de noticias
        }

        // Encuentra los botones (TextViews) y configura los listeners
        val contactos = findViewById<TextView>(R.id.contactos)
        contactos.setOnClickListener {
            goToContactos() // Navegar a la actividad de noticias
        }
    }

    private fun goToNoticias() {
        // Crear el intent para ir a MainActivity2 (o la actividad de noticias)
        val i = Intent(this, MainActivity2::class.java)
        startActivity(i)

    }

    private fun goToHORARIO() {
        // Crear el intent para ir a MainActivity3 (o la actividad de noticias)
        val i = Intent(this, MainActivity3::class.java)
        startActivity(i)

    }


    private fun goToAsignaturas() {
        // Crear el intent para ir a MainActivity4 (o la actividad de noticias)
        val i = Intent(this, MainActivity4::class.java)
        startActivity(i)

    }
    private fun goToNotas() {
        // Crear el intent para ir a MainActivity2 (o la actividad de noticias)
        val i = Intent(this, MainActivity5::class.java)
        startActivity(i)



    }
    private fun goToContactos() {
        // Crear el intent para ir a MainActivity2 (o la actividad de noticias)
        val i = Intent(this, MainActivity6::class.java)
        startActivity(i)

    }
}



