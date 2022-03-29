package com.example.tiendas.activity.presenter

import com.example.tiendas.activity.BasePresenter
import com.example.tiendas.activity.RetrofitClient
import com.example.tiendas.activity.model.TiendasResponse
import com.example.tiendas.activity.presenter.TiendaContract
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TiendasPresenter constructor(view: TiendaContract.View, retrofitClient: RetrofitClient) :
    BasePresenter(), TiendaContract.Presenter {
    var view: TiendaContract.View? = null
    var retrofitClient: RetrofitClient? = null

    init {
        this.view = view
        this.retrofitClient = retrofitClient
    }

    override fun getTiendas(establishments: String) {
        view?.loadingData()
        RetrofitClient.provideAPIService()?.getTiendas(establishments)?.enqueue(object :
            Callback<ArrayList<TiendasResponse>> {
            override fun onFailure(call: Call<ArrayList<TiendasResponse>>, t: Throwable) {
                view?.failGetAddressesServer("Fallo la conexion")
                view?.hideDataLoad()
            }

            override fun onResponse(call: Call<ArrayList<TiendasResponse>>, response: Response<ArrayList<TiendasResponse>>) {
                if (response.isSuccessful) {
                    view?.successGeetTiendas(response)
                    view?.hideDataLoad()
                } else {
                    view?.failGetAddresses("Fallo al consultar")
                    view?.hideDataLoad()
                }
            }
        })
    }
}