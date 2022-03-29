package com.example.tiendas.activity

import com.example.tiendas.activity.model.TiendasResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("{establishments}")
    fun getTiendas(@Path("establishments") cp: String): Call<ArrayList<TiendasResponse>>
}