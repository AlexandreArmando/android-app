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

        /**
         * for each language in the array we fetch datas in the view
         */
        fun fetchLanguage(language: Language) {
            with(language) {
                when(id) {
                    1 -> imageView.setImageResource(R.drawable.ionic_framework)
                    2 -> imageView.setImageResource(R.drawable.flutter)
                    3 -> imageView.setImageResource(R.drawable.kotlin_java)
                    4 -> imageView.setImageResource(R.drawable.xamarin)
                    5 -> imageView.setImageResource(R.drawable.flutter)
                }
                textViewTitle.text = name
                textViewLanguage.text = description
                textViewRating.text = rating
                itemView.textViewType.text = type
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