package liuuu.laurence.fundationprojectmvcandroid

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import liuuu.laurence.fundationprojectmvcandroid.utility.Preference
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Init SharedPreference
        Preference.init(this)

        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                startActivity<MainActivity>()
                finish()
            }
        }.start()

    }

}