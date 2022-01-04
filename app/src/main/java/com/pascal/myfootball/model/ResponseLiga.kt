package com.pascal.myfootball.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseLiga(

	@field:SerializedName("leagues")
	val leagues: List<LeaguesItem?>? = null
) : Parcelable

@Parcelize
data class LeaguesItem(

	@field:SerializedName("strLeagueAlternate")
	val strLeagueAlternate: String? = null,

	@field:SerializedName("strLeague")
	val strLeague: String? = null,

	@field:SerializedName("strSport")
	val strSport: String? = null,

	@field:SerializedName("idLeague")
	val idLeague: String? = null
) : Parcelable
