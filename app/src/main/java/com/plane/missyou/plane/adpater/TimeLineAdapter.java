package com.plane.missyou.plane.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.plane.missyou.plane.R;
import com.plane.missyou.plane.adpater.holder.TimeLineViewHolder;
import com.plane.missyou.plane.entity.Message;
import com.plane.missyou.plane.utils.DataGenerator;

import java.util.List;

/**
 * Created by MissC on 2017/5/11.
 */

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineViewHolder> {

    private List<Message> messageList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public TimeLineAdapter(List<Message> messages) {
        this.messageList = messages;
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        mLayoutInflater = LayoutInflater.from(mContext);
        View view = mLayoutInflater.inflate(R.layout.item_timeline_line_padding, parent, false);

        return new TimeLineViewHolder(view,viewType);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {
        Message message = messageList.get(position);

        if (message.getRead()) {
            holder.mTimelineView.setMarker(DataGenerator
                    .getDrawable(mContext, R.drawable.ic_marker_inactive, android.R.color.darker_gray));
        } else {
            holder.mTimelineView.setMarker(DataGenerator
                    .getDrawable(mContext, R.drawable.ic_marker_active, R.color.colorPrimary));
        }

        if (message.getSendTime() == null) {
            holder.mTimeLineData.setVisibility(View.GONE);
        } else {
            holder.mTimeLineData.setVisibility(View.VISIBLE);
            holder.mTimeLineData.setText(message.getSendTime().toString());
        }

        holder.mTimeLineContext.setText(message.getContext());
    }

    @Override
    public int getItemCount() {
        return (messageList != null ? messageList.size() : 0 );
    }
}
