package com.kishorejethava.simplemusicplayer.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.jean.jcplayer.JcPlayerManagerListener
import com.example.jean.jcplayer.general.JcStatus
import com.example.jean.jcplayer.model.JcAudio
import com.kishorejethava.simplemusicplayer.R
import com.kishorejethava.simplemusicplayer.databinding.ActivitySongDetailBinding
import com.kishorejethava.simplemusicplayer.model.ResFeed
import com.kishorejethava.simplemusicplayer.utils.Constants.POSITION
import com.kishorejethava.simplemusicplayer.utils.Constants.SONGS
import com.kishorejethava.simplemusicplayer.viewmodel.SongDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SongDetailActivity : AppCompatActivity(), JcPlayerManagerListener {

    private val viewModel: SongDetailViewModel by viewModel()
    private lateinit var binding: ActivitySongDetailBinding
    private var playlist = ArrayList<JcAudio>()
    private lateinit var songList: ArrayList<ResFeed.Feed.Entry>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_song_detail)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        /*Play all song on detail screen itself*/
        songList =
            intent.getParcelableArrayListExtra<ResFeed.Feed.Entry>(SONGS) as ArrayList<ResFeed.Feed.Entry>
        val position = intent.getIntExtra(POSITION, 0)
        viewModel.songDetail.postValue(songList.get(position))

        songList.forEach {
            playlist.add(
                JcAudio.createFromURL(it.imName.label, it.link[1].attributes.href)
            )
        }

        binding.player.initPlaylist(playlist, this)
        binding.player.playAudio(playlist[intent.getIntExtra(POSITION, 0)])
    }

    override fun onStop() {
        super.onStop()
        binding.player.createNotification()
    }

    override fun onPause() {
        super.onPause()
        binding.player.createNotification()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.player.kill()
    }


    override fun onCompletedAudio() {
    }

    override fun onContinueAudio(status: JcStatus) {
    }

    override fun onJcpError(throwable: Throwable) {
    }

    override fun onPaused(status: JcStatus) {
    }

    override fun onPlaying(status: JcStatus) {
    }

    override fun onPreparedAudio(status: JcStatus) {
        playlist.forEachIndexed { index, jcAudio ->
            if (jcAudio == status.jcAudio) {
                viewModel.songDetail.postValue(songList[index])
            }
        }
    }

    override fun onStopped(status: JcStatus) {
    }

    override fun onTimeChanged(status: JcStatus) {
    }
}