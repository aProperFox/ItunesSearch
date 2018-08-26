package com.aproperfox.itunessearch.utils


/**
 * Derived from https://github.com/saulmm/Curved-Fab-Reveal-Example/blob/master/app/src/main/java/saulmm/test/media/PathPoint.java
 */
class PathPoint private constructor(
    val c0X: Float = 0f,
    val c0Y: Float = 0f,
    val c1X: Float = 0f,
    val c1Y: Float = 0f,
    val x: Float = 0f,
    val y: Float = 0f,
    val operation: Operation
) {
  companion object {
    enum class Operation {
      Line,
      Move,
      Curve
    }

    fun lineTo(x: Float, y: Float): PathPoint =
        PathPoint(
            x = x,
            y = y,
            operation = Operation.Line
        )

    fun curveTo(c0X: Float, c0Y: Float, c1X: Float, c1Y: Float, x: Float, y: Float): PathPoint =
        PathPoint(c0X, c0Y, c1X, c1Y, x, y, Operation.Curve)

    fun moveTo(x: Float, y: Float): PathPoint =
        PathPoint(
            x = x,
            y = y,
            operation = Operation.Move
        )
  }
}