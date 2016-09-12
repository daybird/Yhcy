package com.s.yhcy.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.s.yhcy.entity.Gsxd;

import java.util.List;

public class GsxdListAdapter extends BaseAdapter {
    private Context context;
    private List<Gsxd> list;
    private String searchText;

    public GsxdListAdapter(Context context, List<Gsxd> list) {
        this.context = context;
        this.list = list;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
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
        contentView.setText(this.getSpannableStringBuilder(searchText, list.get(position).getNeiRong().getContent()));
        layout.addView(titleView);
        layout.addView(contentView);
        return layout;
    }

    private SpannableStringBuilder getSpannableStringBuilder(String searchText, String content) {
        SpannableStringBuilder builder = new SpannableStringBuilder(content);
        if (searchText == null || searchText.equals("") || content == null || content.equals("") || !content.contains(searchText))
            return builder;
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.YELLOW);
        int index = content.indexOf(searchText);
        builder.setSpan(colorSpan, index, index + searchText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return builder;
    }

}
