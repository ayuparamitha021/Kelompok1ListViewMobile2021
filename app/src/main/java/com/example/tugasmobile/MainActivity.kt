package com.example.tugasmobile

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var dataNama: Array<String>
    private lateinit var dataDeskripsi: Array<String>
    private lateinit var dataFoto: TypedArray
    private lateinit var adapter: MakananAdapter
    private var makanan_= arrayListOf<Makanan>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView: ListView = findViewById(R.id.lv_makanan)
        adapter = MakananAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, "Nama : ${makanan_[position].nama} ", Toast.LENGTH_SHORT).show()
        }
    }
    private fun prepare() {
        dataNama = resources.getStringArray(R.array.data_nama)
        dataDeskripsi = resources.getStringArray(R.array.data_deskripsi)
        dataFoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataNama.indices) {
            val pesawat = Makanan(
                dataNama[position],
                dataDeskripsi[position],
                dataFoto.getResourceId(position, -1)
            )
            makanan_.add(pesawat)
        }
        adapter.makanan = makanan_
    }
}