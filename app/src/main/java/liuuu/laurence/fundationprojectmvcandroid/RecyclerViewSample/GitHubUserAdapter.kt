package liuuu.laurence.fundationprojectmvcandroid.RecyclerViewSample

import android.content.Context
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import liuuu.laurence.fundationprojectmvcandroid.model.GitHubUser
import com.squareup.picasso.Picasso
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import liuuu.laurence.fundationprojectmvcandroid.R
import liuuu.laurence.fundationprojectmvcandroid.utility.OnItemClickListener

class GitHubUserAdapter(private val mContext: Context, private val mGitHubUserList: List<GitHubUser>) : RecyclerView.Adapter<GitHubUserAdapter.GitHubViewHolder>() {

    private var mOnItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GitHubViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_github_user, viewGroup, false)

        return GitHubViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GitHubViewHolder, position: Int) {
        val gitHubUser = getItem(position)

        holder.nameTextView.text = gitHubUser.login
        holder.typeTextView.text = gitHubUser.type
        Picasso.get().load(gitHubUser.avatarUrl).placeholder(R.mipmap.ic_launcher).into(holder.avatarImageView)

        holder.itemView.setOnClickListener {
            mOnItemClickListener!!.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return mGitHubUserList.size
    }

    fun getItem(position: Int): GitHubUser {
        return mGitHubUserList[position]
    }

    class GitHubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView: TextView
        val typeTextView: TextView
        val avatarImageView: ImageView

        init {
            nameTextView = itemView.findViewById(R.id.nameTextView)
            typeTextView = itemView.findViewById(R.id.typeTextView)
            avatarImageView = itemView.findViewById(R.id.avatarImageView)
        }
    }

}