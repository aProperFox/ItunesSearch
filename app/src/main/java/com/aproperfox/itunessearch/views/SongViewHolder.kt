package com.aproperfox.itunessearch.views

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aproperfox.itunessearch.R
import com.aproperfox.itunessearch.views.models.DisplayData
import com.aproperfox.itunessearch.views.models.PayloadData
import com.aproperfox.itunessearch.views.models.ViewHolderMediaData
import kotlinx.android.synthetic.main.view_holder_song.view.*

class SongViewHolder(parent: ViewGroup, private val clickListener: (PayloadData) -> Unit) :
    BaseViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_song, parent, false)
    ) {

  init {
    itemView.setOnClickListener { clickListener(data.payloadData) }
  }

  override fun bind(data: ViewHolderMediaData) {
    this.data = data
    val songData = data.displayData as? DisplayData.Song
        ?: throw IllegalArgumentException("SongViewHolder must bind to Song display data")
    itemView.apply {
      textViewSongTitle.text = songData.title
      textViewArtistAlbum.text = songData.album?.let {
        context.getString(R.string.artist_album_joint_text, songData.artist, it)
      } ?: songData.artist
    }
  }
}