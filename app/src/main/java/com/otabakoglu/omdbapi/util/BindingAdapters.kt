package com.otabakoglu.omdbapi.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.otabakoglu.omdbapi.R
import com.otabakoglu.omdbapi.data.model.FilmProperty
import com.otabakoglu.omdbapi.data.source.remote.OmdbApiStatus
import com.otabakoglu.omdbapi.ui.main.adapter.FilmGridAdapter

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?){
    imageUrl?.let {
        Glide.with(imageView.context)
            .load(imageUrl)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_connection_error))
            .into(imageView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<FilmProperty>?){
    val adapter = recyclerView.adapter as FilmGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(imageView: ImageView, status: OmdbApiStatus?){
    when(status){
        OmdbApiStatus.DONE -> {
            imageView.visibility = View.GONE
        }
        OmdbApiStatus.LOADING -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.loading_animation)
        }
        OmdbApiStatus.ERROR -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.ic_connection_error)
        }

        OmdbApiStatus.FILM_NOT_FOUND -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.ic_launcher)
        }
    }
}