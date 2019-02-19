package sobaya.app.studyflux.feature.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import sobaya.app.common.ext.observe
import sobaya.app.studyflux.R
import sobaya.app.studyflux.feature.list.item.RepoItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.ViewHolder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class ListFragment: Fragment() {

    private lateinit var binding: sobaya.app.studyflux.databinding.FragmentListBinding
    val actionCretor by inject<ListActionCretor>()
    val store by inject<ListStore>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val groupAdapter = GroupAdapter<ViewHolder<*>>()
        binding.repoList.apply {
            adapter = groupAdapter
            layoutManager = LinearLayoutManager(context)
        }
        store.repos.observe(this) {
            if (it != null) {
                val repoItem = it.map {
                    RepoItem(it)
                }
                (binding.repoList.adapter as GroupAdapter<*>).update(repoItem)
            }
        }
        store.error.observe(this) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

        GlobalScope.launch {
            actionCretor.listRepo("sobaya-0141")
        }
    }
}