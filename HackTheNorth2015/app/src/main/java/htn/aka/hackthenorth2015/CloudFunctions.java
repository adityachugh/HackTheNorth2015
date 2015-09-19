package htn.aka.hackthenorth2015;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ProgressBar;

import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.parse.ParseException;
import com.parse.ParseObject;

import java.util.List;

/**
 * Created by rohitsharma on 2015-09-19.
 */
public class CloudFunctions {

    public static void getEventsForUser (final ProgressBar loading, Context context, final View view, final FunctionCallback<List<ParseObject>> callback) {
        loading.setVisibility(View.VISIBLE);
        if (!App.hasNetworkConnection(context)){
            loading.setVisibility(View.GONE);
            Snackbar.make(view, "No internet connection!", Snackbar.LENGTH_SHORT).show();
        }

        ParseCloud.callFunctionInBackground("getEventsForUser", null, new FunctionCallback<List<ParseObject>>() {
            @Override
            public void done(List<ParseObject> parseObjectList, ParseException e) {
                loading.setVisibility(View.GONE);
                if (e!= null) {
                    Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_SHORT).show();
                }
                callback.done(parseObjectList, e);
            }
        });
    }
}
