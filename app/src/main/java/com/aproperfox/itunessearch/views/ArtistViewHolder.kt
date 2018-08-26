package com.aproperfox.itunessearch.views

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aproperfox.itunessearch.R
import com.aproperfox.itunessearch.utils.CircleTransform
import com.aproperfox.itunessearch.views.models.DisplayData
import com.aproperfox.itunessearch.views.models.PayloadData
import com.aproperfox.itunessearch.views.models.ViewHolderMediaData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_holder_artist.view.*

class ArtistViewHolder(parent: ViewGroup, private val clickListener: (PayloadData) -> Unit) :
    BaseViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_artist, parent, false)
    ) {

  init {
    itemView.setOnClickListener { clickListener(data.payloadData) }
  }

  override fun bind(data: ViewHolderMediaData) {
    this.data = data
    val artistData = data.displayData as? DisplayData.Artist
        ?: throw IllegalArgumentException("ArtistViewHolder must bind to Artist display data")
    itemView.apply {
      textViewArtist.text = artistData.name
      Picasso.get()
          .load(artistData.imageUrl)
          .placeholder(R.drawable.ic_account_circle_black_24dp)
          .error(R.drawable.ic_account_circle_black_24dp)
          .transform(CircleTransform)
          .into(imageViewArtist)
    }
  }

}