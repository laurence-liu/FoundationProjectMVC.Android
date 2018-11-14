package liuuu.laurence.foundationprojectmvc.api

import liuuu.laurence.foundationprojectmvc.model.GitHubUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubMethods {

    @GET("users")
    fun getGitHubUser(@Query("since") since: Int): Call<List<GitHubUser>>

}