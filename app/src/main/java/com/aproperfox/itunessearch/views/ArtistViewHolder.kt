package com.aproperfox.itunessearch.views

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aproperfox.itunessearch.R
import com.aproperfox.itunessearch.utils.CircleTransform
import com.aproperfox.itunessearch.views.models.ViewHolderMediaData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_holder_artist.view.*

class ArtistViewHolder(parent: ViewGroup, private val clickListener: View.OnClickListener) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(R.layout.view_holder_artist, parent, false)
) {

  fun bind(data: ViewHolderMediaData.Artist) {
    Picasso.get()
        .load(data.imageUrl)
        .placeholder(R.drawable.ic_account_circle_black_24dp)
        .error(R.drawable.ic_account_circle_black_24dp)
        .transform(CircleTransform)
        .into(itemView.imageViewArtist)
    itemView.textViewArtist.text = data.name
  }

}