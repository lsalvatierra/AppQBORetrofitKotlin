package edu.pe.idat.appretrofitkotlin

import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceAlbum {

    @GET("albums")
    fun getAllPosts(): Call<List<Album>>
}