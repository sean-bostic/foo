package com.sean.foo.api

import com.sean.foo.data.models.Country
import retrofit2.http.GET


interface CountryApi {
    @GET("all")
    suspend fun getCountries() : List<Country>
}