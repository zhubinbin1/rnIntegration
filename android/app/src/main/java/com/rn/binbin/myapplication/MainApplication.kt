package com.rn.binbin.myapplication

import android.app.Application
import android.content.Context
import com.facebook.react.ReactApplication
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.soloader.SoLoader
import cn.reactnative.modules.update.UpdateContext
import cn.reactnative.modules.update.UpdatePackage
import com.facebook.react.BuildConfig
import com.facebook.react.shell.MainReactPackage
import java.lang.reflect.InvocationTargetException
import java.util.*


class MainApplication : Application(),ReactApplication {


    private val mReactNativeHost = object : ReactNativeHost(this) {
        override fun getUseDeveloperSupport(): Boolean {
            return BuildConfig.DEBUG
        }

        override fun getPackages(): List<ReactPackage> {
// Packages that cannot be autolinked yet can be added manually here, for example:
            //           packages.add(new MyReactNativePackage());
            //                    packages.add(new UpdatePackage());
            return packagess
        }
        private val packagess: MutableList<ReactPackage>
            get() = Arrays.asList(
                MainReactPackage(),
                UpdatePackage()
            )
        override fun getJSBundleFile(): String? {
            return UpdateContext.getBundleUrl(this@MainApplication)
        }

        override fun getJSMainModuleName(): String {
            return "index"
        }
    }

    override fun getReactNativeHost(): ReactNativeHost {
        return mReactNativeHost
    }

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, /* native exopackage */ false)
        initializeFlipper(this) // Remove this line if you don't want Flipper enabled
    }

    /**
     * Loads Flipper in React Native templates.
     *
     * @param context
     */
    private fun initializeFlipper(context: Context) {
        if (BuildConfig.DEBUG) {
            try {
                /*
         We use reflection here to pick up the class that initializes Flipper,
        since Flipper library is not available in release mode
        */
                val aClass = Class.forName("com.facebook.flipper.ReactNativeFlipper")
                aClass.getMethod("initializeFlipper", Context::class.java).invoke(null, context)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: NoSuchMethodException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InvocationTargetException) {
                e.printStackTrace()
            }

        }
    }
}