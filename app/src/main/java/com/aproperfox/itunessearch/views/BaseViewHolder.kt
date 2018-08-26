package com.aproperfox.itunessearch.views

import android.support.v7.widget.RecyclerView
import android.view.View
import com.aproperfox.itunessearch.views.models.ViewHolderMediaData

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
  lateinit var data: ViewHolderMediaData
  abstract fun bind(data: ViewHolderMediaData)
}