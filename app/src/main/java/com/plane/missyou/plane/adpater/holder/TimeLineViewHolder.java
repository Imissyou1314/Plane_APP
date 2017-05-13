package com.plane.missyou.plane.adpater.holder;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.vipulasri.timelineview.TimelineView;
import com.plane.missyou.plane.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  为时间轴视图
 * Created by MissC on 2017/5/11.
 */

public class TimeLineViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.time_line_item)
    public TimelineView mTimelineView;
    @BindView(R.id.time_line_item_text_data)
    public AppCompatTextView mTimeLineData;
    @BindView(R.id.time_line_item_text_context)
    public AppCompatTextView mTimeLineContext;

    public TimeLineViewHolder(View itemView, int viewType) {
        super(itemView);

        ButterKnife.bind(this, itemView);
        mTimelineView.initLine(viewType);
    }
}
