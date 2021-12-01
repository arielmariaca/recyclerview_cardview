package cl.mariaca.recyclerview_cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val bundle: Bundle? = intent.extras
        bundle?.let {
            val titulo = bundle.getString("tit")
            val desc = bundle.getString("desc")
            val precio = bundle.getString("precio")
            val imagen = bundle.getInt("img")
            findViewById<TextView>(R.id.textoIntent).text = titulo+'\n'+desc+'\n'+precio+'\n'+imagen
        }
    }
}