package com.aproperfox.itunessearch.views

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aproperfox.itunessearch.R
import com.aproperfox.itunessearch.views.models.ViewHolderMediaData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_holder_album.view.*

class AlbumViewHolder(parent: ViewGroup, private val clickListener: View.OnClickListener? = null) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_album, parent, false)
    ) {

  fun bind(albumData: ViewHolderMediaData.Album) {
    itemView.apply {
      Picasso.get()
          .load(albumData.imageUrl)
          .placeholder(android.R.drawable.ic_menu_gallery)
          .into(imageViewAlbum)
      textViewTitle.text = albumData.title
      textViewArtist.text = albumData.artist
      rootView.setOnClickListener(clickListener)
    }
  }
}