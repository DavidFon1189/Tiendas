package com.example.tiendas.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tiendas.R
import com.example.tiendas.activity.model.TiendasResponse
import com.example.tiendas.activity.presenter.TiendaContract
import com.example.tiendas.activity.presenter.TiendasPresenter
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Response

class Tiendas: BaseActivity<TiendasPresenter>(), TiendaContract.View, View.OnClickListener{

    private var recyclerView: RecyclerView? = null
    private var bottonNav: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tiendas_activity)
        getTiendas("establishments")
        recyclerView = findViewById(R.id.recycler_view)
        val bottomNavigation: BottomNavigationView = findViewById(R.id.botton_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun createPresenter(context: Context): TiendasPresenter {
        return TiendasPresenter(this, RetrofitClient)
    }

    override fun onClick(p0: View?) {

    }

    override fun getTiendas(establishments: String) {
        presenter.getTiendas(establishments)
    }

    override fun successGeetTiendas(response: Response<ArrayList<TiendasResponse>>) {
        val getTiendaResponse: ArrayList<TiendasResponse>? = response.body()
        var tiendasResponse: TiendasResponse?
        val listAddresses: ArrayList<TiendasResponse> = ArrayList()
        getTiendaResponse?.forEach { element ->
            tiendasResponse = TiendasResponse(
                element.id,
                element.name,
                element.image,
                element.address
            )
            listAddresses.add(tiendasResponse!!)
        }

        val adapter = AdapterTiendas(
            listAddresses
        )
        recyclerView?.adapter = adapter
    }

    override fun failGetAddresses(message: String?) {

    }

    override fun failGetAddressesServer(message: String?) {

    }

    override fun loadingData() {

    }

    override fun hideDataLoad() {
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_producto -> {
                startActivity(Intent(this, Tiendas::class.java))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}