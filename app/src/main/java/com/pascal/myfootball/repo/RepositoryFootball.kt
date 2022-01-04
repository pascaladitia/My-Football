package com.pascal.myfootball.repo

import com.pascal.myfootball.model.*
import com.pascal.myfootball.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class RepositoryFootball {

    fun getCountry(responHandler: (ResponseCountry) -> Unit, errorHandler: (Throwable) -> Unit) {
        ConfigNetwork.getService().getCountry().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun getLiga(responHandler: (ResponseLiga) -> Unit, errorHandler: (Throwable) -> Unit) {
        ConfigNetwork.getService().getLiga().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun getTim(country: String, responHandler: (ResponseTimbyLiga) -> Unit, errorHandler: (Throwable) -> Unit) {
        ConfigNetwork.getService().getTim("Soccer",country).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun searchTim(name: String, responHandler: (ResponseTimbyLiga) -> Unit, errorHandler: (Throwable) -> Unit) {
        ConfigNetwork.getService().searchTim(name).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun searchJadwal(name: String, responHandler: (ResponseLastJadwal) -> Unit, errorHandler: (Throwable) -> Unit) {
        ConfigNetwork.getService().searchJadwal(name).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun getJadwal(id: String, responHandler: (ResponseLastJadwal) -> Unit, errorHandler: (Throwable) -> Unit) {
        ConfigNetwork.getService().getJadwal(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }
}