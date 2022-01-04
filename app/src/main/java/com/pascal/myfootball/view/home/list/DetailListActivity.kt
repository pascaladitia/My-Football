package com.pascal.myfootball.view.home.list

import android.graphics.text.LineBreaker
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.pascal.myfootball.R
import com.pascal.myfootball.model.TeamsItem
import kotlinx.android.synthetic.main.activity_detail_list.*

class DetailListActivity : AppCompatActivity() {

    private var item: TeamsItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_list)
        supportActionBar?.title = "Detail Club"

        initView()
    }

    private fun initView() {
        item = intent?.getParcelableExtra("data")

        profil_name.setText(item?.strTeam)
        profil_year.setText(item?.intFormedYear)
        profil_id.setText(item?.idTeam)
        profil_location.setText(item?.strStadiumLocation)
        profil_description.setText(item?.strDescriptionEN)

        Glide.with(this)
            .load(item?.strStadiumThumb)
            .apply(
                RequestOptions()
                    .override(500, 500)
                    .placeholder(R.drawable.stadion)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH))
            .into(profil_image)

        Glide.with(this)
            .load(item?.strTeamBadge)
            .apply(
                RequestOptions()
                    .override(500, 500)
                    .placeholder(R.drawable.logo)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH))
            .into(profile_photo)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            profil_description.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
        }
    }
}