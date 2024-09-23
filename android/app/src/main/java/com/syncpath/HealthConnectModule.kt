package com.syncpath

import android.content.Context
import android.content.pm.PackageManager
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class HealthConnectModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "HealthConnectModule"
    }

    @ReactMethod
    fun checkAvailability(promise: Promise) {
        val packageName = "com.google.android.apps.healthdata"
        val pm: PackageManager = reactApplicationContext.packageManager
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            promise.resolve(true) // Health Connect is available
        } catch (e: PackageManager.NameNotFoundException) {
            promise.resolve(false) // Health Connect is not available
        }
    }
}
