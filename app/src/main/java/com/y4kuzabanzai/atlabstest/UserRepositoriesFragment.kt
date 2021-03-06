package com.y4kuzabanzai.atlabstest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.y4kuzabanzai.atlabstest.databinding.FragmentUserRepositoriesBinding
import com.y4kuzabanzai.atlabstest.models.userrepos.UserRepositoriesItem
import com.y4kuzabanzai.atlabstest.viewmodels.HomeFragmentViewModel

class UserRepositoriesFragment : Fragment() {

    lateinit var binding: FragmentUserRepositoriesBinding
    private val args by navArgs<UserRepositoriesFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_repositories, container, false)

        var array = args.please
        binding.practiceTest.text = array[0].name
        return binding.root
    }


}