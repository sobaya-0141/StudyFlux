package sobaya.app.studyflux.data.repository

import sobaya.app.studyflux.data.api.GithubApi

class GithubRepository(private val api: GithubApi) {

    fun listRepos(user: String) = api.listRepos(user)
}