package com.aproperfox.itunessearch.utils

import android.graphics.*
import com.squareup.picasso.Transformation

/**
 * Picasso transformation to crop an image to a circular shape
 *
 * credit: https://stackoverflow.com/a/26112408/1094605
 */

object CircleTransform : Transformation {
  override fun key(): String = "circle"

  override fun transform(source: Bitmap): Bitmap {
    val size = Math.min(source.width, source.height)

    val x = (source.width - size) / 2
    val y = (source.height - size) / 2

    val squaredBitmap = Bitmap.createBitmap(source, x, y, size, size)
    if (squaredBitmap != source) {
      source.recycle()
    }

    val bitmap = Bitmap.createBitmap(size, size, source.config)

    val canvas = Canvas(bitmap)
    val paint = Paint()
    val shader = BitmapShader(squaredBitmap,
        Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
    paint.shader = shader
    paint.isAntiAlias = true

    val r = size / 2f
    canvas.drawCircle(r, r, r, paint)

    squaredBitmap.recycle()
    return bitmap
  }
}