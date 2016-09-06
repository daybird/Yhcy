package com.s.yhcy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.s.yhcy.R;


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
                showFileChooseActivity();

            }
        });
    }

    /**
     * 显示文件选择界面
     */
    private void showFileChooseActivity() {
        Intent intent = new Intent();
        intent.setClass(this, FileChooseActivity.class);
        this.startActivity(intent);
    }
    /**
     * 显示公司信贷界面
     */
    private void showGsxdActivity() {
        Intent intent = new Intent();
        intent.setClass(this, GsxdActivity.class);
        this.startActivity(intent);
    }

}
