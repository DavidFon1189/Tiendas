package com.example.tiendas.activity.presenter

import com.example.tiendas.activity.model.TiendasResponse
import retrofit2.Response

class TiendaContract {
    interface View{
        fun getTiendas(establishments: String)
        fun successGeetTiendas(response: Response<ArrayList<TiendasResponse>>)
        fun failGetAddresses(message: String?)
        fun failGetAddressesServer(message: String?)
        fun loadingData()
        fun hideDataLoad()
    }

    interface Presenter {
        fun getTiendas(establishments: String)
    }
}