package liuuu.laurence.fundationprojectmvcandroid.api

import liuuu.laurence.fundationprojectmvcandroid.model.GitHubUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubMethods {

    @GET("users")
    fun getGitHubUser(@Query("since") since: Int): Call<List<GitHubUser>>

}