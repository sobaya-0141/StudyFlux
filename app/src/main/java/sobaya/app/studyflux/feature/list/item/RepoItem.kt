package sobaya.app.studyflux.feature.list.item

import androidx.navigation.findNavController
import sobaya.app.studyflux.R
import sobaya.app.studyflux.databinding.ItemRepoBinding
import com.squareup.picasso.Picasso
import com.xwray.groupie.databinding.BindableItem
import sobaya.app.studyflux.data.api.response.Repo
import sobaya.app.studyflux.feature.groupie.GroupieFragmentArgs

class RepoItem(val repo: Repo) : BindableItem<ItemRepoBinding>() {

    override fun getLayout() = R.layout.item_repo

    override fun bind(viewBinding: ItemRepoBinding, position: Int) {
        Picasso.get().load(repo.owner.avatar).into(viewBinding.imageView)
        with (viewBinding) {
            textUserName.text = repo.owner.login
            textRepoName.text = repo.name
            root.setOnClickListener {
                val bundle = GroupieFragmentArgs.Builder().apply {
                    index = position
                }.build().toBundle()
                it.findNavController().navigate(R.id.action_listFragment_to_groupieFragment, bundle)
            }
        }
    }
}