package htn.aka.hackthenorth2015;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.parse.Parse;

/**
 * Created by rohitsharma on 2015-09-19.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "rTri7QJ6iN2uiL45LdS2im9ox2kMY1BJRBBRET8x", "t1vVIFA4WwsjxBLYje3ldEFtCluCDKkfdLH1ojPO");
        Log.wtf("Parse", "initialized");
    }

    public static boolean hasNetworkConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            // There are no active networks.
            return false;
        } else
            return true;
    }
}
