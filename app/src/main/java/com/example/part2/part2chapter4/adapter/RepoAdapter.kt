package com.example.part2.part2chapter4.adapter

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.part2.part2chapter4.databinding.ItemRepoBinding
import com.example.part2.part2chapter4.model.Repo

// 복습
class RepoAdapter(private val onClick: (Repo) -> Unit):
    ListAdapter<Repo, RepoAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val viewBinding: ItemRepoBinding):
        RecyclerView.ViewHolder(viewBinding.root){

        fun bind(item: Repo) {
            viewBinding.repoNameTextView.text = item.name
            viewBinding.descriptionTextView.text = item.description
            viewBinding.starCountTextView.text = item.starCount.toString()
            viewBinding.forkCountTextView.text = "${item.forkCount}"

            viewBinding.root.setOnClickListener {
                onClick(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRepoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])

    }

    companion object{
        val diffUtil = object: DiffUtil.ItemCallback<Repo>() {
            override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
                return oldItem == newItem
            }
        }
    }
}