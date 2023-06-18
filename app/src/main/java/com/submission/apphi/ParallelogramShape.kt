package com.submission.apphi

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class ParallelogramShape(private val angle: Float, private val translationX: Float) : Shape {
    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        val topLeft = Offset(translationX, 0f)
        val topRight = Offset(size.width + translationX, 0f)
        val bottomLeft = Offset(size.width * angle + translationX, size.height)
        val bottomRight = Offset(size.width * angle + size.width + translationX, size.height)

        return Outline.Generic(
            Path().apply {
                moveTo(topLeft.x, topLeft.y)
                lineTo(topRight.x, topRight.y)
                lineTo(bottomRight.x, bottomRight.y)
                lineTo(bottomLeft.x, bottomLeft.y)
                close()
            }
        )
    }

    override fun toString(): String = "TranslatedParallelogramShape(angle=$angle, translationX=$translationX)"
}