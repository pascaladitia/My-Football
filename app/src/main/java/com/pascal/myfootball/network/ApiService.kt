package com.pascal.myfootball.network

import com.pascal.myfootball.model.*
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("all_countries.php")
    fun getCountry(): Flowable<ResponseCountry>

    @GET("all_leagues.php")
    fun getLiga(): Flowable<ResponseLiga>

    @GET("search_all_teams.php")
    fun getTim(@Query("s")soccer: String,
                @Query("c")country: String): Flowable<ResponseTimbyLiga>

    @GET("searchteams.php")
    fun searchTim(@Query("t")name: String): Flowable<ResponseTimbyLiga>

    @GET("searchevents.php")
    fun searchJadwal(@Query("e")name: String): Flowable<ResponseLastJadwal>

    @GET("eventspastleague.php")
    fun getJadwal(@Query("id")id: String): Flowable<ResponseLastJadwal>
}