package sobaya.app.studyflux.feature.list

import sobaya.app.studyflux.flux.Action

sealed class ListAction<out T>(override val type: String) : Action<T> {

    class GetRepoList(override val data: List<sobaya.module.data.api.response.Repo>?) : ListAction<List<sobaya.module.data.api.response.Repo>>(TYPE) {
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