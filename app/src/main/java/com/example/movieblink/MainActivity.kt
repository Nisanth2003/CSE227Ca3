package com.example.movieblink

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.movieblink.adapter.ListMoviesAdapter1
import com.example.movieblink.adapter.ListMoviesAdapter2
import com.example.movieblink.adapter.ListMoviesAdapter3
import com.example.movieblink.adapter.ListMoviesAdapter4
import com.example.movieblink.databinding.ActivityMainBinding
import com.example.movieblink.model.ListMovies1
import com.example.movieblink.model.ListMovies2
import com.example.movieblink.model.ListMovies3
import com.example.movieblink.model.ListMovies4

class MainActivity : AppCompatActivity(),ListMoviesAdapter1.MyClickListener{

    private lateinit var image1 : ImageView
    private lateinit var image2 : ImageView
    private lateinit var image3 : ImageView
    private lateinit var image4 : ImageView
    private lateinit var image5 : ImageView
    private lateinit var image6 : ImageView

    private lateinit var viewpager : ViewPager2


    private lateinit var binding : ActivityMainBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterr: ListMoviesAdapter1
    private lateinit var movieList: ArrayList<ListMovies1>

    private lateinit var recyclerView2: RecyclerView
    private lateinit var adapter2: ListMoviesAdapter2
    private lateinit var movieList2 : ArrayList<ListMovies2>

    lateinit var recyclerView3: RecyclerView
    private lateinit var adapter3 : ListMoviesAdapter3
    lateinit var movieList3 : ArrayList<ListMovies3>

    lateinit var recyclerView4: RecyclerView
    private lateinit var adapter4 : ListMoviesAdapter4
    lateinit var movieList4 : ArrayList<ListMovies4>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewpager = findViewById(R.id.viewpager)
        image1    = findViewById(R.id.iv1)
        image2    = findViewById(R.id.iv2)
        image3    = findViewById(R.id.iv3)
        image4    = findViewById(R.id.iv4)
        image5    = findViewById(R.id.iv5)
        image6    = findViewById(R.id.iv6)

        val images = listOf(R.drawable.got,R.drawable.img_4,R.drawable.img_7,R.drawable.img_2,R.drawable.img_1,R.drawable.img_9)
        val adapter = ViewPagerAdapter(images)               // Here passing images to adapter
        viewpager.adapter = adapter                          // Here we setting adapter on viewpager


//        binding.apply {
//            rvMain.adapter = ParentAdapter(SampleData.collections)
//        }


        recyclerView = findViewById(R.id.recyclerView1)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        movieList = ArrayList()
        movieList.add(ListMovies1(R.drawable.imdb1,1))
        movieList.add(ListMovies1(R.drawable.imdb2,2))
        movieList.add(ListMovies1(R.drawable.imdb3,3))
        movieList.add(ListMovies1(R.drawable.imdb4,4))
        movieList.add(ListMovies1(R.drawable.imdb5,5))
        movieList.add(ListMovies1(R.drawable.imdb6,6))
        movieList.add(ListMovies1(R.drawable.imdb7,7))
        movieList.add(ListMovies1(R.drawable.imdb8,8))
        movieList.add(ListMovies1(R.drawable.imdb9,9))
        movieList.add(ListMovies1(R.drawable.imdb10,10))
        movieList.add(ListMovies1(R.drawable.imdb11,11))

        adapterr = ListMoviesAdapter1(movieList,this@MainActivity)
        recyclerView.adapter = adapterr


        recyclerView2 = findViewById(R.id.recyclerView2)
        recyclerView2.setHasFixedSize(true)
        recyclerView2.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        movieList2 = ArrayList()
        movieList2.add(ListMovies2(R.drawable.img_1,))
        movieList2.add(ListMovies2(R.drawable.img_2,))
        movieList2.add(ListMovies2(R.drawable.img_4,))
        movieList2.add(ListMovies2(R.drawable.img_7,))
        movieList2.add(ListMovies2(R.drawable.img_9,))

        adapter2 = ListMoviesAdapter2(movieList2)
        recyclerView2.adapter = adapter2




        recyclerView3 = findViewById(R.id.recyclerView3)
        recyclerView3.setHasFixedSize(true)
        recyclerView3.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        movieList3 = ArrayList()
        movieList3.add(ListMovies3(R.drawable.img_9,))
        movieList3.add(ListMovies3(R.drawable.img_7,))
        movieList3.add(ListMovies3(R.drawable.img_2,))
        movieList3.add(ListMovies3(R.drawable.img_4,))
        movieList3.add(ListMovies3(R.drawable.img_1,))
        movieList3.add(ListMovies3(R.drawable.img_9,))
        movieList3.add(ListMovies3(R.drawable.img_7,))
        movieList3.add(ListMovies3(R.drawable.img_2,))
        movieList3.add(ListMovies3(R.drawable.img_4,))
        movieList3.add(ListMovies3(R.drawable.img_1,))

        adapter3 = ListMoviesAdapter3(movieList3)
        recyclerView3.adapter = adapter3



        recyclerView4 = findViewById(R.id.recyclerView4)
        recyclerView4.setHasFixedSize(true)
        recyclerView4.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        movieList4 = ArrayList()
        movieList4.add(ListMovies4(R.drawable.img_2,))
        movieList4.add(ListMovies4(R.drawable.img_4,))
        movieList4.add(ListMovies4(R.drawable.img_9,))
        movieList4.add(ListMovies4(R.drawable.img_1,))
        movieList4.add(ListMovies4(R.drawable.img_7,))

        adapter4 = ListMoviesAdapter4(movieList4)
        recyclerView4.adapter = adapter4



        //Dot Indicator
        viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                changeColor()
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                changeColor()
            }
        })

    }
    //Dot Indicator change color
    fun changeColor(){

        when(viewpager.currentItem){
            0->{
                image1.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
                image2.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image3.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image4.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image5.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image6.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
            }
            1->{
                image1.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image2.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
                image3.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image4.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image5.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image6.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
            }
            2->{
                image1.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image2.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image3.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
                image4.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image5.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image6.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
            }
            3->{
                image1.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image2.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image3.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image4.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
                image5.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image6.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
            }
            4->{
                image1.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image2.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image3.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image4.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image5.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
                image6.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
            }
            5->{
                image1.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image2.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image3.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image4.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image5.setBackgroundColor(applicationContext.resources.getColor(R.color.lightmaincolour))
                image6.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
            }
        }
    }

    override fun onClick(position: Int) {


        // Retrieve the selected movie from the movieList based on the clicked position
        val selectedMovie = movieList[position]

        // Create an intent to navigate to DetailActivity
        val intent = Intent(this, DetailActivity::class.java)

        // Pass the correct movie ID to the DetailActivity
        intent.putExtra("MOVIE_ID", selectedMovie.id)

        // Start the DetailActivity with the intent
        startActivity(intent)
    }
}

