package com.pascal.myfootball.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pascal.myfootball.model.*
import com.pascal.myfootball.repo.RepositoryFootball

class ViewModelFootball: ViewModel() {
    val repository = RepositoryFootball()

    var responseCountry = MutableLiveData<ResponseCountry>()
    var responseLiga = MutableLiveData<ResponseLiga>()
    var responseTim = MutableLiveData<ResponseTimbyLiga>()
    var responsesearch = MutableLiveData<ResponseSearch>()
    var responsejadwal = MutableLiveData<ResponseLastJadwal>()
    var responseDetailTim = MutableLiveData<ResponseDetailTIm>()
    var isError = MutableLiveData<Throwable>()
    var isLoading = MutableLiveData<Boolean>()

    fun getCountryView() {
        isLoading.value = true

        repository.getCountry({
            isLoading.value = false
            responseCountry.value = it
        },{
            isLoading.value = false
            isError.value = it
        })
    }

    fun getLigaView() {
        isLoading.value = true

        repository.getLiga({
            isLoading.value = false
            responseLiga.value = it
        },{
            isLoading.value = false
            isError.value = it
        })
    }

    fun getTimView(name: String) {
        isLoading.value = true

        repository.getTim(name, {
            isLoading.value = false
            responseTim.value = it
        },{
            isLoading.value = false
            isError.value = it
        })
    }

    fun getSearchView(name: String) {
        isLoading.value = true

        repository.searchTim(name, {
            isLoading.value = false
            responseTim.value = it
        },{
            isLoading.value = false
            isError.value = it
        })
    }

    fun getSearchJadwalView(name: String) {
        isLoading.value = true

        repository.searchJadwal(name, {
            isLoading.value = false
            responsejadwal.value = it
        },{
            isLoading.value = false
            isError.value = it
        })
    }

    fun getJadwalView(id: String) {
        isLoading.value = true

        repository.getJadwal(id, {
            isLoading.value = false
            responsejadwal.value = it
        },{
            isLoading.value = false
            isError.value = it
        })
    }
}