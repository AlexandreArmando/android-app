package com.lpdam.SA.android_app.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.beust.klaxon.JsonReader
import com.beust.klaxon.Klaxon
import com.lpdam.SA.android_app.*
import com.lpdam.SA.android_app.models.Language
import java.io.StringReader

class DashboardFragment : Fragment(), LanguageAdapter.OnLanguageListener {

    private lateinit var dashboardViewModel: DashboardViewModel
    // The list of languages which will be extracted in the JSON file
    val languages = arrayListOf<Language>()

    class ViewHolder

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        // Parser
        val klaxon = Klaxon()
        // Parsing JSON to Language and add the new object to the list
        JsonReader(StringReader("[\n" +
                "  {\n" +
                "    \"name\" : \"Ionic\",\n" +
                "    \"id\" : 1,\n" +
                "    \"type\" : \"Web\",\n" +
                "    \"description\" : \"Framework base sur Typescript et Angular\",\n" +
                "    \"rating\" : \"3eme\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\" : \"Flutter\",\n" +
                "    \"id\" : 2,\n" +
                "    \"type\" : \"Natif\",\n" +
                "    \"description\" : \"Langage mobile développé par google\",\n" +
                "    \"rating\" : \"1er\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\" : \"Kotlin\",\n" +
                "    \"id\" : 3,\n" +
                "    \"type\" : \"JVM java\",\n" +
                "    \"description\" : \"Langage toutes plateformes 100% interopérable avec JAVA\",\n" +
                "    \"rating\" : \"2eme\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\" : \"Xamarin\",\n" +
                "    \"id\" : 4,\n" +
                "    \"type\" : \"Natif\",\n" +
                "    \"description\" : \"Langage basé sur C# .NET\",\n" +
                "    \"rating\" : \"4eme\"\n" +
                "  }\n" +
                "]")).use { reader ->
            reader.beginArray {
                while (reader.hasNext()) {
                    val language = klaxon.parse<Language>(reader)
                    languages.add(language!!)
                }
            }
        }

        // Recycler view declaration
        var languageRecyclerView = root.findViewById<View>(R.id.languageRecyclerView) as RecyclerView
        // Layout manager declaration that we need to manage the recycler view
        languageRecyclerView.layoutManager = LinearLayoutManager(this.context)
        // Adapter declaration to link the view and the datas
        languageRecyclerView.adapter = LanguageAdapter(languages, this)
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        return root
    }

    // On click on a language card, start the activity and show the course
    override fun onLanguageClicked(position: Int) {
        when (position) {
            0 -> startActivity(Intent(context, IonicActivity::class.java))
            1 -> startActivity(Intent(context, FlutterActivity::class.java))
            2 -> startActivity(Intent(context, KotlinActivity::class.java))
            3 -> startActivity(Intent(context, XamarinActivity::class.java))
        }
    }




}