package htn.aka.hackthenorth2015;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
<<<<<<< HEAD
import android.util.Log;
=======
>>>>>>> new-event-real
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
<<<<<<< HEAD
import android.widget.ProgressBar;

import com.parse.FunctionCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
=======
>>>>>>> new-event-real

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EventsAdapter mEventsAdapter;
<<<<<<< HEAD
    private View mView;
=======
>>>>>>> new-event-real

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        mView = getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(mView);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "rTri7QJ6iN2uiL45LdS2im9ox2kMY1BJRBBRET8x", "t1vVIFA4WwsjxBLYje3ldEFtCluCDKkfdLH1ojPO");
        Log.wtf("Parse", "initialized");

        ProgressBar loading = (ProgressBar)findViewById(R.id.events_list_progressbar);
        //grab data from server
        CloudFunctions.getEventsForUser(loading, this, mView, new FunctionCallback<List<ParseObject>>() {
            @Override
            public void done(List<ParseObject> guestsList, ParseException e) {
                if (e == null){
                    List<Event> events = new ArrayList<Event>();
                    for (ParseObject guest : guestsList){
                        //guests -> events -> Events (java)
                        events.add(new Event(guest.getParseObject(EventDateSource.GUESTS_EVENT_FIELD_TITLE)));
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
=======
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
>>>>>>> new-event-real
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
