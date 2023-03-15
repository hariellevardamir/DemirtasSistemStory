package com.example.demirtassistemstory

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_home.*
import pt.tornelas.segmentedprogressbar.SegmentedProgressBarListener


class HomeFragment : Fragment(R.layout.fragment_home) {

    val storyImages: List<String> = listOf(
        "https://images.unsplash.com/photo-1632726144626-6f6a8876e35d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjl8fGYxfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
        "https://images.unsplash.com/photo-1537403005834-9824a1ce7b1b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80",
        "https://images.unsplash.com/photo-1633272325340-320e54462e5e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80",
        "https://images.unsplash.com/photo-1591153402522-c04da308fb9a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1925&q=80"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadImage(storyImages.first())
        setTouchEvents()

        spb.apply {
            listener = object : SegmentedProgressBarListener {
                override fun onPage(oldPageIndex: Int, newPageIndex: Int) {
                    storyImage.background = null
                    val imageUrl = storyImages[newPageIndex]
                    loadImage(image = imageUrl)
                }

                override fun onFinished() {
                    reset()
                    loadImage(storyImages.first())
                }
            }

            segmentCount = 4
            start()
        }

    }

    private fun loadImage(image:String) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(50))

        Glide.with(requireContext())
            .load(image)
            .into(storyImage)
    }

    private fun setTouchEvents() {
        storyImage.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val x = event.x.toInt()

                if (x > getScreenWidth() / 2) {
                    spb.next()
                } else {
                    spb.previous()
                }
            }
            true
        }
    }

    override fun onResume() {
        super.onResume()
        spb.start()
    }

    override fun onPause() {
        super.onPause()
        spb.pause()
    }
}

fun getScreenWidth(): Int {
    return Resources.getSystem().displayMetrics.widthPixels
}