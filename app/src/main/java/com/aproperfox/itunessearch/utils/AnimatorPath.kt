package com.aproperfox.itunessearch.utils

import java.util.ArrayList

/**
 * Derived from https://github.com/saulmm/Curved-Fab-Reveal-Example/blob/master/app/src/main/java/saulmm/test/media/AnimatorPath.java
 */
class AnimatorPath {

  // The points in the path
  private var internalPoints = ArrayList<PathPoint>()

  val points: Collection<PathPoint>
    get() = internalPoints

  fun moveTo(x: Float, y: Float) {
    internalPoints.add(PathPoint.moveTo(x, y))
  }

  fun lineTo(x: Float, y: Float) {
    internalPoints.add(PathPoint.lineTo(x, y))
  }

  fun curveTo(c0X: Float, c0Y: Float, c1X: Float, c1Y: Float, x: Float, y: Float) {
    internalPoints.add(PathPoint.curveTo(c0X, c0Y, c1X, c1Y, x, y))
  }
}