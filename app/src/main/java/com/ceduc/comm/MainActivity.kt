package com.ceduc.comm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var daba: SQLiteDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        daba = SQLiteDB(this)
        val Dron: ImageButton = findViewById(R.id.btnDron)
        val Mac: ImageButton = findViewById(R.id.btnMac)
        val Audi: ImageButton = findViewById(R.id.btnAudi)
        val LentesVR: ImageButton = findViewById(R.id.btnVR)
        val btnVerCarro: Button = findViewById(R.id.btnVerCarro)
        val btnL: Button = findViewById(R.id.btnL)
        val db = SQLiteDB(this)
        db.limpiarcarrito()



        Mac.setOnClickListener{
            val producto = Producto(codigo = "MAP01", descripcion = "Macbook air pro", precio = 1599999.0)
            abrirProducto(producto)
        }
        LentesVR.setOnClickListener{
            val producto = Producto(codigo = "VVMQ01", descripcion = "Visor VR Meta Quest 2.", precio = 32999.0)
            abrirProducto(producto)
        }
        btnVerCarro.setOnClickListener {
            abrirCarrito()
        }
        Dron.setOnClickListener {
            val producto = Producto(codigo = "DAT01", descripcion = "Dron apache tactico", precio = 51990.0)
            abrirProducto(producto)
        }
        btnL.setOnClickListener {
            val productList = db.obtenerProductos()
            val texto = productList.joinToString("\n") { it.descripcion }
            val txtProd: TextView = findViewById(R.id.txtProd)
            txtProd.text = texto
        }
        Audi.setOnClickListener{
            val producto = Producto(codigo = "ASPG01", descripcion = "Audífonos Scorpion pro game", precio = 29990.0)
            abrirProducto(producto)
        }
    }

    private fun abrirProducto(producto: Producto) {
        val intent = Intent(this, ProductoActivity::class.java)
        intent.putExtra("producto", producto)
        startActivity(intent)
    }
    private fun abrirCarrito() {
        val intent = Intent(this, Carrito::class.java)
        startActivity(intent)
    }
}

