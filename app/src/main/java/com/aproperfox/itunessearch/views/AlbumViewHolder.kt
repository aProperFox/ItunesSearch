package com.aproperfox.itunessearch.views

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aproperfox.itunessearch.R
import com.aproperfox.itunessearch.views.models.DisplayData
import com.aproperfox.itunessearch.views.models.PayloadData
import com.aproperfox.itunessearch.views.models.ViewHolderMediaData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_holder_album.view.*

class AlbumViewHolder(parent: ViewGroup, private val clickListener: (PayloadData) -> Unit) :
    BaseViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_album, parent, false)
    ) {

  init {
    itemView.apply {
      isClickable = true
      isFocusable = true
      setBackgroundResource(android.R.drawable.list_selector_background)
      setOnClickListener { clickListener(data.payloadData) }
    }
  }

  override fun bind(data: ViewHolderMediaData) {
    this.data = data
    val albumData = data.displayData as? DisplayData.Album
        ?: throw IllegalArgumentException("AlbumViewHolder must bind to Album display data")
    itemView.apply {
      Picasso.get()
          .load(albumData.imageUrl)
          .placeholder(android.R.drawable.ic_menu_gallery)
          .into(imageViewAlbum)
      textViewTitle.text = albumData.title
      textViewArtist.text = albumData.artist
    }
  }
}