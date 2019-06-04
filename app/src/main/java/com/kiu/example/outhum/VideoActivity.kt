/*
 * ********************************************************
 *   Copyright (c) 2019  Kiusoftech
 *   Created by Bama Kant Kar on 4/6/19 12:54 AM
 *   All rights reserved.
 *   Last modified 4/6/19 12:47 AM
 * ********************************************************
 */

package com.kiu.example.outhum

import android.app.Activity
import android.content.Intent
import android.media.MediaMetadataRetriever
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_video.*


class VideoActivity : AppCompatActivity() {

    private val PICK_VIDEO_FROM_GALLERY: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        btnUploadVideo.setOnClickListener {
            chooseVideoFromGallery()
        }

        btnPreviewVideo.setOnClickListener {
            videoView2.start()
        }
    }

    private fun chooseVideoFromGallery() {
        val intent = Intent()
        intent.type = "video/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Video"), PICK_VIDEO_FROM_GALLERY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == PICK_VIDEO_FROM_GALLERY) {
            val videoUri = data!!.data
            videoView2.setVideoURI(videoUri)
            videoView2.requestFocus()

            val retriever = MediaMetadataRetriever()
            retriever.setDataSource(applicationContext, videoUri)
            val width = Integer.valueOf(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH))
            val height = Integer.valueOf(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT))
            val duration = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
            val durationInMillisec = java.lang.Long.parseLong(duration)
            val durationInSecond = durationInMillisec / 1000
            val minute = durationInSecond / 60
            val second = durationInSecond % 60
            var data = ""
            data = if (width == 1920 && height == 1080 && durationInSecond.toInt()<= 60 && durationInSecond.toInt() >=10)
                "Video Supported."
            else
                "Video not supported."

            data += "\nVideo details : \n" +
                        "Width : $width \n" +
                        "Height : $height \n" +
                        "Duration : $minute:$second"
            data += "\n Required format is : \n"+
                    "Width : 1920 px \n" +
                    "Height : 1080 px \n" +
                    "Duration : \n min 0.10 sec, max 0.60 sec"

            tvVideoDetails.text = data
            retriever.release()
        }
    }
}
