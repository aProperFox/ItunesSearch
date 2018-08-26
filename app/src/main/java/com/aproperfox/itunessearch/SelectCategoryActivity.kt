package com.aproperfox.itunessearch

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.content.Context
import android.content.Intent
import android.inputmethodservice.InputMethodService
import android.net.Uri
import android.os.Bundle
import android.provider.Browser
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.View
import android.view.ViewAnimationUtils.createCircularReveal
import android.view.inputmethod.InputMethodManager
import com.aproperfox.itunessearch.adapters.BroadSearchAdapter
import com.aproperfox.itunessearch.api.Api
import com.aproperfox.itunessearch.api.models.MediaType
import com.aproperfox.itunessearch.viewmodels.SelectCategoryActivityViewModel
import com.aproperfox.itunessearch.viewmodels.SelectCategoryViewModel
import com.aproperfox.itunessearch.viewmodels.viewstate.SelectCategoryViewState
import com.aproperfox.itunessearch.views.models.PayloadData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_select_category.*


class SelectCategoryActivity : AppCompatActivity() {

  private lateinit var adapter: BroadSearchAdapter

  private val clickListener: (PayloadData) -> Unit = { payloadData ->
    intent = Intent(Intent.ACTION_VIEW, Uri.parse(payloadData.viewUrl))
    startActivity(intent)
  }

  lateinit var viewModel: SelectCategoryViewModel

  lateinit var anim: Animator

  private var disposable = Disposables.disposed()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_select_category)
    setSupportActionBar(toolbar)

    viewModel = SelectCategoryActivityViewModel(Api.iTunesSearchManager)

    adapter = BroadSearchAdapter(clickListener)
    recycler.adapter = adapter
    recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    fab.setOnClickListener { _ -> openSearch() }

    initViews()
  }

  override fun onResume() {
    super.onResume()
    disposable = viewModel.stateChanges
        .distinctUntilChanged()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ state ->
          when (state) {
            is SelectCategoryViewState.Content -> adapter.items = state.items
            SelectCategoryViewState.Loading -> TODO()
            SelectCategoryViewState.Empty -> adapter.items = emptyList()
            is SelectCategoryViewState.Error -> Snackbar.make(window.decorView, "Error:\n${state.error}", Snackbar.LENGTH_SHORT)
          }
        }, {
          it.printStackTrace()
        })
  }

  override fun onPause() {
    super.onPause()
    disposable.dispose()
  }

  private fun initViews() {
    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(query: String?): Boolean {
        fab.visibility = View.VISIBLE
        bottomBar.visibility = View.INVISIBLE
        if (query != null)
          viewModel.search(query)
        return true
      }

      override fun onQueryTextChange(newText: String?): Boolean {
        return if (newText == null) {
          false
        } else {
          viewModel.search(newText)
          true
        }
      }
    })
  }

  private fun openSearch() {
    anim = createCircularReveal(
        bottomBar,
        bottomBar.width - (fab.width / 2),
        bottomBar.height / 2,
        fab.width / 2f,
        bottomBar.width.toFloat()
    )

    bottomBar.visibility = View.VISIBLE
    anim.duration = resources.getInteger(R.integer.reveal_anim_duration).toLong()
    anim.start()
    searchView.requestFocus()
    anim.addListener(object : Animator.AnimatorListener {
      override fun onAnimationRepeat(animation: Animator?) {
      }

      override fun onAnimationEnd(animation: Animator?) {
        val inputService = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputService.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        fab.visibility = View.INVISIBLE
      }

      override fun onAnimationCancel(animation: Animator?) {
      }

      override fun onAnimationStart(animation: Animator?) {
      }

    })
  }
}
