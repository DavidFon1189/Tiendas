package com.example.tiendas.activity.model

import com.google.gson.annotations.SerializedName

data class TiendasResponse(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("image")
    var image: String = "",
    @SerializedName("address")
    var address: String = "",
) {

}