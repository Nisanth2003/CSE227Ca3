package com.example.movieblink.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieblink.R
import com.example.movieblink.model.ListMovies1


class ListMoviesAdapter1(val movieList : List<ListMovies1>,val listener: MyClickListener) : RecyclerView.Adapter<ListMoviesAdapter1.MyViewHolder>() {

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val imageView: ImageView =itemView.findViewById(R.id.imgMoviePoster)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = movieList[position]
        holder.imageView.setImageResource(item.movieImage)

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    interface MyClickListener {
        fun onClick(position: Int)
    }

}