package com.diki.idn.codelabquiz.LikeStuff

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.diki.idn.codelabquiz.R

object BindingAdapter {
    @BindingAdapter("app:popularityIcon")
    @JvmStatic
    fun popularityIcon(imageView: ImageView, popularity: MainObservableViewModel.LikeNumbers) {
        imageView.setImageDrawable(
            getDrawableLikePopularity(
                popularity,
                imageView.context
            )
        )

    }

    private fun getDrawableLikePopularity(
        popularity: MainObservableViewModel.LikeNumbers,
        context: Context
    ): Drawable? {
        return when (popularity) {
            MainObservableViewModel.LikeNumbers.NORMAL -> ContextCompat.getDrawable(
                context,
                R.drawable.like
            )
            MainObservableViewModel.LikeNumbers.STAR -> ContextCompat.getDrawable(
                context,
                R.drawable.like
            )
            MainObservableViewModel.LikeNumbers.POPULAR -> ContextCompat.getDrawable(
                context,
                R.drawable.like
            )
        }
    }
}