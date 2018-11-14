package liuuu.laurence.foundationprojectmvc.RecyclerViewSample

import android.os.Bundle
import android.view.MenuItem
import android.view.View.GONE
import kotlinx.android.synthetic.main.activity_recycler.*
import liuuu.laurence.foundationprojectmvc.BaseActivity
import liuuu.laurence.foundationprojectmvc.R
import liuuu.laurence.foundationprojectmvc.api.RetrofitClient
import liuuu.laurence.foundationprojectmvc.model.GitHubUser
import liuuu.laurence.foundationprojectmvc.utility.OnItemClickListener
import liuuu.laurence.foundationprojectmvc.utility.SetUpLayoutManager
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerViewActivity : BaseActivity() {

    private var mSince: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        mSince = intent.extras?.getInt("randomUser")

        initView()
        processController()
    }

    private fun initView() {
        setToolbar("Simple Retrofit")

        SetUpLayoutManager.verticalLinearLayout(this, recyclerView)
    }

    private fun processController() {
        val userCall = RetrofitClient.gitHubMethods().getGitHubUser(mSince!!)
        userCall.enqueue(object : Callback<List<GitHubUser>> {
            override fun onResponse(call: Call<List<GitHubUser>>, response: Response<List<GitHubUser>>) {
                val gitHubUserList = response.body()!!

                val gitHubUserAdapter = GitHubUserAdapter(applicationContext, gitHubUserList)
                recyclerView.adapter = gitHubUserAdapter
                gitHubUserAdapter.setOnItemClickListener(object : OnItemClickListener {
                    override fun onItemClick(position: Int) {
                        toast("You already clicked on " + gitHubUserList[position].login)
                    }
                })

                progressBar.visibility = GONE
            }

            override fun onFailure(call: Call<List<GitHubUser>>, t: Throwable) {
                toast(t.toString())
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}