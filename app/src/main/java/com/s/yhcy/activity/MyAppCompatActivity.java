package com.s.yhcy.activity;

import android.support.v7.app.AppCompatActivity;

/**
 * AppCompatActivity 子类 用于去除actionBar
 * Created by PawN on 2016/9/4.
 */
public class MyAppCompatActivity extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
//        ActionBar supportActionBar = getSupportActionBar();
//        supportActionBar.hide();
    }
}
