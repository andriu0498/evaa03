package com.ceduc.comm

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Carrito : AppCompatActivity() {

    private lateinit var txtListaCarrito: TextView
    private lateinit var db: SQLiteDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)

        txtListaCarrito = findViewById(R.id.txtListaCarrito)
        db = SQLiteDB(this)

        val productosEnCarrito = db.obtenerProductos()
        mostrarProductos(productosEnCarrito)

        val btnPagar: Button = findViewById(R.id.btnPagar)
        btnPagar.setOnClickListener {
            Toast.makeText(this, "Has hecho el pago con exito", Toast.LENGTH_SHORT).show()
            finish()
            val db = SQLiteDB(this)
            db.limpiarcarrito()
        }
    }
    private fun mostrarProductos(productos: List<Producto>) {
        val texto = productos.joinToString("\n") { it.descripcion }
        txtListaCarrito.text = texto
    }

}
