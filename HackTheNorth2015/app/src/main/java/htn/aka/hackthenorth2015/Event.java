package htn.aka.hackthenorth2015;

import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by rohitsharma on 2015-09-19.
 */
public class Event {
    private String mTitle;
    private String mSubtitle;
    private String mImageUrl;

    private Date mStartDate;
    private Date mEndDate;

    public Event(ParseObject eventParseObject) {
        mTitle = eventParseObject.getString(EventDateSource.EVENT_TITLE_FIELD);
        mStartDate = eventParseObject.getDate(EventDateSource.EVENT_START_DATE);
        mEndDate = eventParseObject.getDate(EventDateSource.EVENT_END_DATE);
        mImageUrl = eventParseObject.getParseFile(EventDateSource.EVENT_IMAGE).getUrl();
        mSubtitle = getSubtitleOfEvent(mStartDate, mEndDate);
    }

    public Event(String title, String subtitle, Date start, Date end, String imageUrl){
        mTitle = title;
        mSubtitle = subtitle;
        mStartDate = start;
        mEndDate = end;
        mImageUrl = imageUrl;
    }

    private String getSubtitleOfEvent(Date start, Date end) {
        //TODO: formatstrings
        return start.getHours()+" to "+end.getHours();
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
}
