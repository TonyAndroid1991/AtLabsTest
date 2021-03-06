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
import com.y4kuzabanzai.atlabstest.models.userindetail.UserInDetail

class EditImageFragment : Fragment() {

    private val args by navArgs<EditImageFragmentArgs>()
    lateinit var userInDetail: UserInDetail
    lateinit var editImageBinding: FragmentEditImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        userInDetail = args.userInDetail
        editImageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_image, container, false)

        loadImage()

        return editImageBinding.root
    }
    
    fun loadImage() {

        Glide.with(requireActivity())
            .load(userInDetail?.avatarUrl)
            .override(720, 1280)
            .into(editImageBinding.bigUserImage)
    }

}