package com.castprogramms.sfr.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseCompany(
    @SerializedName("items") @Expose val items: List<String>,
    @SerializedName("Count") @Expose val count: Int
)
