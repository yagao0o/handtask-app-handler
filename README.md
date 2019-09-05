# 掌上运维应用管理插件

# 安装

cordova plugin add https://github.com/yagao0o/handtask-app-handler

# Ionic-Native

使用 ``ionic`` 可使用 ``@ionic-native`` 扩展：参考[ionic-native-handtask-app-handler](https://github.com/yagao0o/ionic-native-handtask-app-handler)

# 卸载

cordova plugin remove cordova.handtask.app.handle

# 使用方法

插件声明了一个全局的 ``HandtaskAppHandler`` 对象。


HandtaskAppHandler.getApps
=================

初始化客户端，调用视频组件前，需要初始化客户端信息，请首先调用。

    HandtaskAppHandler.getApps(packageName, isOut, successCallback, errorCallback);

参数说明：
- packageName 为当前应用的包名
- isOut 为是否外网，掌上运维启动时传入的参数
- successCallback 为调用成功的回调函数
- errorCallback为调用失败的回调函数


HandtaskAppHandler.startApp
=================

初始化客户端，调用视频组件前，需要初始化客户端信息，请首先调用。

    HandtaskAppHandler.startApp(packageName, activityName, params, isOut, successCallback, errorCallback);

参数说明：
- packageName 为唤醒应用的包名
- activityName 为唤醒应用的Activity名
- params 为唤醒应用参数，可为空，格式为: 参数名1=参数值1&参数名2=参数值2&参数名3=参数值3
- isOut 为是否外网，掌上运维启动时传入的参数
- successCallback 为调用成功的回调函数
- errorCallback为调用失败的回调函数

