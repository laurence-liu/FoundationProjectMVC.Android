package liuuu.laurence.foundationprojectmvc

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import kotlinx.android.synthetic.main.dialog_progress.view.*

class ProgressDialogFragment: DialogFragment() {
    private lateinit var mTitle: String

    companion object {
        private const val ARG_TITLE = "TITLE"

        fun newInstance(title: String): ProgressDialogFragment {
            val progressDialogFragment = ProgressDialogFragment()
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            progressDialogFragment.arguments = args
            return progressDialogFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            mTitle = arguments?.getString(ARG_TITLE)!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val rootView = inflater.inflate(R.layout.dialog_progress, container, false)

        rootView.titleTextView.text = mTitle

        return rootView
    }

//    override fun onStart() {
//        super.onStart()
//
//        try {
//            val window = dialog.window
//            val windowParams = window!!.attributes
//            windowParams.dimAmount = 0.0f
//
//            window.attributes = windowParams
//        } catch (e: NullPointerException) {
//            e.printStackTrace()
//        }
//    }
}