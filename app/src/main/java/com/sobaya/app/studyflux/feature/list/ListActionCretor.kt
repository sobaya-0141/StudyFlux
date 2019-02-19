package sobaya.app.studyflux.feature.list

import sobaya.app.studyflux.data.repository.GithubRepository

class ListActionCretor(private val dispatcher: ListDispatcher,
                       private val repository: GithubRepository) {

    suspend fun listRepo(user: String) {
        val response = repository.listRepos(user).await()
        if (response.isSuccessful) {
            dispatcher.dispatch(ListAction.GetRepoList(response.body()))
        } else {
            dispatcher.dispatch(ListAction.ErrorRepoList(response.message()))
        }
    }
}