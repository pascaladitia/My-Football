package com.pascal.myfootball.view.home.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.pascal.myfootball.R
import com.pascal.myfootball.model.CountriesItem
import com.pascal.myfootball.model.ResponseCountry
import com.pascal.myfootball.view.adapter.AdapterCountry
import com.pascal.myfootball.viewModel.ViewModelFootball
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: ViewModelFootball
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ViewModelFootball::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        attachObserve()
        viewModel.getCountryView()
    }

    private fun attachObserve() {
        viewModel.responseCountry.observe(viewLifecycleOwner, Observer {showSiswaView(it)})
        viewModel.isError.observe(viewLifecycleOwner, Observer { showError(it) })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer { showLoading(it) })
    }

    private fun showSiswaView(it: ResponseCountry) {
        val adapter = AdapterCountry(it.countries, object : AdapterCountry.OnClickListener {

            override fun detail(item: CountriesItem?) {
                val bundle = bundleOf("data" to item)
                navController.navigate(R.id.action_homeFragment_to_listTimActivity, bundle)
            }})
        recycler_country.adapter = adapter
    }

    private fun showError(it: Throwable?) {
        showToast(it.toString())
    }

    private fun showLoading(it: Boolean?) {
        if (it == true) {
            progress_country.visibility = View.VISIBLE
        } else {
            progress_country.visibility = View.GONE
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        attachObserve()
    }
}