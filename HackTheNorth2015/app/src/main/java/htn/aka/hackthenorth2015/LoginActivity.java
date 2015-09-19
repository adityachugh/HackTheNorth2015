package htn.aka.hackthenorth2015;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

//    CallbackManager mCallbackManager;
//    String mID;
//    String mFirstName;
//    String mLastName;
//    String mAvatarURL;
    String mClientKey = "3H7ogUKlVxsKagm5p70PULbsCLSRQjGXreMVP6fL";
    String mApplicationKey = "vAUIoQAcASaiGKvFP9hhhXecz3pvx9sqLyIZfEfw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, mApplicationKey, mClientKey);
        ParseFacebookUtils.initialize(this);

        if (ParseUser.getCurrentUser() == null){
            Button loginButton = (Button) findViewById(R.id.login_button);
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<String> permissions = new ArrayList<String>();
                    ParseFacebookUtils.logInWithReadPermissionsInBackground(LoginActivity.this, permissions, new LogInCallback() {
                        @Override
                        public void done(ParseUser parseUser, ParseException e) {
                            if (parseUser == null) {
                                Log.d(TAG, "Error creating user");
                            } else if (parseUser.isNew()) {
                                Log.d(TAG, "Created new user");
                                getFacebookInfo();
                            } else {
                                Log.d(TAG, "Logged in existing user");
                                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(i);
                            }
                        }
                    });
                }
            });
        } else {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
        }

    }

    private void getFacebookInfo() {
        Bundle parameters = new Bundle();
        parameters.putString("fields", "picture, first_name, last_name, id");
        new GraphRequest(AccessToken.getCurrentAccessToken(),
                "/me",
                parameters,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse graphResponse) {
                        JSONObject user = graphResponse.getJSONObject();
                        ParseUser currentUser = ParseUser.getCurrentUser();
                        currentUser.put("firstName", user.optString("first_name"));
                        currentUser.put("lastName", user.optString("last_name"));
                        currentUser.put("facebookId", user.optString("id"));
                        currentUser.put("pictureURL", user.optJSONObject("picture")
                                .optJSONObject("data")
                                .optString("url"));
                        currentUser.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null){
                                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(i);
                                }
                            }
                        });
                    }
                }).executeAsync();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseFacebookUtils.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
