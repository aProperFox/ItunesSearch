package com.aproperfox.itunessearch

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.animation.FastOutLinearInInterpolator
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewAnimationUtils.createCircularReveal
import com.aproperfox.itunessearch.adapters.BroadSearchAdapter
import com.aproperfox.itunessearch.api.models.MediaType
import com.aproperfox.itunessearch.utils.AnimatorPath
import com.aproperfox.itunessearch.utils.PathEvaluator
import com.aproperfox.itunessearch.views.models.PayloadData

import kotlinx.android.synthetic.main.activity_select_category.*

class SelectCategoryActivity : AppCompatActivity() {

  private lateinit var adapter: BroadSearchAdapter

  private val fabMargin = resources.getDimensionPixelSize(R.dimen.margin_mid)

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

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_select_category)
    setSupportActionBar(toolbar)

    adapter = BroadSearchAdapter(clickListener)
    recycler.adapter = adapter
    recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    fab.setOnClickListener { _ -> openSearch() }
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.menu_select_category, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    return when (item.itemId) {
      R.id.action_settings -> true
      else -> super.onOptionsItemSelected(item)
    }
  }

  private fun openSearch() {
    val curvedAnim = createCurvedAnim(fab, bottomBar)
    val revealAnim = createCircularReveal(
        bottomBar,
        (fab.x + fab.width / 2).toInt(),
        (fab.y + (fab.height / 2)).toInt(),
        (fab.width / 2).toFloat(),
        bottomBar.width.toFloat()
    )

    AnimatorSet().apply {
      playTogether(curvedAnim, revealAnim)
    }.start()
  }

  private fun createCurvedAnim(fabView: View, bottomNav: BottomNavigationView): Animator {
    val fabDestX = (fabView.width / 2f) - (bottomNav.width / 3)

    val path = AnimatorPath().apply {
      moveTo(0f, 0f)
      curveTo(0f, fabMargin.toFloat(), fabDestX / 2f, fabMargin.toFloat(), fabDestX, fabMargin.toFloat())
    }
    return ObjectAnimator.ofObject(this, "fabLoc", PathEvaluator, path.points).apply {
      interpolator = FastOutLinearInInterpolator()
      duration = resources.getInteger(R.integer.reveal_anim_duration).toLong()
    }
  }
}
