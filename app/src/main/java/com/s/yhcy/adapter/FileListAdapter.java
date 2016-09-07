package com.s.yhcy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static android.graphics.Color.*;

public class FileListAdapter extends BaseAdapter {
    private Context context;
    private File path;
    private List<File> fileList;

    public FileListAdapter(Context context) {
        this.context = context;
        path = new File("/");
        fileList = Arrays.asList(path.listFiles());
    }


    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
        fileList = Arrays.asList(path.listFiles());
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
        //FIXME 部分文件夹点击后界面crash。
        TextView fileView = new TextView(context);
        File file = fileList.get(position);
        fileView.setText(fileList.get(position).getName());
        if (file.isDirectory())
            fileView.setTextColor(BLUE);
        return fileView;
    }
}
