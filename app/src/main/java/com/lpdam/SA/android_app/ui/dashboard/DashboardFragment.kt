package com.lpdam.SA.android_app.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lpdam.SA.android_app.Language
import com.lpdam.SA.android_app.LanguageAdapter
import com.lpdam.SA.android_app.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var languages : ArrayList<Language>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        return root
        refreshLayout.setOnRefreshListener {
            fetchLanguages()
        }

        fetchLanguages()

    }
    private fun showlanguages(languages: List<Language>) {
        recyclerViewLanguages.layoutManager = LinearLayoutManager(this.context)
        recyclerViewLanguages.adapter = LanguageAdapter(languages)
    }

    private fun fetchLanguages() {
        var nameArray = resources.getStringArray(R.array.courses_list)
        languages = ArrayList()
        for (i in 0..(nameArray.size-1))
           languages[i] = Language(nameArray[i])


    }
}