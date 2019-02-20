package sobaya.app.studyflux.feature.groupie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.ViewHolder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import sobaya.app.common.ext.observe
import sobaya.app.studyflux.R
import sobaya.app.studyflux.feature.groupie.item.ReposAdapter
import sobaya.app.studyflux.feature.list.ListActionCretor
import sobaya.app.studyflux.feature.list.ListStore
import sobaya.app.studyflux.feature.list.item.RepoItem

class GroupieFragment : Fragment() {

    private lateinit var args: GroupieFragmentArgs
    private lateinit var binding: sobaya.app.studyflux.databinding.FragmentGroupieBinding
    val actionCretor by inject<ListActionCretor>()
    val store by inject<ListStore>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_groupie, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        args = GroupieFragmentArgs.fromBundle(arguments?: Bundle())
        val groupAdapter = ReposAdapter()//GroupAdapter<ViewHolder<*>>()
        binding.viewpager.apply {
            adapter = groupAdapter
            layoutMode
        }
        store.repos.observe(this) {
            if (it != null) {
                val repoItem = it.map {
                    RepoItem(it)
                }
                (binding.viewpager.adapter as ReposAdapter).apply {
                    items = repoItem
                    notifyDataSetChanged()
                }
            }
        }
        store.error.observe(this) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

        GlobalScope.launch {
            actionCretor.listRepo("sobaya-0141")
        }
    }

    companion object {
        fun newInstance(args: GroupieFragmentArgs) = GroupieFragment().apply {
            arguments = args.toBundle()
        }
    }
}