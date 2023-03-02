package `in`.creativelizard.texthighlight

import `in`.creativelizard.xhighlight.User
import `in`.creativelizard.xhighlight.XAutoCompleteEditText
import `in`.creativelizard.xhighlight.XEditText
import `in`.creativelizard.xhighlight.XTextView
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<XTextView>(R.id.tvText).apply {
            //userList = listOf( User(id = 0, name = "sid"),  User(id = 1, name = "rro"))
            text = "sdfdf #ffg.ff dgdsfg. http://www.google.com askjsakdf @sid and @rro and @ddf"
            setUserTagColor(Color.GREEN)

           // setTagColor(Color.RED)
            setOnHashTagClickListener = {
                Log.e("sss","clicked a hash tag")
            }
            setOnUserTagClickListener = {userName,id->
                Log.e("sss","clicked a user tag with id - $id")
            }
            setOnLinkTagClickListener = {
                Log.e("sss","clicked a link")
            }
    }

        findViewById<XEditText>(R.id.etText).apply {

            userList = listOf( User(id = 0, name = "sid"),  User(id = 1, name = "rro"))
            //setUserTagColor(Color.BLUE)
        }



        findViewById<Button>(R.id.btnNext).apply {
            setOnClickListener {
                //Toast.makeText(this@MainActivity, "click", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@MainActivity,MainActivity2::class.java))
            }

        }
    }
}