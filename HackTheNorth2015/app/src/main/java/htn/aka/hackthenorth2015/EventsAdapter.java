package htn.aka.hackthenorth2015;

<<<<<<< HEAD
import android.content.Context;
import android.content.Intent;
=======
import android.support.v7.widget.RecyclerView;

import android.content.Context;
>>>>>>> new-event-real
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
<<<<<<< HEAD
import android.widget.RelativeLayout;
=======
import android.widget.LinearLayout;
>>>>>>> new-event-real
import android.widget.TextView;

import com.squareup.picasso.Picasso;

<<<<<<< HEAD
=======
import org.w3c.dom.Text;

>>>>>>> new-event-real
import java.io.Serializable;
import java.util.List;

/**
<<<<<<< HEAD
 * Created by akshaypall on 2015-09-19.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder>{
    public class ViewHolder extends RecyclerView.ViewHolder {

        private final RelativeLayout mLayout;
        private final TextView mTitle;
        private final TextView mSubtitle;
        private final ImageView mImage;

        public ViewHolder(View itemView) {
            super(itemView);
            //getting all the elements part of the card, aside from the image
            mLayout = (RelativeLayout)itemView.findViewById(R.id.event_list_item_overall_click);
            mTitle = (TextView) itemView.findViewById(R.id.event_title);
            mSubtitle = (TextView) itemView.findViewById(R.id.event_subtitle);
            mImage = (ImageView) itemView.findViewById(R.id.event_image);
        }
    }

    private Context mContext;
=======
 * + * Created by rohitsharma on 2015-09-19.
 * +
 */


public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> implements Serializable {


    public class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView mTitle;

        private final TextView mSubtitle;

        private final ImageView mImage;


        public ViewHolder(View itemView) {
            super(itemView);
            //getting all the elements part of the card, aside from the image
            mTitle = (TextView) itemView.findViewById(R.id.event_title);
            mSubtitle = (TextView) itemView.findViewById(R.id.event_subtitle);
            mImage = (ImageView) itemView.findViewById(R.id.event_image);

        }


    }


    private Context mContext;

>>>>>>> new-event-real
    private List<Event> mEvents;


    @Override
<<<<<<< HEAD
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final Event event = mEvents.get(i);
        viewHolder.mTitle.setText(event.getTitle());
        viewHolder.mSubtitle.setText(event.getSubtitle());
        if (event.getImageUrl() != null && !event.getImageUrl().equals("")) {
            Picasso.with(mContext).load(event.getImageUrl()).resizeDimen(500, 100).skipMemoryCache().centerCrop().into(viewHolder.mImage);
        }

        viewHolder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //move to ViewEventActivity
                Intent i = new Intent(mContext, ViewEventActivity.class);
                i.putExtra(ViewEventActivity.EXTRA_EVENT, event);
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

=======


    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_list_item, viewGroup, false);
        return new ViewHolder(v);

    }


    @Override


    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Event event = mEvents.get(i);
        viewHolder.mTitle.setText(event.getTitle());
        viewHolder.mSubtitle.setText(event.getSubtitle());
        if (event.getImageUrl() != null && !event.getImageUrl().equals("")){
            Picasso.with(mContext).load(event.getImageUrl()).centerCrop().skipMemoryCache().into(viewHolder.mImage);

        }

    }


    @Override


    public int getItemCount() {
        return mEvents.size();

    }


>>>>>>> new-event-real
    public EventsAdapter(Context context, List<Event> events) {
        //save the mPosts private field as what is passed in
        mContext = context;
        mEvents = events;
<<<<<<< HEAD
    }

    @Override
    public void onViewDetachedFromWindow(ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }
}

=======

    }


    @Override


    public void onViewDetachedFromWindow(ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);

    }


}
>>>>>>> new-event-real
