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

    public static void getEventsForUser (final ProgressBar loading, Context context, final View view, final FunctionCallback<JSONArray> callback) {
        loading.setVisibility(View.VISIBLE);
        if (!App.hasNetworkConnection(context)){
            loading.setVisibility(View.GONE);
            Snackbar.make(view, "No internet connection!", Snackbar.LENGTH_SHORT).show();
        }

        HashMap<String, Object> params = new HashMap<>();

        ParseCloud.callFunctionInBackground("test", params, new FunctionCallback<JSONArray>() {
            @Override
            public void done(JSONArray parseObjects, ParseException e) {
                if (e != null) {
                    e.printStackTrace();
                } else {
//                    int i = 0;
                    for (int i = 0; i < parseObjects.length(); i++) {
                        try {
                            JSONObject jsonObject = parseObjects.getJSONObject(i);
                            String facebookId = jsonObject.getString("facebookId");
                            Log.d("CloudFunctions", facebookId);
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });

//        ParseCloud.callFunctionInBackground("test", params, new FunctionCallback<List<ParseObject>>() {
//            @Override
//            public void done(List<ParseObject> parseObjectList, ParseException e) {
//                int i = 0;
//                loading.setVisibility(View.GONE);
//                if (e!= null) {
//                    Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_SHORT).show();
//                }
////                callback.done(parseObjectList, e);
//
//                if (e!=null) e.printStackTrace(System.out);
//            }
//        });
    }
}
