package cordova.handtask.app.handle;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * This class echoes a string called from JavaScript.
 */
public class AppInfo {
    private String name;
    private String packageName;
    private String activity;
    private String company;
    private String iconUrl;
    private String versionName;
    private String versionCode;
    private String publicState;

    public AppInfo() {}
    public AppInfo(String name, String packageName, String activity, String company, String iconUrl, String versionName, String versionCode, String publicState) {
        this.name = name;
        this.packageName = packageName;
        this.activity = activity;
        this.company = company;
        this.iconUrl = iconUrl;
        this.versionName = versionName;
        this.versionCode = versionCode;
        this.publicState = publicState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public void setPublicState(String publicState) {
        this.publicState = publicState;
    }

    public String getPublicState() {
        return publicState;
    }

    public JSONObject getJsonObject(){
        JSONObject json = new JSONObject();
        try {
            json.put("name", this.name);
            json.put("packageName", this.packageName);
            json.put("activity", this.activity);
            json.put("company", this.company);
            json.put("iconUrl", this.iconUrl);
            json.put("versionName", this.versionName);
            json.put("versionCode", this.versionCode);
            json.put("publicState", this.publicState);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
}