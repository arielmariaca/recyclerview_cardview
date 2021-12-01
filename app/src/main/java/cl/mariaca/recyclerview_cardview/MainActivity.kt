package cl.mariaca.recyclerview_cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var preciolist = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postToList()

        val rv = findViewById<RecyclerView>(R.id.rv_recyclerView)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = RecyclerAdapter(titlesList, descList, preciolist, imagesList)

    }

    private fun addToList(title: String, description: String, precio:String, image: Int) {
        titlesList.add(title)
        descList.add(description)
        preciolist.add(precio)
        imagesList.add(image)
    }

    private fun postToList() {
        for (i in 1..10) {
            val valor = (i*10005).toString()
            addToList("Título $i", "Descripción es la numero # $i", "$ $valor", R.mipmap.ic_launcher)
        }
    }


}