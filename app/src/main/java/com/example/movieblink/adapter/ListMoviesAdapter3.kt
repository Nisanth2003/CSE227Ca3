package com.example.movieblink.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieblink.R
import com.example.movieblink.adapter.ListMoviesAdapter2.MyViewHolder2
import com.example.movieblink.model.ListMovies3

class ListMoviesAdapter3(val movieList3: List<ListMovies3>): RecyclerView.Adapter<ListMoviesAdapter3.MyViewHolder3>(){

    class MyViewHolder3(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView =itemView.findViewById(R.id.imgMoviePoster)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMoviesAdapter3.MyViewHolder3 {
        return MyViewHolder3(LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false))
    }

    override fun onBindViewHolder(holder: ListMoviesAdapter3.MyViewHolder3, position: Int) {
        val item = movieList3[position]
        holder.imageView.setImageResource(item.movieImage)
    }

    override fun getItemCount(): Int {
        return movieList3.size
    }
}