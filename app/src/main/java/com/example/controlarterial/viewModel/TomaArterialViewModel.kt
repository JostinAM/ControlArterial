package com.example.controlarterial.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.controlarterial.entity.TomaArterial

class TomaArterialViewModel: ViewModel() {
    private val _listLiveData: MutableLiveData<List<TomaArterial>> = MutableLiveData()
    val listLiveData: LiveData<List<TomaArterial>> = _listLiveData

    fun listTomaArterial(){


        //_listLiveData.value =
    }
}
