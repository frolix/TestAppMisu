package com.example.misutestapp.utils

import android.graphics.*
import android.graphics.drawable.Drawable
import android.text.TextPaint
import androidx.core.graphics.ColorUtils
import kotlin.properties.Delegates

class TextIconDrawable: Drawable() {
    private var alphas = 255
    private var textPaint = TextPaint().apply {
        textAlign = Paint.Align.CENTER
    }
    var text by Delegates.observable("") { _, _, _ -> invalidateSelf() }
    var textColor by Delegates.observable(Color.BLACK) { _, _, _ -> invalidateSelf() }

    private fun fitText(width: Int) {
        textPaint.textSize = 24f
        val widthAt48 = textPaint.measureText(text)
        textPaint.textSize = 24f / widthAt48 * width.toFloat()
    }

    override fun draw(canvas: Canvas) {
        val width = bounds.width()
        val height = bounds.height()
        fitText(width/2)
        textPaint.color = ColorUtils.setAlphaComponent(textColor, alphas)
        textPaint.textAlign = Paint.Align.CENTER

        canvas.drawText(text, width / 2f, height-65f, textPaint)
    }

    override fun setAlpha(alpha: Int) {
        this.alphas = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        textPaint.colorFilter = colorFilter
    }

    override fun getOpacity(): Int = PixelFormat.TRANSLUCENT

}