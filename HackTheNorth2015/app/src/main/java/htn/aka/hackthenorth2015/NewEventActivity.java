package htn.aka.hackthenorth2015;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NewEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        
        EditText nameView = (EditText)findViewById(R.id.event_name);
        TextView locationView = (TextView)findViewById(R.id.event_location);
        TextView startDateView = (TextView)findViewById(R.id.start_date);
        TextView endDateView = (TextView)findViewById(R.id.end_date);
        TextView inviteGuestsView = (TextView)findViewById(R.id.invite_guests);
        TextView addImageView = (TextView)findViewById(R.id.add_image);
        FloatingActionButton confirmFAB = (FloatingActionButton)findViewById(R.id.confirm_fab);

        String title = nameView.getText().toString();

        locationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_event, menu);
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
