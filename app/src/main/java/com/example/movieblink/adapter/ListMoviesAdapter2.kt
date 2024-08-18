package com.example.movieblink.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieblink.MainActivity
import com.example.movieblink.R
import com.example.movieblink.model.ListMovies2

class ListMoviesAdapter2(val movieList2: List<ListMovies2>) : RecyclerView.Adapter<ListMoviesAdapter2.MyViewHolder2>(){

    class MyViewHolder2(itemView: View):RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView =itemView.findViewById(R.id.imgMoviePoster)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMoviesAdapter2.MyViewHolder2 {
        return MyViewHolder2(LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false))
    }

    override fun onBindViewHolder(holder: ListMoviesAdapter2.MyViewHolder2, position: Int) {
        val item = movieList2[position]
        holder.imageView.setImageResource(item.movieImage)
    }

    override fun getItemCount(): Int {
        return movieList2.size
    }

}