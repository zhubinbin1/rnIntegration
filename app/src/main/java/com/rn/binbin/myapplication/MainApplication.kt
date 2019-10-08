package com.rn.binbin.myapplication

import android.app.Application
import com.facebook.react.ReactApplication
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.shell.MainReactPackage
import com.facebook.soloader.SoLoader
import cn.reactnative.modules.update.UpdateContext
import cn.reactnative.modules.update.UpdatePackage
import java.util.Arrays


class MainApplication : Application() {

//
//    private val mReactNativeHost = object : ReactNativeHost(this) {
//        override fun getPackages(): MutableList<ReactPackage> {
//            return packagess
//        }
//
//        override fun getUseDeveloperSupport(): Boolean {
//            return BuildConfig.DEBUG
//        }
//
//        override fun getJSBundleFile(): String? {
//            return UpdateContext.getBundleUrl(this@MainApplication)
//        }
//
//    }
//    private val packagess: MutableList<ReactPackage>
//        get() = Arrays.asList(
//            MainReactPackage(),
//            UpdatePackage()
//        )
//
//    override fun getReactNativeHost(): ReactNativeHost {
//        return mReactNativeHost
//    }

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, /* native exopackage */ false)
    }
}