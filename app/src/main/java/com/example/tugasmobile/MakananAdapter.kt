package com.example.tugasmobile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MakananAdapter constructor(private val context: Context) : BaseAdapter() {

internal var makanan = arrayListOf<Makanan>()
override fun getView(position: Int, v: View?, viewGroup: ViewGroup): View {
    var itemView = v
    if (itemView == null) {
        itemView = LayoutInflater.from(context).inflate(R.layout.makanan, viewGroup, false)
    }
    val viewHolder = ViewHolder(itemView as View)
    val _makanan = getItem(position) as Makanan
    viewHolder.bind(_makanan)
    return itemView
}
override fun getCount(): Int = makanan.size

override fun getItem(i: Int): Any = makanan[i]

override fun getItemId(i: Int): Long = i.toLong()

private inner class ViewHolder constructor(view: View) {
    private val tvNama: TextView = view.findViewById(R.id.tv_nama)
    private val tvKet: TextView = view.findViewById(R.id.tv_ket)
    private val imgPhoto: ImageView = view.findViewById(R.id.img_item_photo)
    fun bind(makanan: Makanan) {
        tvNama.text = makanan.nama
        tvKet.text = makanan.deskripsi
        imgPhoto.setImageResource(makanan.foto)
    }
}
}