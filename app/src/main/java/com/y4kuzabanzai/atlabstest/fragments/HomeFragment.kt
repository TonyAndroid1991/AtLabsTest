package com.y4kuzabanzai.atlabstest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.y4kuzabanzai.atlabstest.R
import com.y4kuzabanzai.atlabstest.databinding.FragmentHomeBinding
import com.y4kuzabanzai.atlabstest.models.userindetail.UserInDetail
import com.y4kuzabanzai.atlabstest.viewmodels.HomeFragmentViewModel


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: HomeFragmentViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        if (viewModel.getUser() != null)
            showUserData(viewModel.getUser()!!)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        if (viewModel.getUser() != null)
            showUserData(viewModel.getUser()!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
        binding.bindingViewModel = viewModel
        binding.lifecycleOwner = this

        binding.button.setOnClickListener {
            if (!viewModel.userName.value.isNullOrEmpty())
                showUserData(viewModel.getUser()!!)
        }

        binding.cardView.setOnClickListener { view ->
            if (viewModel.userName.value != null) {
                viewModel.getUserRepositories()?.observe(requireActivity(), Observer {
                    val action =
                        HomeFragmentDirections.actionHomeFragmentToUserRepositoriesFragment(it!!)
                    this.findNavController().navigate(action)
                })
            }
        }

        binding.userImage.setOnClickListener {
            viewModel.getUser()?.observe(requireActivity(), Observer {
                if (it != null) {
                    val action = HomeFragmentDirections.actionHomeFragmentToEditImageFragment(it!!)
                    this.findNavController().navigate(action)
                }
            })
        }
        return binding.root
    }

    private fun showUserData(user: LiveData<UserInDetail?>) {
        user.observe(requireActivity(), Observer { userInDetail ->
            binding.apply {
                userFullName.text = userInDetail?.name
                userName?.text = userInDetail?.login
                userBiography.text = userInDetail?.bio.toString()

                Glide.with(requireActivity())
                    .load(userInDetail?.avatarUrl)
                    .override(320, 480)
                    .into(userImage)
            }
        })
    }
}