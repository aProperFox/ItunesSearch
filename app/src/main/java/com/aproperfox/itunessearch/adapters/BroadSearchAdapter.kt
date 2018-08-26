package com.aproperfox.itunessearch.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.aproperfox.itunessearch.adapters.BroadSearchAdapter.ViewType.*
import com.aproperfox.itunessearch.views.AlbumViewHolder
import com.aproperfox.itunessearch.views.models.ViewHolderMediaData

class BroadSearchAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  enum class ViewType {
    Header,
    Album,
    Artist,
    Song
  }

  lateinit var items: List<ViewHolderMediaData>

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
      when (values()[viewType]) {
        Header -> TODO()
        Album -> AlbumViewHolder(parent = parent)
        Artist -> TODO()
        Song -> TODO()
      }

  override fun getItemCount(): Int = items.size

  override fun getItemViewType(position: Int): Int =
      when (items[position]) {
        is ViewHolderMediaData.Album -> Album.ordinal
        is ViewHolderMediaData.Artist -> Artist.ordinal
        is ViewHolderMediaData.Header -> Header.ordinal
        is ViewHolderMediaData.Song -> Song.ordinal
      }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    when (holder) {
      is AlbumViewHolder -> holder.bind(items[position] as ViewHolderMediaData.Album)
    }
  }
}