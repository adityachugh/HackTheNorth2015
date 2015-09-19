package htn.aka.hackthenorth2015;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ProgressBar;

import com.parse.FunctionCallback;
import com.parse.ParseException;
import com.parse.ParseObject;

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
