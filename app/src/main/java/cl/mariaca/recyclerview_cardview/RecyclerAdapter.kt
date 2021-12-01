package cl.mariaca.recyclerview_cardview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    private var titles: List<String>,
    private var details: List<String>,
    private var precio: List<String>,
    private var images: List<Int> ) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTitle: TextView = itemView.findViewById(R.id.tv_tittle)
        val itemDetails: TextView = itemView.findViewById(R.id.tv_description)
        val itemPrecio: TextView = itemView.findViewById(R.id.tv_precio)
        val itemPicture: ImageView = itemView.findViewById(R.id.iv_image)

        init {
            itemView.setOnClickListener{v: View ->
                val  position: Int = adapterPosition
                //Toast.makeText(itemView.context,"El click esta en: # ${position + 1}", Toast.LENGTH_SHORT).show()

                val intent = Intent(itemView.context, Activity2::class.java)

                intent.putExtra("tit", titles[position])
                intent.putExtra("desc", details[position])
                intent.putExtra("precio", precio[position])
                intent.putExtra("img", images[position])

                itemView.context.startActivity(intent)

            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return  ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetails.text = details[position]
        holder.itemPrecio.text = precio[position]
        holder.itemPicture.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}