package liuuu.laurence.foundationprojectmvcandroid.api

import liuuu.laurence.foundationprojectmvcandroid.model.GitHubUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubMethods {

    @GET("users")
    fun getGitHubUser(@Query("since") since: Int): Call<List<GitHubUser>>

}