package com.emanuel.alkemychallenge.ui.details

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.emanuel.alkemychallenge.R
import com.emanuel.alkemychallenge.data.TMDb
import com.emanuel.alkemychallenge.databinding.FragmentMovieDetailsBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {
    private val args by navArgs<MovieDetailsFragmentArgs>()
    //Returns a Lazy delegate to access the Fragment's arguments as an Args instance.
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMovieDetailsBinding.bind(view)

        with(binding) {
            val movie = args.movie
            //A singleton to present a simple static interface for building requests with
            // RequestBuilder and maintaining an Engine, BitmapPool,
            Glide.with(this@MovieDetailsFragment)
                .load(TMDb.base_img_url + movie.backdropPath)
                .error(R.drawable.ic_error)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        Glide.with(this@MovieDetailsFragment)
                            .load(TMDb.base_img_url + movie.posterPath)
                            .error(R.drawable.ic_error)
                            .into(ivPoster)
                        progressBar.isVisible = false
                        tvTitle.isVisible = true
                        tvAverage.isVisible = true
                        tvLanguage.isVisible = true
                        tvPopularity.isVisible = true
                        tvOverview.isVisible = true
                        link.isVisible = true
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        Glide.with(this@MovieDetailsFragment)
                            .load(TMDb.base_img_url + movie.posterPath)
                            .error(R.drawable.ic_error)
                            .into(ivPoster)
                        progressBar.isVisible = false
                        tvTitle.isVisible = true
                        tvAverage.isVisible = true
                        tvLanguage.isVisible = true
                        tvPopularity.isVisible = true
                        tvOverview.isVisible = true
                        link.isVisible = true
                        return false
                    }
                })
                .into(ivBackdrop)

            tvTitle.text = movie.title

            tvLanguage.text = movie.originalLanguage.uppercase()
            tvOverview.text = movie.overview
            tvPopularity.text = movie.popularity.toString()
            tvAverage.text = "${movie.voteAverage}/10"

            ivBackdrop.contentDescription = movie.title
            //La backdrop del poster muestra el titulo

            ivPoster.contentDescription = movie.title
            //La descripcion del poster muestra el titulo
            val uri = Uri.parse("https://github.com/EmanueLorenzo/Pre-aceleracion-Emanuel-Lorenzo")
            val intent = Intent(Intent.ACTION_VIEW, uri)

            link.apply {
                setOnClickListener {
                    context.startActivity(intent)
                }
            }
            tvLink.paint.isUnderlineText = true
            //El link va hacia el github del autor
            tvGithub.paint.isUnderlineText = true
        }
    }
}