package com.pascal.myfootball.view.home.jadwal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pascal.myfootball.R
import com.pascal.myfootball.model.*
import com.pascal.myfootball.view.adapter.AdapterJadwal
import com.pascal.myfootball.view.adapter.AdapterTim
import com.pascal.myfootball.view.home.list.DetailListActivity
import com.pascal.myfootball.viewModel.ViewModelFootball
import kotlinx.android.synthetic.main.activity_jadwal_liga.*

class JadwalLigaActivity : AppCompatActivity() {

    private var item: LeaguesItem? = null
    private lateinit var viewModel: ViewModelFootball

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jadwal_liga)
        supportActionBar?.hide()

        initView()
        attachObserve()
        initSearch()
    }

    private fun initSearch() {
        jadwal_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.getSearchJadwalView(query)
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.getSearchJadwalView(newText)
                return false
            }
        })
    }

    private fun initView() {
        item = intent?.getParcelableExtra("data")

        viewModel = ViewModelProviders.of(this).get(ViewModelFootball::class.java)
        viewModel.getJadwalView(item?.idLeague.toString())

    }

    private fun attachObserve() {
        viewModel.responsejadwal.observe(this, Observer { showData(it) })
        viewModel.isLoading.observe(this, Observer { showLoading(it) })
        viewModel.isError.observe(this, Observer { showError(it) })
    }

    private fun showData(it: ResponseLastJadwal) {
        val adapter = AdapterJadwal(it?.events, object : AdapterJadwal.OnClickListener {

            override fun detail(item: EventsItem?) {
                val intent = Intent(this@JadwalLigaActivity, DetailJadwalActivity::class.java)
                intent.putExtra("data", item)
                startActivity(intent)
            }
        })
        recyclerview_jadwal.adapter = adapter
    }

    private fun showLoading(it: Boolean?) {
        if (it == true) {
            progress_jadwal.visibility = View.VISIBLE
        } else {
            progress_jadwal.visibility = View.GONE
        }
    }

    private fun showError(it: Throwable?) {
        showToast(it.toString())
    }

    private fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        attachObserve()
    }
}