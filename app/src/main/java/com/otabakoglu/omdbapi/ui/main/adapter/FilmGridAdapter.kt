package com.otabakoglu.omdbapi.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.otabakoglu.omdbapi.data.model.FilmProperty
import com.otabakoglu.omdbapi.databinding.GridItemFilmBinding

class FilmGridAdapter(private val onClickListener: OnClickListener):
    ListAdapter<FilmProperty, FilmGridAdapter.FilmPropertyViewHolder>(DiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmPropertyViewHolder {
        val binding = GridItemFilmBinding.inflate(LayoutInflater.from(parent.context))
        return FilmPropertyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmPropertyViewHolder, position: Int) {
        val filmProperty = getItem(position)
        holder.bind(filmProperty)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(filmProperty)
        }
    }

    class FilmPropertyViewHolder(private var binding: GridItemFilmBinding):
            RecyclerView.ViewHolder(binding.root){
        fun bind(filmProperty: FilmProperty){
            binding.property = filmProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<FilmProperty>() {
        override fun areItemsTheSame(oldItem: FilmProperty, newItem: FilmProperty): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: FilmProperty, newItem: FilmProperty): Boolean = oldItem == newItem
    }

    class OnClickListener(val clickListener: (filmProperty: FilmProperty) -> Unit){
        fun onClick(filmProperty: FilmProperty) = clickListener(filmProperty)
    }


}