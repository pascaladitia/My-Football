package com.pascal.myfootball.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseTimbyLiga(

	@field:SerializedName("teams")
	val teams: List<TeamsItem?>? = null
) : Parcelable

@Parcelize
data class TeamsItem(

	@field:SerializedName("intStadiumCapacity")
	val intStadiumCapacity: String? = null,

	@field:SerializedName("strTeamShort")
	val strTeamShort: String? = null,

	@field:SerializedName("idLeague3")
	val idLeague3: String? = null,

	@field:SerializedName("idLeague2")
	val idLeague2: String? = null,

	@field:SerializedName("idLeague5")
	val idLeague5: String? = null,

	@field:SerializedName("strSport")
	val strSport: String? = null,

	@field:SerializedName("idLeague4")
	val idLeague4: String? = null,

	@field:SerializedName("idLeague7")
	val idLeague7: String? = null,

	@field:SerializedName("strDescriptionCN")
	val strDescriptionCN: String? = null,

	@field:SerializedName("idLeague6")
	val idLeague6: String? = null,

	@field:SerializedName("strTeamJersey")
	val strTeamJersey: String? = null,

	@field:SerializedName("strTeamFanart2")
	val strTeamFanart2: String? = null,

	@field:SerializedName("strTeamFanart3")
	val strTeamFanart3: String? = null,

	@field:SerializedName("strTeamFanart4")
	val strTeamFanart4: String? = null,

	@field:SerializedName("strStadiumDescription")
	val strStadiumDescription: String? = null,

	@field:SerializedName("strTeamFanart1")
	val strTeamFanart1: String? = null,

	@field:SerializedName("intLoved")
	val intLoved: String? = null,

	@field:SerializedName("idLeague")
	val idLeague: String? = null,

	@field:SerializedName("idSoccerXML")
	val idSoccerXML: String? = null,

	@field:SerializedName("strTeamLogo")
	val strTeamLogo: String? = null,

	@field:SerializedName("strDescriptionSE")
	val strDescriptionSE: String? = null,

	@field:SerializedName("strDescriptionJP")
	val strDescriptionJP: String? = null,

	@field:SerializedName("strDescriptionFR")
	val strDescriptionFR: String? = null,

	@field:SerializedName("strStadiumLocation")
	val strStadiumLocation: String? = null,

	@field:SerializedName("strDescriptionNL")
	val strDescriptionNL: String? = null,

	@field:SerializedName("strCountry")
	val strCountry: String? = null,

	@field:SerializedName("strRSS")
	val strRSS: String? = null,

	@field:SerializedName("strDescriptionRU")
	val strDescriptionRU: String? = null,

	@field:SerializedName("strTeamBanner")
	val strTeamBanner: String? = null,

	@field:SerializedName("strDescriptionNO")
	val strDescriptionNO: String? = null,

	@field:SerializedName("strStadiumThumb")
	val strStadiumThumb: String? = null,

	@field:SerializedName("strDescriptionES")
	val strDescriptionES: String? = null,

	@field:SerializedName("intFormedYear")
	val intFormedYear: String? = null,

	@field:SerializedName("strInstagram")
	val strInstagram: String? = null,

	@field:SerializedName("strDescriptionIT")
	val strDescriptionIT: String? = null,

	@field:SerializedName("idTeam")
	val idTeam: String? = null,

	@field:SerializedName("strDescriptionEN")
	val strDescriptionEN: String? = null,

	@field:SerializedName("strWebsite")
	val strWebsite: String? = null,

	@field:SerializedName("strYoutube")
	val strYoutube: String? = null,

	@field:SerializedName("strDescriptionIL")
	val strDescriptionIL: String? = null,

	@field:SerializedName("idAPIfootball")
	val idAPIfootball: String? = null,

	@field:SerializedName("strLocked")
	val strLocked: String? = null,

	@field:SerializedName("strAlternate")
	val strAlternate: String? = null,

	@field:SerializedName("strTeam")
	val strTeam: String? = null,

	@field:SerializedName("strTwitter")
	val strTwitter: String? = null,

	@field:SerializedName("strDescriptionHU")
	val strDescriptionHU: String? = null,

	@field:SerializedName("strGender")
	val strGender: String? = null,

	@field:SerializedName("strDivision")
	val strDivision: String? = null,

	@field:SerializedName("strStadium")
	val strStadium: String? = null,

	@field:SerializedName("strFacebook")
	val strFacebook: String? = null,

	@field:SerializedName("strTeamBadge")
	val strTeamBadge: String? = null,

	@field:SerializedName("strLeague2")
	val strLeague2: String? = null,

	@field:SerializedName("strLeague3")
	val strLeague3: String? = null,

	@field:SerializedName("strLeague4")
	val strLeague4: String? = null,

	@field:SerializedName("strLeague5")
	val strLeague5: String? = null,

	@field:SerializedName("strDescriptionPT")
	val strDescriptionPT: String? = null,

	@field:SerializedName("strLeague6")
	val strLeague6: String? = null,

	@field:SerializedName("strDescriptionDE")
	val strDescriptionDE: String? = null,

	@field:SerializedName("strLeague7")
	val strLeague7: String? = null,

	@field:SerializedName("strLeague")
	val strLeague: String? = null,

	@field:SerializedName("strManager")
	val strManager: String? = null,

	@field:SerializedName("strKeywords")
	val strKeywords: String? = null,

	@field:SerializedName("strDescriptionPL")
	val strDescriptionPL: String? = null
) : Parcelable
