package edu.pe.idat.appretrofitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var service: ApiServiceAlbum
    lateinit var rvalbum : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        rvalbum = findViewById(R.id.rvalbum)
        rvalbum.layoutManager = LinearLayoutManager(this)
        service = retrofit.create<ApiServiceAlbum>(ApiServiceAlbum::class.java)
        obtenerAlbum()
    }

    fun obtenerAlbum(){
        //Recibimos todos los posts
        service.getAllPosts().enqueue(object: Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>?,
                                    response: Response<List<Album>>?) {
                val albums = response?.body()
                rvalbum.adapter = AlbumAdapter(albums!!)
            }
            override fun onFailure(call: Call<List<Album>>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }
}