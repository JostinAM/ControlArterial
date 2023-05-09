package com.example.controlarterial.dao

import com.example.controlarterial.entity.TomaArterial
import com.example.controlarterial.entity.TomasArteriales
import retrofit2.http.*

interface TomaArterialDAO {
    @GET("items")
    suspend fun getItems(): List<TomaArterial>

    @GET("items/{uuid}")
    suspend fun getItem(@Path("uuid") uuid: String): TomaArterial

    @POST("items")
    suspend fun createItem( @Body items: List<TomaArterial>): TomasArteriales

    @PUT("items/{uuid}")
    suspend fun updateItem(@Path("uuid") uuid: String, @Body item: TomaArterial): TomaArterial

    @DELETE("items/{uuid}")
    suspend fun deleteItem(@Path("uuid") uuid: String)
}