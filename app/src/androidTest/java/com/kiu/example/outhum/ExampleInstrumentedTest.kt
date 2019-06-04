/*
 * ********************************************************
 *   Copyright (c) 2019  Kiusoftech
 *   Created by Bama Kant Kar on 4/6/19 12:54 AM
 *   All rights reserved.
 *   Last modified 3/6/19 7:51 PM
 * ********************************************************
 */

package com.kiu.example.outhum

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.kiu.example.outhum", appContext.packageName)
    }
}
