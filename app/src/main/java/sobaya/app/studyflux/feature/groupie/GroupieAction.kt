package sobaya.app.studyflux.feature.groupie

import sobaya.app.studyflux.data.api.response.Repo
import sobaya.app.studyflux.flux.Action

sealed class GroupieAction<out T>(override val type: String) : Action<T> {

    class GetRepoList(override val data: List<Repo>?) : GroupieAction<List<Repo>>(TYPE) {
        companion object {
            const val TYPE = "GroupieAction.GetRepoList"
        }
    }
    class ErrorRepoList(override val data: String) : GroupieAction<String>(TYPE) {
        companion object {
            const val TYPE = "GroupieAction.ErrorRepoList"
        }
    }
}