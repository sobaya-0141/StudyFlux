package sobaya.app.studyflux.feature.list

import androidx.lifecycle.LiveData
import sobaya.app.common.ext.toLiveData
import sobaya.app.studyflux.flux.Store
import sobaya.app.studyflux.data.api.response.Repo

class ListStore(dispatcher: ListDispatcher) : Store() {

    val repos: LiveData<List<Repo>?>
    val error: LiveData<String>

    init {
        repos = dispatcher.on(ListAction.GetRepoList.TYPE)
            .map { (it as ListAction.GetRepoList).data }
            .toLiveData()
        error = dispatcher.on(ListAction.ErrorRepoList.TYPE)
            .map { (it as ListAction.ErrorRepoList).data }
            .toLiveData()
    }
}