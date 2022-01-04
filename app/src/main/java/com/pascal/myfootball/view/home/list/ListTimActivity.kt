package com.pascal.myfootball.view.home.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pascal.myfootball.R
import com.pascal.myfootball.model.CountriesItem
import com.pascal.myfootball.model.ResponseTimbyLiga
import com.pascal.myfootball.model.TeamsItem
import com.pascal.myfootball.view.adapter.AdapterTim
import com.pascal.myfootball.viewModel.ViewModelFootball
import kotlinx.android.synthetic.main.activity_list_tim.*

class ListTimActivity : AppCompatActivity() {

    private var item: CountriesItem? = null
    private lateinit var viewModel: ViewModelFootball

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_tim)
        supportActionBar?.hide()

        initView()
        attachObserve()
        initSearch()
    }

    private fun initSearch() {
        listTim_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.getSearchView(query)
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.getSearchView(newText)
                return false
            }
        })
    }

    private fun initView() {
        item = intent?.getParcelableExtra("data")

        viewModel = ViewModelProviders.of(this).get(ViewModelFootball::class.java)
        viewModel.getTimView(item?.nameEn.toString())

    }

    private fun attachObserve() {
        viewModel.responseTim.observe(this, Observer { showData(it) })
        viewModel.isLoading.observe(this, Observer { showLoading(it) })
        viewModel.isError.observe(this, Observer { showError(it) })
    }

    private fun showData(it: ResponseTimbyLiga?) {
        val adapter = AdapterTim(it?.teams, object : AdapterTim.OnClickListener {

            override fun detail(item: TeamsItem?) {
                val intent = Intent(this@ListTimActivity, DetailListActivity::class.java)
                intent.putExtra("data", item)
                startActivity(intent)
            }
        })
        recyclerview_listTim.adapter = adapter
    }

    private fun showLoading(it: Boolean?) {
        if (it == true) {
            progress_listTim.visibility = View.VISIBLE
        } else {
            progress_listTim.visibility = View.GONE
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