package htn.aka.hackthenorth2015;

import android.app.DatePickerDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewEventActivity extends AppCompatActivity {

    public final static int NEW_EVENT_CODE = 1337;

    private Calendar mStartCal;
    private TextView mStartDateView;
    private Date mStartDate;
    private TextView mEndDateView;
    private Calendar mEndCal;
    private Date mEndDate;
    private EditText mNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        mStartCal = Calendar.getInstance();
        mEndCal = Calendar.getInstance();

        mNameView = (EditText) findViewById(R.id.event_name);
        TextView locationView = (TextView) findViewById(R.id.event_location);
        mStartDateView = (TextView) findViewById(R.id.start_date);
        mEndDateView = (TextView) findViewById(R.id.end_date);
        TextView inviteGuestsView = (TextView) findViewById(R.id.invite_guests);
        TextView addImageView = (TextView) findViewById(R.id.add_image);
        FloatingActionButton confirmFAB = (FloatingActionButton) findViewById(R.id.confirm_fab);

        //TODO: redirect to searchview for location
        locationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //sets start date
        mStartDateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpd = new DatePickerDialog(NewEventActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        mStartCal.set(Calendar.YEAR, year - 1900);
                        mStartCal.set(Calendar.MONTH, monthOfYear);
                        mStartCal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        year = mStartCal.get(Calendar.YEAR);
                        monthOfYear = mStartCal.get(Calendar.MONTH);
                        dayOfMonth = mStartCal.get(Calendar.DAY_OF_MONTH);

                        mStartDate = new Date(year, monthOfYear, dayOfMonth);

                        DateFormat df = DateFormat.getDateInstance();
                        String date = df.format(mStartDate);
                        mStartDateView.setText(date);
                    }
                }, mStartCal.get(Calendar.YEAR), mStartCal.get(Calendar.MONTH), mStartCal.get(Calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });

        //sets the end date
        mEndDateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpd = new DatePickerDialog(NewEventActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        mEndCal.set(Calendar.YEAR, year - 1900);
                        mEndCal.set(Calendar.MONTH, monthOfYear);
                        mEndCal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        year = mEndCal.get(Calendar.YEAR);
                        monthOfYear = mEndCal.get(Calendar.MONTH);
                        dayOfMonth = mEndCal.get(Calendar.DAY_OF_MONTH);

                        mEndDate = new Date(year, monthOfYear, dayOfMonth);

                        DateFormat df = DateFormat.getDateInstance();
                        String date = df.format(mEndDate);
                        mEndDateView.setText(date);
                    }
                }, mEndCal.get(Calendar.YEAR), mEndCal.get(Calendar.MONTH), mEndCal.get(Calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });

        //TODO: redirect to facebook search for friends to add
        inviteGuestsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //TODO: add image from user's phone
        addImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //TODO: pass all of the data to create a new event
        confirmFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = mNameView.getText().toString();

                //TODO: pass all of the data to create a new event
                //TODO: send to parse
                //TODO: if successful, finish activity to add to event
                setResult(RESULT_OK);
                finishActivity(NEW_EVENT_CODE);
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
