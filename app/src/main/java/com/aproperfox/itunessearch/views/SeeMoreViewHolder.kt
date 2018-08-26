package com.aproperfox.itunessearch.views

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aproperfox.itunessearch.R
import com.aproperfox.itunessearch.views.models.DisplayData
import com.aproperfox.itunessearch.views.models.PayloadData
import com.aproperfox.itunessearch.views.models.ViewHolderMediaData
import kotlinx.android.synthetic.main.view_holder_see_more.view.*

class SeeMoreViewHolder(parent: ViewGroup, private val clickListener: (PayloadData) -> Unit) :
    BaseViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_see_more, parent, false)
    ) {

  init {
    itemView.setOnClickListener { clickListener(data.payloadData) }
  }

  override fun bind(data: ViewHolderMediaData) {
    this.data = data
    val seeMoreData = data.displayData as? DisplayData.SeeMore
        ?: throw IllegalArgumentException("SeeMoreViewHolder must bind to SeeMore display data")
    itemView.textViewSeeMore.text = seeMoreData.category
  }
}