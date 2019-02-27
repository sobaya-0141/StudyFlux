package sobaya.app.studyflux.feature.list

import sobaya.app.studyflux.flux.Dispatcher
import sobaya.module.data.repository.GithubRepository

class ListActionCretor(private val dispatcher: Dispatcher,
                       private val repository: GithubRepository
) {

    suspend fun listRepo(user: String) {
        val response = repository.listRepos(user).await()
        if (response.isSuccessful) {
            dispatcher.dispatch(ListAction.GetRepoList(response.body()))
        } else {
            dispatcher.dispatch(ListAction.ErrorRepoList(response.message()))
        }
    }
}