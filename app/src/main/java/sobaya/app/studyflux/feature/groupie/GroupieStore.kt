package sobaya.app.studyflux.feature.groupie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import sobaya.app.common.ext.toLiveData
import sobaya.app.studyflux.data.api.response.Repo
import sobaya.app.studyflux.feature.list.ListAction
import sobaya.app.studyflux.flux.Dispatcher

class GroupieStore(dispatcher: Dispatcher) : ViewModel() {

    val repos: LiveData<List<Repo>?>
    val error: LiveData<String>

    init {
        repos = dispatcher.on(GroupieAction.GetRepoList.TYPE)
            .map { (it as ListAction.GetRepoList).data }
            .toLiveData()
        error = dispatcher.on(GroupieAction.ErrorRepoList.TYPE)
            .map { (it as ListAction.ErrorRepoList).data }
            .toLiveData()
    }
}