package cordova.handtask.app.handle;

import android.content.*;
import android.util.*;
import android.os.Bundle;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import com.inspur.encryption.OperationUtils;
import com.inspur.encryption.utils.CommonMethodUtil.InvokeCallBack;
import com.inspur.encryption.utils.MyApp;
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
            boolean isOut = "true".equalsIgnoreCase(args.getString(1));//外网
            System.out.println("Current package Name is :" + packageName);
            OperationUtils.getSecPackage(packageName, isOut, new InvokeCallBack(){
                @Override
                public void onSuccess(Object o) {
                    List<MyApp> myApps = (List<MyApp>) o;
                    System.out.println(myApps);
                    List<JSONObject> apps = createDemoApps(myApps, isOut);
                    callbackContext.success(new JSONArray(apps));
                }
                @Override
                public void onFail(Exception e) {
                    callbackContext.error("取得工单二级应用失败");
                }
            });
            
            return true;
        } else if ("startApp".equals(action)) {
            String packageName = args.getString(0);//packageName
			String activityName = args.getString(1);//activityName
            String params = args.getString(2);//参数
            boolean isOut = "true".equalsIgnoreCase(args.getString(3));//外网
			String token = this.cordova.getActivity().getIntent().getStringExtra("token");
			System.out.println("=================================");
			System.out.println(packageName);
			System.out.println(activityName);
            System.out.println(params);
            System.out.println(isOut);
			System.out.println(token);
			System.out.println("=================================");
			Bundle bundle = new Bundle();
			Intent intent = new Intent();
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.setComponent(new ComponentName(packageName, activityName));
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
            OperationUtils.startActivity(this.cordova.getActivity(), packageName, intent, isOut);
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

    private List<JSONObject> createDemoApps(List<MyApp> myApps, boolean isOut) {
        List<JSONObject> apps = new ArrayList<JSONObject>();
        for (int i = 0; i < myApps.size(); i++) {
            MyApp app = myApps.get(i);
            
            String iconUrl = app.getAppIco();
            if (!iconUrl.contains("http")) {
                iconUrl = isOut ? "http://211.137.182.253:8092/mp/":"http://10.213.51.42:8092/mp/";
                iconUrl += app.getAppIco();
            }
            apps.add(new AppInfo(
                    app.getAppName(),
                    app.getStartInfo(),
                    app.getStartActivityInfo(),
                    app.getAppCompany(),
                    iconUrl,
                    app.getVersion(),
                    app.getVersionCode() + "",
                    app.getPublicState()).getJsonObject());
        }
        return apps;
    }
}
