package com.aproperfox.itunessearch.utils

import android.animation.TypeEvaluator
import com.aproperfox.itunessearch.utils.PathPoint.Companion.Operation.*

/**
 * Derived from https://github.com/saulmm/Curved-Fab-Reveal-Example/blob/master/app/src/main/java/saulmm/test/media/PathEvaluator.java
 */
object PathEvaluator : TypeEvaluator<PathPoint> {
  override fun evaluate(t: Float, startValue: PathPoint, endValue: PathPoint): PathPoint {
    val x: Float
    val y: Float
    when (endValue.operation) {
      Curve -> {
        val oneMinusT = 1 - t
        x = oneMinusT * oneMinusT * oneMinusT * startValue.x +
            3 * oneMinusT * oneMinusT * t * endValue.c0X +
            3 * oneMinusT * t * t * endValue.c1X +
            t * t * t * endValue.x
        y = oneMinusT * oneMinusT * oneMinusT * startValue.y +
            3 * oneMinusT * oneMinusT * t * endValue.c0Y +
            3 * oneMinusT * t * t * endValue.c1Y +
            t * t * t * endValue.y
      }
      Line -> {
        x = startValue.x + t * (endValue.x - startValue.x)
        y = startValue.y + t * (endValue.y - startValue.y)
      }
      else -> {
        x = endValue.x
        y = endValue.y
      }
    }
    return PathPoint.moveTo(x, y)
  }
}