/*
 * ********************************************************
 *   Copyright (c) 2019  Kiusoftech
 *   Created by Bama Kant Kar on 4/6/19 12:54 AM
 *   All rights reserved.
 *   Last modified 4/6/19 12:51 AM
 * ********************************************************
 */

package com.kiu.example.outhum

import android.Manifest
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import android.Manifest.permission
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.PermissionRequest


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Dexter.withActivity(this)
            .withPermissions(
                READ_EXTERNAL_STORAGE,
                WRITE_EXTERNAL_STORAGE
            )
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    // check if all permissions are granted
                    if (report.areAllPermissionsGranted()) {
                        // do you work now
                    }

                    // check for permanent denial of any permission
                    if (report.isAnyPermissionPermanentlyDenied) {
                        // permission is denied permenantly, navigate user to app settings
                    }
                }

                override fun onPermissionRationaleShouldBeShown(permissions: List<PermissionRequest>, token: PermissionToken) {
                    token.continuePermissionRequest()
                }
            })
            .onSameThread()
            .check()

        //for video activity
        btnVideo.setOnClickListener {
            startActivity(Intent(this, VideoActivity::class.java))
        }

        //for Image to Video converter activity
        btnImage.setOnClickListener {
            startActivity(Intent(this, Image2VideoActivity::class.java))
        }

        //for Gif to video converter activity
        btnGif.setOnClickListener {
            startActivity(Intent(this, Gif2VideoActivity::class.java))
        }

    }
}
