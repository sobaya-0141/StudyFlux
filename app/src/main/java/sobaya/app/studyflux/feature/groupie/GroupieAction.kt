package sobaya.app.studyflux.feature.groupie

import sobaya.app.studyflux.flux.Action

sealed class GroupieAction<out T>(override val type: String) : Action<T> {

    class GetRepoList(override val data: List<sobaya.module.data.api.response.Repo>?) : GroupieAction<List<sobaya.module.data.api.response.Repo>>(TYPE) {
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