package prjpro.com.daynote.db;

import android.content.Context;

/**
 * Created by lsd on 15/6/14.
 */
public class DB_User extends DB_Base {
    public DB_User(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        setDBName("DB_USER");
    }

    public void setUserName(String userName) {
        setString("userName", userName);
    }

    public String getUserName() {
        return getString("userName", "");
    }

    public void setPassword(String password) {
        setString("password", password);
    }

    public String getPassword() {
        return getString("password", "");
    }

}
