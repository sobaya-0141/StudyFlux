package sobaya.app.studyflux.feature.list

import sobaya.app.studyflux.flux.Action
import sobaya.app.studyflux.data.api.response.Repo

sealed class ListAction<out T>(override val type: String) : Action<T> {

    class GetRepoList(override val data: List<Repo>?) : ListAction<List<Repo>>(TYPE) {
        companion object {
            const val TYPE = "ListAction.GetRepoList"
        }
    }
    class ErrorRepoList(override val data: String) : ListAction<String>(TYPE) {
        companion object {
            const val TYPE = "ListAction.ErrorRepoList"
        }
    }
}