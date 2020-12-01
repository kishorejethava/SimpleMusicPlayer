package com.kishorejethava.simplemusicplayer.viewmodel

import android.app.Application
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kishorejethava.simplemusicplayer.model.ResFeed

class SongDetailViewModel(application: Application) : AndroidViewModel(application) {
    var songDetail = MutableLiveData<ResFeed.Feed.Entry>()

    companion object{
        @BindingAdapter("bind:imageUrl")
        @JvmStatic
        fun setRemoteURL(view: AppCompatImageView, imageUrl: String?) {
            if (imageUrl != null && imageUrl.isNotEmpty()) {
                Glide.with(view.context)
                    .load(imageUrl)
                    .apply(
                        RequestOptions()
                            .fitCenter())
                    .into(view)
            }
        }
    }
}
