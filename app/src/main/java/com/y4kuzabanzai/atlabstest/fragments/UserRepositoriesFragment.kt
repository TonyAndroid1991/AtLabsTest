package com.y4kuzabanzai.atlabstest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.y4kuzabanzai.atlabstest.R
import com.y4kuzabanzai.atlabstest.fragments.UserRepositoriesFragmentArgs
import com.y4kuzabanzai.atlabstest.databinding.FragmentUserRepositoriesBinding
import com.y4kuzabanzai.atlabstest.models.userrepos.UserRepositories
import com.y4kuzabanzai.atlabstest.recyclerview.UserReposRecyclerAdapter

class UserRepositoriesFragment : Fragment() {

    lateinit var binding: FragmentUserRepositoriesBinding
    private val args by navArgs<UserRepositoriesFragmentArgs>()
    lateinit var userRepositories: UserRepositories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_user_repositories, container, false)

        userRepositories = args.please
        setRecyclerView()
        setVisuals()

        return binding.root
    }


    fun setRecyclerView() {
        binding.repositoriesRecycler.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = UserReposRecyclerAdapter(userRepositories)
        }
    }


    fun setVisuals() {
        binding.apply {
            userFullName.text = userRepositories[0].owner.login

            Glide.with(requireActivity())
                .load(userRepositories[0].owner.avatarUrl)
                .override(320, 480)
                .into(userReposImage)

        }
    }
}