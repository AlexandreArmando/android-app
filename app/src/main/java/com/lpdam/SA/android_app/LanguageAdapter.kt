package com.lpdam.SA.android_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_language.view.*

class LanguageAdapter(val languages : List<Language>) : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_language, parent, false)
        )
    }

    override fun getItemCount() = languages.size

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val language = languages[position]
        holder.bindAndVersion(languages[position])
    }

    class LanguageViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bindAndVersion(language: Language) {
            with(language) {
                //itemView.textViewTitle.text = language.text
                itemView.textViewLanguage.text = language.language
                //itemView.textViewType.text = language.type
                //itemView.textViewRating.text = language.rating
                //itemView.textViewLikePercent.text = language.likePercent.toString() + "%"
            }
        }
    }
}