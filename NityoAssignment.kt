package com.example.myapplication

data class Rectangle(
    val x: Float,
    val y: Float,
    val width: Float,
    val height: Float
)

object NityoAssignment {
    fun isRectanglesCollided(rectangles: List<Rectangle>) : Boolean =
         isCollidedHorizontally(rectangles) || isCollidedVertically(rectangles)

    private fun isCollidedVertically(rect: List<Rectangle>) : Boolean {
        val sortedRect = rect.sortedBy { rectangle -> rectangle.y +rectangle.height }
        var isCollided = false

        if (sortedRect.size > 1) {
            for (i in 0 until sortedRect.size - 1) {
                val rectX2 = sortedRect[i].y + sortedRect[i].height
                val nextIdx = i + 1

                isCollided = isCollidedAxis(
                    rectX2,
                    sortedRect[nextIdx].y,
                    sortedRect[nextIdx].height
                )
            }
        }

        return isCollided
    }

    private fun isCollidedHorizontally(rect: List<Rectangle>) : Boolean {
        val sortedRect = rect.sortedBy { rectangle -> rectangle.x +rectangle.width }
        var isCollided = false

        if (sortedRect.size > 1) {
            for (i in 0 until sortedRect.size - 1) {
                val rectX2 = sortedRect[i].x + sortedRect[i].width
                val nextIdx = i + 1

                isCollided = isCollidedAxis(
                    rectX2,
                    sortedRect[nextIdx].x,
                    sortedRect[nextIdx].width
                )
            }
        }

        return isCollided
    }

    private fun isCollidedAxis(start: Float, otherPoint: Float, otherWidth: Float) : Boolean =
        start >= otherPoint && start <= otherPoint + otherWidth
}
