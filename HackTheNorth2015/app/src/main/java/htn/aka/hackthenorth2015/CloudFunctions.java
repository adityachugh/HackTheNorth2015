package htn.aka.hackthenorth2015;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.parse.ParseException;
import com.parse.ParseObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by rohitsharma on 2015-09-19.
 */
public class CloudFunctions {

    public static void getEventsForUser (final ProgressBar loading, Context context, final View view, final FunctionCallback<List<JSONObject>> callback) {
        loading.setVisibility(View.VISIBLE);
        if (!App.hasNetworkConnection(context)){
            loading.setVisibility(View.GONE);
            Snackbar.make(view, "No internet connection!", Snackbar.LENGTH_SHORT).show();
        }

        HashMap<String, Object> params = new HashMap<>();

        ParseCloud.callFunctionInBackground("test", params, new FunctionCallback<HashMap<String, Object>>() {
            @Override
            public void done(HashMap<String, Object> parseObjects, ParseException e) {
                if (e != null) {
                    e.printStackTrace();
                } else {
//                    int i = 0;
                    for (int i = 0; i < parseObjects.size(); i++) {
                        try {
                            JSONObject jsonObject = (JSONObject)parseObjects.get(i+"");
                            String facebookId = jsonObject.getString("facebookId");
                            Log.d("CloudFunctions", facebookId);
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}
