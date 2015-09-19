package htn.aka.hackthenorth2015;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

/**
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
    private List<Event> mEvents;


    @Override
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

    public EventsAdapter(Context context, List<Event> events) {
        //save the mPosts private field as what is passed in
        mContext = context;
        mEvents = events;
    }

    @Override
    public void onViewDetachedFromWindow(ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
    }
}

