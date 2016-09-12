package com.s.yhcy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.s.yhcy.R;
import com.s.yhcy.sql.GsxdDBHelper;


public class MenuActivity extends MyAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        final Button gsxdBt = (Button) this.findViewById(R.id.gsxdBt);
        Button excelInputBt = (Button) this.findViewById(R.id.excelInputBt);
        Button clearBt = (Button) this.findViewById(R.id.clearBt);
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
        clearBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = new GsxdDBHelper(MenuActivity.this, GsxdDBHelper.DBFILE, null, 1).deleteAll();
                Toast.makeText(MenuActivity.this, "清除了" + result + "条数据", Toast.LENGTH_SHORT).show();
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
