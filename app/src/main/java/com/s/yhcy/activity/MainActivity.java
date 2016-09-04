package com.s.yhcy.activity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.s.yhcy.R;
import com.s.yhcy.entity.Gsxd;
import com.s.yhcy.util.ExcelUtil;

import java.io.File;
import java.util.List;

public class MainActivity extends MyAppCompatActivity {

    private static final int FILE_SELECT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button gsxdBt = (Button) this.findViewById(R.id.gsxdBt);
        Button excelInputBt = (Button) this.findViewById(R.id.excelInputBt);
        gsxdBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGsxdActivity();
            }
        });
        excelInputBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, FILE_SELECT_CODE);
            }
        });
    }

    /**
     * 显示公司信贷页面
     */
    private void showGsxdActivity() {
        Intent intent = new Intent();
        intent.setClass(this, GsxdActivity.class);
        this.startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            Toast.makeText(this, R.string.noData, Toast.LENGTH_SHORT).show();
        }
        switch (requestCode) {
            case FILE_SELECT_CODE:
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    File file = getFileFromURI(uri);
                    List<Gsxd> gsxdList = ExcelUtil.getGsxdListFromExcel(file);
                    Toast.makeText(this, gsxdList.size(), Toast.LENGTH_SHORT).show();
                } else if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(this, R.string.cancelChoice, Toast.LENGTH_SHORT).show();
                }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private File getFileFromURI(Uri uri) {
        //TODO 需从URI解析文件路径
        File file = new File(uri.getPath());
        return file;
    }
}
