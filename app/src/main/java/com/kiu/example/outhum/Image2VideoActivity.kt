/*
 * ********************************************************
 *   Copyright (c) 2019  Kiusoftech
 *   Created by Bama Kant Kar on 4/6/19 12:54 AM
 *   All rights reserved.
 *   Last modified 4/6/19 12:54 AM
 * ********************************************************
 */

package com.kiu.example.outhum

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_imge2_video.*

class Image2VideoActivity : AppCompatActivity() {

    private val PICK_IMAGE: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imge2_video)

        btnUploadImage.setOnClickListener {
            chooseImageFromGallery() //call this function to pick image from gallery
        }

    }

    private fun chooseImageFromGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE){
            val imageUri = data!!.data
            ivImage.setImageURI(imageUri)
        }
    }

}
