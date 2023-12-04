package com.ceduc.comm

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProductoActivity : AppCompatActivity() {

    private lateinit var producto: Producto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        producto = intent.getSerializableExtra("producto") as Producto

        val Codigo = findViewById<TextView>(R.id.txtCodigoProduc)
        val Descripcion = findViewById<TextView>(R.id.txtDescripcionproduc)
        val Precio = findViewById<TextView>(R.id.txtPrecioproduct)

        Codigo.text = "Código: ${producto.codigo}"
        Descripcion.text = "Descripción: ${producto.descripcion}"
        Precio.text = "Precio: $${producto.precio}"

        val btnAgregarCarrito: Button = findViewById(R.id.btnAgregarCarrito)
        btnAgregarCarrito.setOnClickListener {
            agregarCarrito(producto)
            Toast.makeText(this, "Producto agregado al carrito", Toast.LENGTH_SHORT).show()

            finish()
        }
    }

    private fun agregarCarrito(producto: Producto) {
        val db = SQLiteDB(this)
        db.obtenercarrito(producto)
    }
}
