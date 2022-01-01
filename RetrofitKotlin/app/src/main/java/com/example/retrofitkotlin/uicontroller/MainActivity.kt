package com.example.retrofitkotlin.uicontroller

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitkotlin.R
import com.example.retrofitkotlin.adapter.DataAdapter
import com.example.retrofitkotlin.model.AlbumDataModel
import com.example.retrofitkotlin.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    lateinit var progressDialog: ProgressDialog
    lateinit var recyclerView : RecyclerView
    var albumlist: ArrayList<AlbumDataModel> = ArrayList<AlbumDataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.adapter = DataAdapter(albumlist, this)
        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        progressDialog= ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setCancelable(false)
        progressDialog.show()
        getRetroData()


    }

    private fun getRetroData() {

        val call : Call<List<AlbumDataModel>> = RetrofitClient.retrofitApiInterface.getPhotos()

        call.enqueue(object : Callback<List<AlbumDataModel>> {

            override fun onResponse(call: Call<List<AlbumDataModel>>?, response: Response<List<AlbumDataModel>>?) {
                progressDialog.dismiss()
                albumlist.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<AlbumDataModel>>?, t: Throwable?) {
                progressDialog.dismiss()
            }

        })

    }
}