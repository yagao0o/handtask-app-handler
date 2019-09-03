package cordova.handtask.app.handle;

import android.content.*;
import android.util.*;
import android.os.Bundle;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class HandtaskAppHandler extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
       if ("getApps".equals(action)) {
            String packageName = args.getString(0);
            System.out.println("Current package Name is :" + packageName);
            List<JSONObject> apps = this.createDemoApps();
            callbackContext.success(new JSONArray(apps));
            return true;
        } else if ("startApp".equals(action)) {
            String packageName = args.getString(0);//packageName
			String activityName = args.getString(1);//activityName
			String params = args.getString(2);//activityName
			String token = this.cordova.getActivity().getIntent().getStringExtra("token");
			System.out.println("=================================");
			System.out.println(packageName);
			System.out.println(activityName);
			System.out.println(params);
			System.out.println(token);
			System.out.println("=================================");
			Bundle bundle = new Bundle();
			Intent intent = new Intent();
			intent.addCategory(Intent.CATEGORY_DEFAULT);
			intent.setComponent(new ComponentName(packageName,activityName));
			intent.putExtras(bundle);
			intent.putExtra("zsyw", "zsyw");
			intent.putExtra("token", token);
			if (params != null && params.length() > 0) {
				String[] keyValueList = params.split("&");
				for(int i = 0; i < keyValueList.length; i++){
					String[] keyAndValue = keyValueList[i].split("=");
					intent.putExtra(keyAndValue[0],keyAndValue[1]);
				}
            }
            // TODO: 调用云峰插件管理
            JSONObject obj = new JSONObject();
            obj.put("success", true);
            callbackContext.success(obj);
			return true;
        } 
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private List<JSONObject> createDemoApps() {
        List<JSONObject> apps = new ArrayList<>(4);
        apps.add(new AppInfo("工单","com.inspur.combined", "com.inspur.combined.login.LoginActivity", "浪潮通信信息系统有限公司","rest/download/down?type=images&file=A_AppsCombined_20160425202711.png","20.8","208").getJsonObject());
        apps.add(new AppInfo("掌上工具集","com.inspur.tool","com.inspur.tool.LoginActivity", "浪潮通信信息系统有限公司","rest/download/down?type=images&file=A_tool_20181222095453.png","1.3","3").getJsonObject());
        apps.add(new AppInfo("双闭环工单","ionic.inspur.doubleClosedLink","ionic.inspur.doubleClosedLink.MainActivity", "浪潮通信信息系统有限公司","rest/download/down?type=images&file=A_doubleClosedLink_20190815210934.png","0.0.3","3").getJsonObject());
        apps.add(new AppInfo("工单报表","comt.able.inspur.workorder","comt.able.inspur.workorder.login.LoginAct", "浪潮通信信息系统有限公司","rest/download/down?type=images&file=A_gdbb_20140609190446.png","3.5","58").getJsonObject());
        apps.add(new AppInfo("工单直派","com.inspur.workorder","com.inspur.workorder.login.LoginAct", "浪潮通信信息系统有限公司","rest/download/down?type=images&file=A_workorder_20140609190728.png","5.1","16").getJsonObject());
        return apps;
    }
}
