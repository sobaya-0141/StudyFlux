package sobaya.app.studyflux.feature.groupie.item

import com.squareup.picasso.Picasso
import com.xwray.groupie.databinding.BindableItem
import sobaya.app.studyflux.R
import sobaya.app.studyflux.data.api.response.Repo
import sobaya.app.studyflux.databinding.ItemRepoBinding

class GroupieItem(val repo: Repo) : BindableItem<ItemRepoBinding>() {

    override fun getLayout() = R.layout.item_groupie

    override fun bind(viewBinding: ItemRepoBinding, position: Int) {
        Picasso.get().load(repo.owner.avatar).into(viewBinding.imageView)
        with (viewBinding) {
            textUserName.text = repo.owner.login
            textRepoName.text = repo.name
        }
    }
}