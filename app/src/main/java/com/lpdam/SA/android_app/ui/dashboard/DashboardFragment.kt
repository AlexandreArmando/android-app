package com.lpdam.SA.android_app.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonReader
import com.beust.klaxon.Klaxon
import com.beust.klaxon.Parser
import com.lpdam.SA.android_app.models.Language
import com.lpdam.SA.android_app.LanguageAdapter
import com.lpdam.SA.android_app.R
import java.io.StringReader


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    //private val languages : ArrayList<Language> = arrayListOf(Language("a", "ionic", "test", "web", "web"), Language("b", "flutter", "test2", "natif", "natif"))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val klaxon = Klaxon()
        val languages = arrayListOf<Language>()
        JsonReader(StringReader("[\n  {\n    \"name\" : \"Ionic\",\n    \"image\" : \"@drawable/ionic_framework\",\n    \"type\" : \"Web\",\n    \"description\" : \"Framework base sur Typescript et Angular\",\n    \"rating\" : \"3eme\"\n  },\n  {\n    \"name\" : \"Flutter\",\n    \"image\" : \"@drawable/flutter\",\n    \"type\" : \"Natif\",\n    \"description\" : \"Langage mobile développé par google\",\n    \"rating\" : \"1er\"\n  },\n  {\n    \"name\" : \"Kotlin\",\n    \"image\" : \"@drawable/kotlin\",\n    \"type\" : \"JVM java\",\n    \"description\" : \"Langage toutes plateformes 100% interopérable avec JAVA\",\n    \"rating\" : \"2eme\"\n  },\n  {\n    \"name\" : \"Xamarin\",\n    \"image\" : \"@drawable/xamarin\",\n    \"type\" : \"Natif\",\n    \"description\" : \"Langage basé sur C# .NET\",\n    \"rating\" : \"4eme\"\n  }\n]")).use { reader ->
            reader.beginArray {
                while (reader.hasNext()) {
                    val language = klaxon.parse<Language>(reader)
                    languages.add(language!!)
                }
            }
        }
        var languageRecyclerView = root.findViewById<View>(R.id.languageRecyclerView) as RecyclerView
        languageRecyclerView.layoutManager = LinearLayoutManager(this.context)
        languageRecyclerView.adapter = LanguageAdapter(languages)
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)

       // val obj = Klaxon().parse<Language>("[\n  {\n    \"name\" : \"Ionic\",\n    \"image\" : \"@drawable/ionic_framework\",\n    \"type\" : \"Web\",\n    \"description\" : \"Framework base sur Typescript et Angular\",\n    \"rating\" : \"3eme\"\n  },\n  {\n    \"name\" : \"Flutter\",\n    \"image\" : \"@drawable/flutter\",\n    \"type\" : \"Natif\",\n    \"description\" : \"Langage mobile développé par google\",\n    \"rating\" : \"1er\"\n  },\n  {\n    \"name\" : \"Kotlin\",\n    \"image\" : \"@drawable/kotlin\",\n    \"type\" : \"JVM java\",\n    \"description\" : \"Langage toutes plateformes 100% interopérable avec JAVA\",\n    \"rating\" : \"2eme\"\n  },\n  {\n    \"name\" : \"Xamarin\",\n    \"image\" : \"@drawable/xamarin\",\n    \"type\" : \"Natif\",\n    \"description\" : \"Langage basé sur C# .NET\",\n    \"rating\" : \"4eme\"\n  }\n]")

        return root
    }


}