package com.kishorejethava.simplemusicplayer.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kishorejethava.simplemusicplayer.R
import com.kishorejethava.simplemusicplayer.adapter.SongsAdapter
import com.kishorejethava.simplemusicplayer.databinding.ActivitySongListBinding
import com.kishorejethava.simplemusicplayer.model.ResFeed
import com.kishorejethava.simplemusicplayer.utils.Constants.POSITION
import com.kishorejethava.simplemusicplayer.utils.Constants.SONGS
import com.kishorejethava.simplemusicplayer.utils.ToastUtils
import com.kishorejethava.simplemusicplayer.viewmodel.SongListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SongListActivity : AppCompatActivity() {
    private val viewModel : SongListViewModel by viewModel()
    private lateinit var mActivityBinding : ActivitySongListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_song_list)
        mActivityBinding.viewModel = viewModel
        mActivityBinding.lifecycleOwner = this
        mActivityBinding.rvSongList.layoutManager = LinearLayoutManager(this)

        viewModel.feedResponse.observe(this, observerFeedResponse())
        viewModel.errorResponse.observe(this, Observer {
           ToastUtils.shortToast(context = this, stringText = it)
        })
    }

    /**
     * feed response
     */
    private fun observerFeedResponse(): Observer<ResFeed> {
        return Observer { response ->
            mActivityBinding.rvSongList.adapter = SongsAdapter(response.feed.entries) { position ->
                val intent = Intent(this, SongDetailActivity::class.java)
                intent.putExtra(SONGS, response.feed.entries)
                intent.putExtra(POSITION, position)
                startActivity(intent)
            }
        }
    }
}