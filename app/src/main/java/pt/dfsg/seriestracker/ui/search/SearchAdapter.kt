package pt.dfsg.seriestracker.ui.search

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*
import pt.dfsg.seriestracker.R
import pt.dfsg.seriestracker.data.model.Search
import pt.dfsg.seriestracker.data.model.Show


class SearchAdapter(private var clickCallBack: SearchAdapter.ClickCallBack) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private var search: List<Search> = listOf()

    fun setData(search: List<Search>) {
        this.search = search
        notifyDataSetChanged()
    }

    override fun getItemCount() = search.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val show = search[position].show as Show

        holder.itemView.textView.text =
                "${show.name} \n" +
                "${show.status} \n" +
                "${show.premiered} \n" +
                "${show.network?.name ?: show.webChannel?.name}"

        holder.itemView.setOnClickListener { clickCallBack.onItemClick(show) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface ClickCallBack {
        fun onItemClick(show: Show)
    }

}