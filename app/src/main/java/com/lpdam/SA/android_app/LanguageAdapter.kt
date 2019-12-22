package com.lpdam.SA.android_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.lpdam.SA.android_app.models.Language
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_language.*
import kotlinx.android.synthetic.main.layout_language.view.*

class LanguageAdapter(val languages : ArrayList<Language>) : RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View?
            get() = itemView
        fun fetchLanguage(language: Language) {
            with(language) {
                //itemView.textViewTitle.text = language.text
                textViewLanguage.text = name
                //itemView.textViewType.text = language.type
                //itemView.textViewRating.text = language.rating
                //itemView.textViewLikePercent.text = language.likePercent.toString() + "%"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageAdapter.ViewHolder {
        return ViewHolder(parent.inflate((R.layout.layout_language)))
    }

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }



    override fun getItemCount() = languages.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fetchLanguage(languages[position])
    }


}