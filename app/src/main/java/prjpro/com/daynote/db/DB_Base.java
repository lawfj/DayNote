package prjpro.com.daynote.db;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class DB_Base {

    public SharedPreferences settings;
    private Context context;
    private String db_name = "DB_BASE";

    public DB_Base(Context context) {
        this.context = context;
    }

    public void setDBName(String db_name) {
        this.db_name = db_name;
    }

    public SharedPreferences getSettings() {
        if (settings == null && context != null) {
            settings = context.getSharedPreferences(db_name, Application.MODE_PRIVATE);
        }
        return settings;
    }

    public void setString(String key, String value) {
        if (settings == null) {
            settings = getSettings();
        }
        settings.edit().putString(key, value).commit();
    }

    public String getString(String key, String defValue) {
        if (settings == null) {
            settings = getSettings();
        }
        if (!settings.contains(key)) {
            return defValue;
        }

        return settings.getString(key, defValue);
    }

    public void setBoolean(String key, boolean value) {
        if (settings == null) {
            settings = getSettings();
        }
        settings.edit().putBoolean(key, value).commit();
    }

    public boolean getBoolean(String key, boolean defValue) {
        if (settings == null) {
            settings = getSettings();
        }
        if (!settings.contains(key)) {
            return defValue;
        }

        return settings.getBoolean(key,defValue);
    }
}
