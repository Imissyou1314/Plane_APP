package com.plane.missyou.plane.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.plane.missyou.plane.R;
import com.plane.missyou.plane.adpater.TimeLineAdapter;
import com.plane.missyou.plane.base.BaseFragment;
import com.plane.missyou.plane.entity.EventMessage;
import com.plane.missyou.plane.entity.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

/**
 * Created by MissC on 2017/5/11.
 */

public class TimeLineFragment extends BaseFragment{

    @BindView(R.id.time_line_list)
    RecyclerView mTimelineRecyclerView;

    private TimeLineAdapter mTimeLineAdapter;
    private List<Message> messages = new ArrayList<Message>();;

    @Override
    public void initUI() {
        mTimelineRecyclerView.setLayoutManager( new LinearLayoutManager(getContext()));
        mTimelineRecyclerView.setHasFixedSize(true);
        mTimeLineAdapter = new TimeLineAdapter(messages);
        mTimelineRecyclerView.setAdapter(mTimeLineAdapter);
    }

    @Override
    public void initData() {
        Message message;
        for (int i = 10; i > 0; i--) {
            message = new Message();
            message.setContext("测试" + i);
            message.setSendTime(new Date());
            message.setRead(i % 2 == 0);
            messages.add(message);
        }

        mTimeLineAdapter.notifyDataSetChanged();
    }

    @Override
    public void addListeners() {

    }

    @Override
    public void onEventMessage(EventMessage em) {

    }

    @Override
    public int inflaterRootView() {
        return R.layout.time_line_fragment;
    }

    public static TimeLineFragment newInstance() {
        return new TimeLineFragment();
    }
}
