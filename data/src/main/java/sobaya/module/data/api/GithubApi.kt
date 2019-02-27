package sobaya.module.data.api

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import sobaya.module.data.api.response.Repo

interface GithubApi {
    @GET("/users/{user}/repos")
    fun listRepos(@Path("user") user: String): Deferred<Response<List<Repo>>>
}