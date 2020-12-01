package com.kishorejethava.simplemusicplayer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kishorejethava.simplemusicplayer.R
import com.kishorejethava.simplemusicplayer.model.ResFeed

class SongsAdapter(private var entries: List<ResFeed.Feed.Entry>, var onResult: (position: Int) -> Unit) : RecyclerView.Adapter<SongsAdapter.ViewHolder>() {

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view.rootView) {
        val ivAlbum: AppCompatImageView = view.findViewById(R.id.ivAlbum)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_song, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return entries.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = entries[position].imName.label
        Glide.with(holder.itemView.context)
            .load(entries[position].imImage[0].label)
            .apply(
                RequestOptions()
                .fitCenter())
            .into(holder.ivAlbum)
        holder.itemView.setOnClickListener {
            onResult(position)
        }
    }
}