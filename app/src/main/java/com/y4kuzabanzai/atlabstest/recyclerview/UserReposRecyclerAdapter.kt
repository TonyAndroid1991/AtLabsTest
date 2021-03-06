package com.y4kuzabanzai.atlabstest.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.y4kuzabanzai.atlabstest.databinding.RepositoriesDetailsBinding
import com.y4kuzabanzai.atlabstest.models.userrepos.UserRepositories
import com.y4kuzabanzai.atlabstest.models.userrepos.UserRepositoriesItem

class UserReposRecyclerAdapter(private val userRepositories: UserRepositories) : RecyclerView.Adapter<UserReposViewholder>() {

    lateinit var detailRepoBinding: RepositoriesDetailsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserReposViewholder {
        detailRepoBinding = RepositoriesDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserReposViewholder(detailRepoBinding)
    }

    override fun onBindViewHolder(holder: UserReposViewholder, position: Int) {

          holder.bindElements(userRepositories[position])
    }

    override fun getItemCount(): Int {
       return userRepositories.size
    }
}

class UserReposViewholder(var viewBinding: RepositoriesDetailsBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindElements(userRepositoryItem: UserRepositoriesItem) {
        viewBinding.nameOfRepository.text = userRepositoryItem.name
    }
}
