package com.rn.binbin.myapplication

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import cn.reactnative.modules.update.UpdatePackage
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView
import com.facebook.react.common.LifecycleState
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import com.facebook.react.shell.MainReactPackage
//打包APK.生成:bundle:https://reactnative.cn/docs/signed-apk-android.html#content
//如果node_modules 在与app同目录下。执行：
//react-native bundle --platform android --dev false --entry-file ./index.js --bundle-output ./app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res

//react-native bundle --platform android --dev false --entry-file ./rn/index.js --bundle-output ./app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res
//如果node_modules 在与android同目录下。执行：
//react-native bundle --platform android --dev false --entry-file index.js --bundle-output android/app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res
/**
 * 更新操作流程：
 *当前工程android目录下，执行
 * 1，react-native bundle --platform android --dev false --entry-file ./index.js --bundle-output ./app/src/main/assets/index.android.bundle --assets-dest  ./app/build/intermediates/res/merged/release
 * 2，pushy bundle --platform android
 * 3，在https://update.reactnative.cn/dashboard/20720/version 下可看到版本信息
 *
 * 相关参考：
 * 集成到现有原生应用：
 * https://reactnative.cn/docs/integration-with-existing-apps/
 * 发布应用：
 * https://github.com/reactnativecn/react-native-pushy/blob/master/docs/guide3.md
 * 添加热更新功能：
 * https://github.com/reactnativecn/react-native-pushy/blob/master/docs/guide2.md
 * 准备工作：
 * https://github.com/reactnativecn/react-native-pushy/blob/master/docs/guide.md
 *
 * 工程中的目录是：/Users/binbin/WORK/rntest/android/node_modules/react-native-update/docs
 * 全局搜索：返回的info有三种情况
 * 安装：
 *  adb -s 5HR6R19316023703 install /Users/binbin/WORK/rntest/android/app/build/outputs/apk/release/app-release.apk
 * 编译：
 * ./gradlew aR
 * */
class MainActivity() : AppCompatActivity(), DefaultHardwareBackBtnHandler {
    private var mReactRootView: ReactRootView? = null
    var mReactInstanceManager: ReactInstanceManager? = null
    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }

    private val OVERLAY_PERMISSION_REQ_CODE = 1  // 任写一个值
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (!Settings.canDrawOverlays(this)) {
//                val intent = Intent(
//                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
//                    Uri.parse("package:$packageName")
//                )
//                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE)
//            }
//        }
        mReactRootView = ReactRootView(this)
        mReactInstanceManager = ReactInstanceManager.builder()
            .setApplication(application)
            .setCurrentActivity(this)
            .setBundleAssetName("index.android.bundle")
            .setJSMainModulePath("./index")
            .addPackage(MainReactPackage())
            .addPackage(UpdatePackage())
            .setUseDeveloperSupport(BuildConfig.DEBUG)
            .setInitialLifecycleState(LifecycleState.RESUMED)
            .build()
        // 注意这里的MyReactNativeApp必须对应“index.js”中的
        // “AppRegistry.registerComponent()”的第一个参数
        mReactRootView?.startReactApplication(mReactInstanceManager, MODULE_NAME, null)

        setContentView(mReactRootView)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    // SYSTEM_ALERT_WINDOW permission not granted
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()

        if (mReactInstanceManager != null) {
            mReactInstanceManager?.onHostPause(this)
        }
    }

    override fun onResume() {
        super.onResume()

        if (mReactInstanceManager != null) {
            mReactInstanceManager?.onHostResume(this, this)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        if (mReactInstanceManager != null) {
            mReactInstanceManager?.onHostDestroy(this)
        }
        if (mReactRootView != null) {
            mReactRootView?.unmountReactApplication()
        }
    }

    override fun onBackPressed() {
        if (mReactInstanceManager != null) {
            mReactInstanceManager?.onBackPressed()
        } else {
            super.onBackPressed()
        }
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_MENU && mReactInstanceManager != null) {
            mReactInstanceManager?.showDevOptionsDialog()
            return true
        }
        return super.onKeyUp(keyCode, event)
    }

    companion object {
        const val MODULE_NAME = "rn_project"
    }

}
