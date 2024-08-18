package com.example.movieblink.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieblink.R
import com.example.movieblink.adapter.ListMoviesAdapter2.MyViewHolder2
import com.example.movieblink.model.ListMovies4

class ListMoviesAdapter4 (val movieList4: List<ListMovies4>): RecyclerView.Adapter<ListMoviesAdapter4.MyViewHolder4>(){

    class MyViewHolder4(itemView: View):RecyclerView.ViewHolder(itemView)  {

        val imageView: ImageView =itemView.findViewById(R.id.imgMoviePoster)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMoviesAdapter4.MyViewHolder4 {
        return MyViewHolder4(LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false))
    }

    override fun onBindViewHolder(holder: ListMoviesAdapter4.MyViewHolder4, position: Int) {
        val item = movieList4[position]
        holder.imageView.setImageResource(item.movieImage)
    }

    override fun getItemCount(): Int {
        return movieList4.size
    }
}