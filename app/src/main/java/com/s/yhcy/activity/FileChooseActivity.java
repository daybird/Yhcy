package com.s.yhcy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import com.s.yhcy.R;
import com.s.yhcy.adapter.FileListAdapter;
import com.s.yhcy.adapter.FileSpinnerAdapter;
import com.s.yhcy.entity.Gsxd;
import com.s.yhcy.util.ExcelUtil;

import java.io.File;
import java.util.List;

public class FileChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_choose);
        ListView listView = (ListView) this.findViewById(R.id.filelistView);
        Spinner spinner = (Spinner) this.findViewById(R.id.folderspinner);
        final FileSpinnerAdapter spinnerAdapter = new FileSpinnerAdapter(this);
        final FileListAdapter fileListAdapter = new FileListAdapter(this);
        spinner.setAdapter(spinnerAdapter);
        listView.setAdapter(fileListAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                File file = (File) parent.getItemAtPosition(position);
                fileListAdapter.setPath(file);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                File file = (File) parent.getItemAtPosition(position);
                if (file.isDirectory()) {
                    fileListAdapter.setPath(file);
                    spinnerAdapter.addItem(file);
                } else {
                    List<Gsxd> gsxdList = ExcelUtil.getGsxdListFromExcel(file);
                    // TODO 导入数据库
                }
            }
        });
    }

}
