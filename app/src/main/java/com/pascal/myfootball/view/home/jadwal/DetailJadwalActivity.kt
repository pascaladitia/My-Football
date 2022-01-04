package com.pascal.myfootball.view.home.jadwal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pascal.myfootball.R
import com.pascal.myfootball.model.EventsItem
import com.pascal.myfootball.viewModel.ViewModelFootball

class DetailJadwalActivity : AppCompatActivity() {

    private var item: EventsItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_jadwal)

        initView()
    }

    private fun initView() {

    }
}