package com.s.yhcy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

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
        spinner.setAdapter(new FileSpinnerAdapter(this));
        final FileListAdapter fileListAdapter = new FileListAdapter(this);
        listView.setAdapter(fileListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                File file = (File) parent.getItemAtPosition(position);
                if (file.isDirectory()) {
                    fileListAdapter.setPath(file);
                } else {
                    List<Gsxd> gsxdList = ExcelUtil.getGsxdListFromExcel(file);
                    Toast.makeText(FileChooseActivity.this, gsxdList.size(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
