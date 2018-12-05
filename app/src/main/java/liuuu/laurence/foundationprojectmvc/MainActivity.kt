package liuuu.laurence.foundationprojectmvc

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import liuuu.laurence.foundationprojectmvc.RecyclerViewSample.RecyclerViewActivity
import org.jetbrains.anko.*
import java.util.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        processController()
    }

    private fun initView() {
        // Home page dismiss back button
        setToolbar("Homeeeeeee")
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    private fun processController() {
        recyclerViewSampleButton.setOnClickListener {
            // Anko intent
            val randomUser = Random().nextInt(1000)
            startActivity<RecyclerViewActivity>("randomUser" to randomUser)
        }

        toastButton.setOnClickListener {
            // Anko toast
            toast("This is a toast")
        }

        alertButton.setOnClickListener {
            // Anko Alert
            alert("Hi, I'm title", "This is Anko alert exmaple.") {
                yesButton { toast("Yooooo…") }
                noButton {}
            }.show()
        }

        progressButton.setOnClickListener {
            showProgress("I AM TITLE!!!")
        }
    }

}
