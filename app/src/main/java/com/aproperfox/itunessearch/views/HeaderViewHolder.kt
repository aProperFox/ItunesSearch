package com.aproperfox.itunessearch.views

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aproperfox.itunessearch.R
import com.aproperfox.itunessearch.views.models.DisplayData
import com.aproperfox.itunessearch.views.models.ViewHolderMediaData
import kotlinx.android.synthetic.main.view_holder_header.view.*

class HeaderViewHolder(parent: ViewGroup) : BaseViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(R.layout.view_holder_header, parent, false)
) {

  override fun bind(data: ViewHolderMediaData) {
    this.data = data
    val headerData = data.displayData as? DisplayData.Header
        ?: throw IllegalArgumentException("HeaderViewHolder must bind to Header display data")
    itemView.textViewHeader.text = headerData.title
  }

}