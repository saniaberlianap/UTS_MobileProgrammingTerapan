package com.example.uts_mobileterapan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (val userList: ArrayList<User>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user: User=userList[position]
        holder?.textViewJudul_berita?.text = user.judul_berita
        holder?.textViewWaktu_berita?.text = user.waktu_berita
        holder?.textViewPenulis_berita?.text = user.penulis_berita
        holder?.textViewIsi_berita?.text = user.isi_berita

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return  ViewHolder(v)

    }


    override fun getItemCount(): Int {

        return userList.size
    }



    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val textViewJudul_berita = itemView.findViewById(R.id.textViewJudul) as TextView
        val textViewWaktu_berita= itemView.findViewById(R.id.textViewWaktu) as TextView
        val textViewPenulis_berita = itemView.findViewById(R.id.textViewPenulis) as TextView
        val textViewIsi_berita = itemView.findViewById(R.id.textViewIsi) as TextView




    }




}