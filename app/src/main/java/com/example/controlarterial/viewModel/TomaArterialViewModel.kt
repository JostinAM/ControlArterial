package com.example.controlarterial.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.controlarterial.AuthInterceptor
import com.example.controlarterial.dao.TomaArterialDAO
import com.example.controlarterial.entity.TomaArterial
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TomaArterialViewModel: ViewModel() {
    private val _listLiveData: MutableLiveData<List<TomaArterial>> = MutableLiveData()
    val listLiveData: LiveData<List<TomaArterial>> = _listLiveData
    lateinit var apiService: TomaArterialDAO

    fun initService() {
        val client = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor("ezPnykXgMF2mvQTyfZt2SMQhfbVVHpzVZkmSH7qXhcynO-28rg"))
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://crudapi.co.uk/api/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiService = retrofit.create(TomaArterialDAO::class.java)
    }

    suspend fun listTomaArterial() {
        initService()
        val lista = apiService.getItems()
        _listLiveData.postValue(lista.items)

    }


}
