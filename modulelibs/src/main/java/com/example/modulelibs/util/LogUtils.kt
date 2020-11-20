package com.example.modulelibs.util

import com.example.modulelibs.BuildConfig

val Any.TAG: String
    get() {
        val tag = javaClass.simpleName
        return if (tag.length <= 23) tag else tag.substring(0, 23)
    }

val Any.DEBUG: Boolean
    get() {
        return BuildConfig.BUILD_TYPE == "debug"
    }