package com.rn.binbin.myapplication

import cn.reactnative.modules.update.UpdatePackage
import com.facebook.react.ReactActivity
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler

//打包APK.生成:bundle:https://reactnative.cn/docs/signed-apk-android.html#content
//如果node_modules 在与app同目录下。执行：
//react-native bundle --platform android --dev false --entry-file ./index.js --bundle-output ./app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res

//react-native bundle --platform android --dev false --entry-file ./rn/index.js --bundle-output ./app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res
//如果node_modules 在与android同目录下。执行：
//react-native bundle --platform android --dev false --entry-file index.js --bundle-output android/app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res
/**
 * 更新操作流程：
 *当前工程android目录下，执行
 * 1，react-native bundle --platform android --dev false --entry-file ./index.js --bundle-output ./android/app/src/main/assets/index.android.bundle --assets-dest  ./android/build/intermedia/android
 * 2，pushy bundle --platform android
 * 3，在https://update.reactnative.cn/dashboard/20720/version 下可看到版本信息
 *
 * 相关参考：
 * 集成到现有原生应用：
 * https://reactnative.cn/docs/integration-with-existing-apps/
 * 发布应用：
 * https://github.com/reactnativecn/react-native-pushy/blob/master/docs/guide3.md
 * pushy uploadApk /Users/binbin/WORK/rntest/android/app/build/outputs/apk/release/app-release.apk
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
 * 如果出现
 * Unable to load script.Make sure you are either running a Metro server or that your bundle 'index.android.bundle' is packaged correctly for release
    执行：adb reverse tcp:8081 tcp:8081

pushy命令：
https://github.com/reactnativecn/react-native-pushy/blob/master/docs/cli.md
 * */
class MainActivity() : ReactActivity(), DefaultHardwareBackBtnHandler {
    override fun getMainComponentName(): String? {
        return MODULE_NAME
    }

    companion object {
        const val MODULE_NAME = "rn_project"
    }

}
