package com.example.Projet4A.presentation.list

import android.os.Bundle
import com.example.Projet4A.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Projet4A.data.local.models.Movie
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel


class ListActivity : AppCompatActivity() {
    private val viewModel: MovieListViewModel by viewModel()
    private lateinit var moviesList: MutableList<Movie>
    private lateinit var moviesListAdapter: MoviesListAdapter
    private var loadingMore = false
    private val visibleThreshold = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(bottom_App_bar as Toolbar?)
        bottom_app_bar_title.text = "en ce moment"

        setupRecyclerView()
        loadData()
    }

    private fun setupRecyclerView() {
        moviesList = mutableListOf()
        moviesListAdapter = MoviesListAdapter(this, moviesList)
        val layoutManager = GridLayoutManager(this, 2)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = moviesListAdapter

        recycler_view
            .addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    val totalItemCount = layoutManager.itemCount
                    val lastVisibleItem = layoutManager.findLastVisibleItemPosition()
                    if (!loadingMore && totalItemCount <= lastVisibleItem + visibleThreshold) {
                        loadingMore = true
                        if (totalItemCount % 20 == 0) {
                            viewModel.fetchMoreShowingMovies((totalItemCount / 20) + 1)
                        } else {
                            viewModel.fetchMoreShowingMovies((totalItemCount / 20) + 2)
                        }
                    }
                }
            })
    }

    private fun loadData() = GlobalScope.launch(Dispatchers.Main) {
        val movies = viewModel.movies.await()
        movies.observe(this@ListActivity, Observer {
            loadingMore = false
            if (!it.isNullOrEmpty()) {
                moviesListAdapter.setMovieList(it)
            } else {
                showSnackbar()
            }
        })
    }

    private fun showSnackbar() {
        Snackbar.make(main_wrapper, getString(R.string.empty_message), Snackbar.LENGTH_LONG).show()
    }


}
