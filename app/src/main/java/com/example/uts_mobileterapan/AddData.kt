package com.example.uts_mobileterapan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_add_data.*
import org.json.JSONArray

class AddData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)
        back.setOnClickListener{
            startActivity(Intent(this@AddData,dashboard::class.java))
            finish()
        }

        btnTambah.setOnClickListener {

            var data_judul = edtJudul.text.toString()
            var data_waktu = edtWaktu.text.toString()
            var data_penulis = edtPenulis.text.toString()
            var data_isi = edtIsi.text.toString()

            postkeserver(data_judul, data_waktu, data_penulis, data_isi)

            startActivity(Intent(this@AddData,dashboard::class.java))
            finish()
        }
    }

    fun postkeserver(data1:String, data2:String, data3:String, data4:String){

        AndroidNetworking.post("http://192.168.0.7/mobile/add.php")
            .addBodyParameter("judul_berita", data1)
            .addBodyParameter("waktu_berita", data2)
            .addBodyParameter("penulis_berita", data3)
            .addBodyParameter("isi_berita", data4)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {
//                  do anything with response
                }

                override fun onError(anError: ANError?) {
                    // handle error
                }
            })
    }

}