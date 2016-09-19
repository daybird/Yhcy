package com.s.yhcy.activity;

import android.Manifest;
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
import com.s.yhcy.sql.GsxdDBHelper;
import com.s.yhcy.util.ExcelUtil;
import com.s.yhcy.util.PermissionsUtil;

import java.io.File;
import java.util.List;

public class FileChooseActivity extends AppCompatActivity {

    private static final String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PermissionsUtil.checkAndRequestPermissions(this, permissions);
        setContentView(R.layout.activity_file_choose);
        ListView listView = (ListView) this.findViewById(R.id.filelistView);
        final Spinner spinner = (Spinner) this.findViewById(R.id.folderspinner);
        final FileSpinnerAdapter spinnerAdapter = new FileSpinnerAdapter(this);
        final FileListAdapter fileListAdapter = new FileListAdapter(this, new File("/"));
        spinner.setAdapter(spinnerAdapter);
        spinner.setSelection(0);
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
                    for (int i = 0; i < spinnerAdapter.getCount(); i++) {
                        if (spinnerAdapter.getItem(i).equals(file)) {
                            spinner.setSelection(i);
                            return;
                        }
                    }
                    spinnerAdapter.addItem(file);
                    spinnerAdapter.notifyDataSetChanged();
                    spinner.setSelection(spinnerAdapter.getCount() - 1);
                } else {
                    List<Gsxd> gsxdList = ExcelUtil.getGsxdListFromExcel(file);
                    GsxdDBHelper dbHelper = new GsxdDBHelper(FileChooseActivity.this, GsxdDBHelper.DBFILE, null, 1);
                    long result = dbHelper.insertGsxdList(gsxdList);
                    if (result == gsxdList.size()) {
                        Toast.makeText(FileChooseActivity.this, "导入成功!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(FileChooseActivity.this, "导入成功：" + result + "条； 失败：" + (gsxdList.size() - result) + "条。", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

}
