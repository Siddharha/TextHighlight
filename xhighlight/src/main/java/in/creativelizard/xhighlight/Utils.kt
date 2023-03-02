package `in`.creativelizard.xhighlight

import android.content.Context
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.view.forEach
import androidx.core.view.forEachIndexed

fun EditText.attachXHighlight(context: Context, vg:ViewGroup,onApplyConfig:((XEditText)->Unit)?=null){
    val edId = this.id
    val xet = XEditText(context)
    vg.forEachIndexed { index, v ->
        if(v.id == edId){

            xet.id = edId
            xet.layoutParams = this.layoutParams

            vg.removeViewAt(index)
            vg.addView(xet,index)
        }

        onApplyConfig?.invoke(xet)

    }

}