package tw.idv.jew.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
//    var secret = 0
//    var times = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(GuessViewModel::class.java)
//        secret = Random.nextInt(10) + 1
        /*  使用import kotlinx.android.synthetic.main.activity_main.*
            (需在build.gradle(:app)的plugins中加入id 'kotlin-android-extensions')可不用findViewById  */
//        var number = findViewById<EditText>(R.id.number)
//        var counter = findViewById<TextView>(R.id.counter)
//        var message = findViewById<TextView>(R.id.message)
        message.setText("")
        viewModel.message.observe(this, Observer{
            message.setText(it)
        })
        viewModel.times.observe(this, Observer{
            counter.setText(it.toString())
        })
//        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            viewModel.guess(number.text.toString().toInt())
//            val num = number.text.toString().toInt()
//            val text = when(num - secret){
//                0 -> "答對了"
//                in 1..10 -> "小一點"
//                else -> "大一點"
//            }
//            times++
//            counter.setText(times.toString())
//            message.setText(text)
        }
    }
}