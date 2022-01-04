package com.pascal.myfootball.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseCountry(

	@field:SerializedName("countries")
	val countries: List<CountriesItem?>? = null
) : Parcelable

@Parcelize
data class CountriesItem(

	@field:SerializedName("name_en")
	val nameEn: String? = null
) : Parcelable
