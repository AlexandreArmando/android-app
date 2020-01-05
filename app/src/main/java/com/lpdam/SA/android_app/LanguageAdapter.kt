package com.lpdam.SA.android_app
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.lpdam.SA.android_app.models.Language
import com.lpdam.SA.android_app.ui.dashboard.DashboardFragment
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_language.*
import kotlinx.android.synthetic.main.layout_language.view.*


class LanguageAdapter(val languages : ArrayList<Language>, onLanguageListener: OnLanguageListener) : RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {

    val languageListener: OnLanguageListener = onLanguageListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageAdapter.ViewHolder {
        return ViewHolder(parent.inflate((R.layout.layout_language)), languageListener)
    }

    class ViewHolder(val view: View, languageListener: OnLanguageListener) : RecyclerView.ViewHolder(view), LayoutContainer, View.OnClickListener {

        val onLanguageListener: OnLanguageListener = languageListener

        override val containerView: View?
            get() = itemView

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onLanguageListener.onLanguageClicked(adapterPosition)
        }

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
                    5 -> imageView.setImageResource(R.drawable.react_native)
                }
                textViewTitle.text = name
                textViewLanguage.text = description
                textViewRating.text = rating
                itemView.textViewType.text = type

            }
        }
    }

    interface OnLanguageListener {
        fun onLanguageClicked(position: Int)
    }

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    override fun getItemCount() = languages.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fetchLanguage(languages[position])
    }


}