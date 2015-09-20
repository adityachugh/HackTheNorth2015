package htn.aka.hackthenorth2015;

import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
<<<<<<< HEAD
 * Created by rohitsharma on 2015-09-19.
=======
 * Created by Kenny on 2015-09-19.
 */
public class Event implements Serializable {
    private String mObjectId;
    private String mTitle;
    private String mSubtitle;
    private String mImageUrl;

    private Date mStartDate;
    private Date mEndDate;

    public Event(ParseObject eventParseObject) {
        try {
            eventParseObject.fetchIfNeeded();
            mObjectId = eventParseObject.getObjectId();
            mTitle = eventParseObject.getString(EventDateSource.EVENT_TITLE_FIELD);
//            mStartDate = eventParseObject.getDate(EventDateSource.EVENT_START_DATE);
            mStartDate = new Date();
            mEndDate = new Date();
//            mEndDate = (Date)eventParseObject.get(EventDateSource.EVENT_END_DATE);
            mImageUrl = eventParseObject.getParseFile(EventDateSource.EVENT_IMAGE).getUrl();
//            mSubtitle = getSubtitleOfEvent(mStartDate, mEndDate);
            mSubtitle = "";
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Event(JSONObject event) throws JSONException {
        mObjectId = event.getString("objectId");
        mTitle = event.getString("name");
        mSubtitle = "test data";
        mImageUrl = event.getJSONObject("image").optJSONObject("data").optString("url"); //guessing if this will work
        if (mImageUrl != null){
            Log.d("the d", mImageUrl);
        }
        mStartDate = (Date)event.get("startDate");
        mEndDate = (Date)event.get("endDate");
    }

    public Event(String title, String subtitle, Date start, Date end, String imageUrl){
        mObjectId = "";
        mTitle = title;
        mSubtitle = subtitle;
        mStartDate = start;
        mEndDate = end;
        mImageUrl = imageUrl;
    }

    private String getSubtitleOfEvent(Date start, Date end) {
        //TODO: format strings
        return "test to test";
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSubtitle() {
        return mSubtitle;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    public String getLocation() {
        return "Fake Location";
    }

}
