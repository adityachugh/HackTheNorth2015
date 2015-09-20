package htn.aka.hackthenorth2015;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ProgressBar;

import com.parse.FunctionCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EventsAdapter mEventsAdapter;
    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(mView);

        ProgressBar loading = (ProgressBar)findViewById(R.id.events_list_progressbar);
        //grab data from server
        CloudFunctions.getEventsForUser(loading, this, mView, new FunctionCallback<JSONArray>() {
            @Override
            public void done(JSONArray guestsList, ParseException e) {
                if (e == null){
                    List<Event> events = new ArrayList<Event>();
//                    for (JSONObject guest : guestsList){
//                        //guests -> events -> Events (java)
//                        events.add(new Event(guest.getJSONObject(EventDateSource.GUESTS_EVENT_FIELD_TITLE)));
//                    }

                    for (int i = 0; i < guestsList.length() ; i++){
                        //guests -> events -> Events (java)
                        try {
                            events.add(new Event(guestsList.getJSONObject(i)));
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }

                    //the following should be done after data is set
                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.events_list_recyclerview);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                    //Initialize and set the adapter
                    mEventsAdapter = new EventsAdapter(MainActivity.this, events);
                    recyclerView.setAdapter(mEventsAdapter);

                    //animation!
                    TranslateAnimation trans = new TranslateAnimation(0, 0, 1000, 0);
                    trans.setDuration(500);
                    trans.setInterpolator(new DecelerateInterpolator(1.0f));
                    recyclerView.startAnimation(trans);

                    FloatingActionButton newEventFab = (FloatingActionButton)findViewById(R.id.add_new_event_fab);
                    newEventFab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //move to new event activity
                            Intent i = new Intent(MainActivity.this, NewEventActivity.class);
                            startActivityForResult(i, NewEventActivity.NEW_EVENT_CODE);
                        }
                    });

                }
            }
        });

//        //below is fake data
//        List<Event> events = new ArrayList<>();
//        events.add(new Event("Test 1", "Oct. 9th - Nov. 10th", new Date(), new Date(), ""));
//        events.add(new Event("Test 2", "Oct. 9th - Nov. 10th", new Date(), new Date(), ""));
//        events.add(new Event("Test 3", "Oct. 9th - Nov. 10th", new Date(), new Date(), ""));
//        events.add(new Event("Test 4", "Oct. 9th - Nov. 10th", new Date(), new Date(), ""));
//        events.add(new Event("Test 5", "Oct. 9th - Nov. 10th", new Date(), new Date(), ""));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK){
            if (requestCode == NewEventActivity.NEW_EVENT_CODE){
                //TODO: add event to event list!
            }
        }
        setContentView(R.layout.activity_main);

        //TODO: grab data from server
        //below is fake data
        List<Event> events = new ArrayList<>();
        events.add(new Event("Test 1", "Oct. 9th - Nov. 10th", new Date(), new Date(), ""));
        events.add(new Event("Test 2", "Oct. 9th - Nov. 10th", new Date(), new Date(), ""));
        events.add(new Event("Test 3", "Oct. 9th - Nov. 10th", new Date(), new Date(), ""));
        events.add(new Event("Test 4", "Oct. 9th - Nov. 10th", new Date(), new Date(), ""));
        events.add(new Event("Test 5", "Oct. 9th - Nov. 10th", new Date(), new Date(), ""));

        //the following should be done after data is set
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.events_list_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Initialize and set the adapter
        mEventsAdapter = new EventsAdapter(this, events);
        recyclerView.setAdapter(mEventsAdapter);

        //animation!
        TranslateAnimation trans = new TranslateAnimation(0, 0, 1000, 0);
        trans.setDuration(500);
        trans.setInterpolator(new DecelerateInterpolator(1.0f));
        recyclerView.startAnimation(trans);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
