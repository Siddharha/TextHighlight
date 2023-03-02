package `in`.creativelizard.texthighlight

import `in`.creativelizard.xhighlight.User
import `in`.creativelizard.xhighlight.XAutoCompleteEditText
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import androidx.core.text.toSpannable

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        findViewById<XAutoCompleteEditText>(R.id.etAutoText).apply {

            userList = listOf( User(id = 0, name = "sid"),  User(id = 1, name = "rro"))
           // val s = text.toSpannable()
            val ss = SpannableString("this is @test and @sid ddd")
            append(ss)


           // setUserTagColor(Color.MAGENTA)
        }
    }
}