package liuuu.laurence.foundationprojectmvc

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.TextView


abstract class BaseActivity : AppCompatActivity() {

    private lateinit var mToolbar: Toolbar

    private lateinit var mProgressDialogFragment: ProgressDialogFragment

    override fun setContentView(layoutResID: Int) {
        val layout = layoutInflater.inflate(R.layout.activity_base, null) as RelativeLayout
        mToolbar = layout.findViewById(R.id.toolbar)
        val mainLayout = layout.findViewById(R.id.mainLayout) as FrameLayout

        layoutInflater.inflate(layoutResID, mainLayout, true)
        super.setContentView(layout)
    }

    protected fun setToolbar(title: String) {
        val titleTextView = findViewById<TextView>(R.id.titleTextView) as TextView
        titleTextView.text = title

        mToolbar.title = ""  // Clear original title
        setSupportActionBar(mToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    // Don't have to use this function if import Anko
//    protected fun showToast(msg: String) {
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
//    }

    protected fun showProgress(title: String) {
        mProgressDialogFragment = ProgressDialogFragment.newInstance(title)
        mProgressDialogFragment.show(supportFragmentManager, "ProgressDialog")
    }

    protected fun dismissProgress() {
        mProgressDialogFragment.dismiss()
    }

}