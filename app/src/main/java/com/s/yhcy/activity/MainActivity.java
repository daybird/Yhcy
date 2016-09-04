package com.s.yhcy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.s.yhcy.R;

public class MainActivity extends MyAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button gsxdBt = (Button) this.findViewById(R.id.gsxdBt);
        Button excelInputBt =(Button)this.findViewById(R.id.excelInputBt);
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
                startActivityForResult(intent,1);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data==null){
            Toast.makeText(this,"没有接收到数据！",Toast.LENGTH_SHORT).show();
        }
        Bundle bundle = data.getExtras();
        String result = bundle.getParcelable("data");
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();

    }
}
