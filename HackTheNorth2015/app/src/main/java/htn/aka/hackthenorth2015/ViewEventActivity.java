package htn.aka.hackthenorth2015;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
<<<<<<< HEAD
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
=======
import android.widget.ImageView;
>>>>>>> new-event-real

import java.util.Date;

public class ViewEventActivity extends AppCompatActivity {

    public final static String EXTRA_EVENT = "extra_event";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);

        Event event = new Event("", "", new Date(), new Date(), "");
        if (getIntent().getSerializableExtra(EXTRA_EVENT) != null){
            event = (Event)getIntent().getSerializableExtra(EXTRA_EVENT);
            Log.wtf("Event passed", event.getTitle());
        }

<<<<<<< HEAD
        ImageView image = (ImageView)findViewById(R.id.view_event_image);
        if (event.getImageUrl() != null && !event.getImageUrl().equals("")){
            Picasso.with(this).load(event.getImageUrl()).centerCrop().skipMemoryCache().resize(500, 400).into(image);
        }

=======
>>>>>>> new-event-real
        //TODO: populate data from event passed in

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(event.getTitle());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(event.getLocation());
        ImageView header = (ImageView) findViewById(R.id.image);

<<<<<<< HEAD
        setupClickableOptions();

    }

    private void setupClickableOptions() {
        LinearLayout availability = (LinearLayout)findViewById(R.id.event_availability);
        availability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.wtf("View Event", "availability pressed");
            }
        });


        LinearLayout guests = (LinearLayout)findViewById(R.id.event_guests);
        guests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.wtf("View Event", "guests pressed");
            }
        });


        LinearLayout chat = (LinearLayout)findViewById(R.id.event_chat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.wtf("View Event", "chat pressed");
            }
        });


        LinearLayout user = (LinearLayout)findViewById(R.id.event_user);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.wtf("View Event", "user pressed");
            }
        });


        LinearLayout leave = (LinearLayout)findViewById(R.id.event_leave);
        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.wtf("View Event", "leave pressed");
            }
        });


=======
>>>>>>> new-event-real
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home)
            this.onBackPressed();

        return super.onOptionsItemSelected(item);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> new-event-real
