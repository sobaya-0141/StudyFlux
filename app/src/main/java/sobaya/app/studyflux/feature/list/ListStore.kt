package sobaya.app.studyflux.feature.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import sobaya.app.common.ext.toLiveData
import sobaya.app.studyflux.flux.Dispatcher

class ListStore(dispatcher: Dispatcher) : ViewModel() {

    val repos: LiveData<List<sobaya.module.data.api.response.Repo>?>
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