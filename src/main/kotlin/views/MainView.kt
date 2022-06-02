package views

import org.jetbrains.skia.Canvas
import org.jetbrains.skia.Color
import org.jetbrains.skia.Paint
import org.jetbrains.skiko.SkikoView
import org.jetbrains.skiko.currentNanoTime

const val TIME_SCALE = 1E9

class MainView(width: Float, height: Float): SkikoView {
    private var lastTime = currentNanoTime()
    private var lastVelocity = 0.0
    private val acceleration = 500

    private var x: Double = width.toDouble() / 2
    private var y: Double = 30.0

    private val paint = Paint().apply {
        color = Color.RED
    }

    override fun onRender(canvas: Canvas, width: Int, height: Int, nanoTime: Long) {
        val dt = (nanoTime - lastTime) / TIME_SCALE
        val velocity = lastVelocity + acceleration * dt
        val dy = velocity * dt
        y += dy

        canvas.clear(Color.CYAN)
        canvas.drawCircle(x.toFloat(), y.toFloat(), 20f, paint)

        lastVelocity = velocity
        lastTime = nanoTime
    }
}
