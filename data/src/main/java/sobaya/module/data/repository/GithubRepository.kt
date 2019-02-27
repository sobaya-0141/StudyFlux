package sobaya.module.data.repository

import sobaya.module.data.api.GithubApi

class GithubRepository(private val api: GithubApi) {

    fun listRepos(user: String) = api.listRepos(user)
}