package com.example.tiendas.activity

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tiendas.R
import com.example.tiendas.activity.model.TiendasResponse

class AdapterTiendas(var getTiendasResponse: ArrayList<TiendasResponse>,
): RecyclerView.Adapter<AdapterTiendas.TiendasViewHolder>() {

    class TiendasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var cardView: CardView
        var nameTienda: TextView
        var image: String = ""
        var imageTiendas: ImageView
        var addressTienda: TextView

        init {
            cardView = itemView.findViewById(R.id.cv_tiendas)
            nameTienda = itemView.findViewById(R.id.name)
            imageTiendas = itemView.findViewById(R.id.imv_cardview_tiendas)
            addressTienda = itemView.findViewById(R.id.address)
        }

        fun bind(tiendas: TiendasResponse) {
            nameTienda.text = tiendas.name
            addressTienda.text = tiendas.address
            image = tiendas.address
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TiendasViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).
        inflate(R.layout.card_view, viewGroup, false)
        return TiendasViewHolder(view)
    }

    override fun onBindViewHolder(tiendasViewHolder: TiendasViewHolder, position: Int) {
        val addressesPosition: TiendasResponse = getTiendasResponse[position]
        tiendasViewHolder.cardView.tag = position
        tiendasViewHolder.bind(addressesPosition)
    }

    override fun getItemCount(): Int {
        return getTiendasResponse.size
    }
}