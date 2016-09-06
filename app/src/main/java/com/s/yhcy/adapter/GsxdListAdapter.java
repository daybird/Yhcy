package com.s.yhcy.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.s.yhcy.entity.Gsxd;

import java.util.List;

//TODO 未完成自动更新视图功能
public class GsxdListAdapter extends BaseAdapter {
    private Context context;
    private List<Gsxd> list;

    public GsxdListAdapter(Context context, List<Gsxd> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        TextView titleView = new TextView(context);
        titleView.setText(list.get(position).getNeiRong().getTitle());
        titleView.setTextColor(Color.CYAN);
        TextView contentView = new TextView(context);
        contentView.setText(list.get(position).getNeiRong().getContent());
        layout.addView(titleView);
        layout.addView(contentView);
        return layout;
    }
}
