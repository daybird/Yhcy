package com.s.yhcy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.s.yhcy.activity.FileChooseActivity;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by PawN on 2016/9/7.
 */
public class FileSpinnerAdapter extends BaseAdapter {

    private LinkedList<File> fileQueue;

    private Context context;

    public FileSpinnerAdapter(Context context) {
        this.context = context;
        fileQueue = new LinkedList<>();
        fileQueue.add(new File("/"));
    }

    @Override
    public int getCount() {
        return fileQueue.size();
    }

    @Override
    public Object getItem(int position) {
        return fileQueue.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);
        textView.setText(fileQueue.get(position).getAbsolutePath());
        return textView;
    }
}
