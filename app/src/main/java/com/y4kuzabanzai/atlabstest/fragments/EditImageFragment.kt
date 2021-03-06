package com.y4kuzabanzai.atlabstest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.y4kuzabanzai.atlabstest.R
import com.y4kuzabanzai.atlabstest.databinding.FragmentEditImageBinding
import com.y4kuzabanzai.atlabstest.models.user.User

class EditImageFragment : Fragment() {

    private val args by navArgs<EditImageFragmentArgs>()
    lateinit var user: User
    lateinit var editImageBinding: FragmentEditImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        user = args.user
        editImageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_image, container, false)

        loadImage()

        return editImageBinding.root
    }
    
    fun loadImage() {

        Glide.with(requireActivity())
            .load(user?.avatarUrl)
            .override(720, 1280)
            .into(editImageBinding.bigUserImage)
    }

}