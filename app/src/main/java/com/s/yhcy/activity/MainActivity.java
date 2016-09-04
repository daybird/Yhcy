package com.s.yhcy.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.s.yhcy.R;

public class MainActivity extends MyAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button gsxdBt = (Button) this.findViewById(R.id.gsxdBt);
        gsxdBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGsxdActivity();
            }
        });
    }

    /**
     * 显示公司信贷页面
     */
    private void showGsxdActivity() {
        Intent intent = new Intent();
        intent.setClass(this,GsxdActivity.class);
        this.startActivity(intent);
    }
}
