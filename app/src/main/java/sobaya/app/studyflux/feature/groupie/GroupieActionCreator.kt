package sobaya.app.studyflux.feature.groupie

import sobaya.app.studyflux.data.repository.GithubRepository
import sobaya.app.studyflux.flux.Dispatcher

class GroupieActionCreator(private val dispatcher: Dispatcher,
                           private val repository: GithubRepository
) {

    suspend fun listRepo(user: String) {
        val response = repository.listRepos(user).await()
        if (response.isSuccessful) {
            dispatcher.dispatch(GroupieAction.GetRepoList(response.body()))
        } else {
            dispatcher.dispatch(GroupieAction.ErrorRepoList(response.message()))
        }
    }
}