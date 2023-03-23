package `in`.creativelizard.xhighlight

import android.text.Layout
import android.text.Selection
import android.text.Spannable
import android.text.method.BaseMovementMethod
import android.text.style.ClickableSpan
import android.view.MotionEvent
import android.widget.TextView


object ClickableMovementMethod : BaseMovementMethod() {

    override fun canSelectArbitrarily(): Boolean {
        return false
    }

    override fun onTouchEvent(widget: TextView?, buffer: Spannable, event: MotionEvent): Boolean {

        val action = event.actionMasked
        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_DOWN) {
            var x = event.x
            var y = event.y
            x -= widget!!.totalPaddingLeft
            y -= widget.totalPaddingTop
            x += widget.scrollX
            y += widget.scrollY
            val layout: Layout = widget.layout
            val line = layout.getLineForVertical(y.toInt())
            val off = layout.getOffsetForHorizontal(line, x)
            val link: Array<ClickableSpan> = buffer.getSpans(off, off, ClickableSpan::class.java)
            if (link.isNotEmpty()) {
                if (action == MotionEvent.ACTION_UP) {
                    link[0].onClick(widget)
                } else {
                    Selection.setSelection(
                        buffer, buffer.getSpanStart(link[0]),
                        buffer.getSpanEnd(link[0])
                    )
                }
                return true
            } else {
                Selection.removeSelection(buffer)
            }
        }

        return false
        //return super.onTouchEvent(widget, text, event)
    }
}