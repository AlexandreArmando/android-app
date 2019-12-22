package com.lpdam.SA.android_app.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lpdam.SA.android_app.models.Language
import com.lpdam.SA.android_app.LanguageAdapter
import com.lpdam.SA.android_app.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private val languages : ArrayList<Language> = arrayListOf(Language("a", "ionic", "test", "web"), Language("b", "flutter", "test2", "natif"));

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        var languageRecyclerView = root.findViewById<View>(R.id.languageRecyclerView) as RecyclerView
        languageRecyclerView.layoutManager = LinearLayoutManager(this.context)
        languageRecyclerView.adapter = LanguageAdapter(languages)
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)

        return root
    }
}