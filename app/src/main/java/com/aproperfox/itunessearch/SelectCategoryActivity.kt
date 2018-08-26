package com.aproperfox.itunessearch

import android.animation.AnimatorSet
import android.content.Context
import android.inputmethodservice.InputMethodService
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewAnimationUtils.createCircularReveal
import android.view.inputmethod.InputMethodManager
import com.aproperfox.itunessearch.adapters.BroadSearchAdapter
import com.aproperfox.itunessearch.api.Api
import com.aproperfox.itunessearch.api.models.MediaType
import com.aproperfox.itunessearch.viewmodels.SelectCategoryActivityViewModel
import com.aproperfox.itunessearch.viewmodels.SelectCategoryViewModel
import com.aproperfox.itunessearch.views.models.PayloadData

import kotlinx.android.synthetic.main.activity_select_category.*


class SelectCategoryActivity : AppCompatActivity() {

  private lateinit var adapter: BroadSearchAdapter

  private val clickListener: (PayloadData) -> Unit = { payloadData ->
    when (payloadData.category) {
      MediaType.Movie -> TODO()
      MediaType.Podcast -> TODO()
      MediaType.Music -> TODO()
      MediaType.MusicVideo -> TODO()
      MediaType.Audiobook -> TODO()
      MediaType.ShortFilm -> TODO()
      MediaType.TvShow -> TODO()
      MediaType.Software -> TODO()
      MediaType.Ebook -> TODO()
      MediaType.All -> TODO()
    }
  }

  lateinit var viewModel: SelectCategoryViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_select_category)
    setSupportActionBar(toolbar)

    viewModel = SelectCategoryActivityViewModel(Api.iTunesSearchManager)

    adapter = BroadSearchAdapter(clickListener)
    recycler.adapter = adapter
    recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    fab.setOnClickListener { _ -> openSearch() }

    searchView.setOnCloseListener {
      true
    }
  }

  private fun openSearch() {
    val revealAnim = createCircularReveal(
        bottomBar,
        bottomBar.width - (fab.width / 2),
        bottomBar.height / 2,
        fab.width / 2f,
        bottomBar.width.toFloat()
    )

    bottomBar.visibility = View.VISIBLE
    revealAnim.duration = resources.getInteger(R.integer.reveal_anim_duration).toLong()
    revealAnim.start()
    searchView.requestFocus()
    val inputService = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputService.showSoftInput(searchView, InputMethodManager.SHOW_IMPLICIT)
  }
}
