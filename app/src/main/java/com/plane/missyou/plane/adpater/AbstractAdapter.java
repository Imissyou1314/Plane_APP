package com.plane.missyou.plane.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by MissC on 2017/5/9.
 */

public abstract class AbstractAdapter<T> extends BaseAdapter {
    protected Context context;

    protected List<T> listData;

    protected LayoutInflater layoutInflater;

    public AbstractAdapter(Context context, List<T> listData){
        this.context = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData==null ? 0:listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData==null ? null:listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<T> getListData() {
        return listData;
    }

    public void setListData(List<T> listData) {
        this.listData = listData;
    }


    public View inflate(int layoutId){
        return layoutInflater.inflate(layoutId, null);
    }
}
