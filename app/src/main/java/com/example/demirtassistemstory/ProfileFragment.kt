package com.example.demirtassistemstory

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.search_list_item.view.*


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(50))

        val glide = Glide.with(this)

        glide
            .load("https://images.unsplash.com/photo-1485906441524-ed91f8315b4a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80")
            .into(ivGonderi)

        glide
            .load("https://images.unsplash.com/photo-1630446838167-4f63bc82e1cf?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80")
            .into(ivGonderi2)

        glide
            .load("https://images.unsplash.com/photo-1541821066-9dfae67b8360?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80")
            .into(ivGonderi3)

        glide
            .load("https://images.unsplash.com/photo-1605123169982-563b40088137?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80")
            .into(ivGonderi4)

        glide
            .setDefaultRequestOptions(requestOptions.override(100, 100))
            .load("https://images.unsplash.com/photo-1625957128945-2245b2730326?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzB8fGYxfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
            .into(profileImageView)

    }
}