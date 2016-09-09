package com.s.yhcy.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

import static android.graphics.Color.*;

public class FileListAdapter extends BaseAdapter implements FileFilter {
    private Context context;
    private File path;
    private List<File> fileList;

    public FileListAdapter(Context context, File path) {
        this.context = context;
        this.path = path;
        fileList = Arrays.asList(path.listFiles(this));
    }


    public void setPath(File path) {
        this.path = path;
        fileList = Arrays.asList(path.listFiles(this));
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return fileList.size();
    }

    @Override
    public Object getItem(int position) {
        return fileList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView fileView = new TextView(context);
        File file = fileList.get(position);
        fileView.setText(fileList.get(position).getName());
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.MATCH_PARENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
        params.setMargins(5, 10, 5, 10);
        fileView.setLayoutParams(params);
        fileView.setTextSize(20);
        if (file.isDirectory())
            fileView.setTextColor(BLUE);
        else fileView.setTextColor(Color.BLACK);
        return fileView;
    }

    @Override
    public boolean accept(File file) {
        if (file == null || !file.exists() || !file.canRead() || (!file.isDirectory() && !file.getName().toUpperCase().endsWith(".XLS"))) {
            return false;
        } else {
            return true;
        }
    }
}
