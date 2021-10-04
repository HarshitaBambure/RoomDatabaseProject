package com.example.roomdatabaseproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class RecyclerAdapter() :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
     var listitem = mutableListOf<User>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_recycler, viewGroup, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        var data = listitem.get(i)
        Glide.with(viewHolder.img_android.context)
            .load(data.photo_product)
            .into(viewHolder.img_android)

        viewHolder.txt_product.text= data.product_name
        viewHolder.txt_price.text= data.price_name

    }

    override fun getItemCount(): Int {
        return listitem.size
    }

     fun Updatedata(listData:List<User>){
         listitem.clear()
         listitem.addAll(listData)
         notifyDataSetChanged()
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var img_android: ImageView
        var txt_price:TextView
        var txt_product:TextView

        init {
            img_android = view.findViewById<ImageView>(R.id.iv_shopping)
            txt_product = view.findViewById<TextView>(R.id.tv_product)
            txt_price = view.findViewById<TextView>(R.id.tv_price)

        }
    }

}