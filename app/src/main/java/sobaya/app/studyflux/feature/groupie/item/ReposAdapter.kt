package sobaya.app.studyflux.feature.groupie.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import sobaya.app.studyflux.R
import sobaya.app.studyflux.data.api.response.Repo
import sobaya.app.studyflux.databinding.ItemGroupieBinding
import sobaya.app.studyflux.feature.list.item.RepoItem

class ReposAdapter(var items: List<RepoItem>? = null): RecyclerView.Adapter<ReposAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = DataBindingUtil.inflate<ItemGroupieBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_groupie, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items?.size?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items?.get(position)
        holder.binding.textUser.text = "aaa"
    }

    inner class ViewHolder(val binding: ItemGroupieBinding): RecyclerView.ViewHolder(binding.root)
}