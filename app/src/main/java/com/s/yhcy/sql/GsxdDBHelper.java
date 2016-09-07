package com.s.yhcy.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.s.yhcy.R;
import com.s.yhcy.entity.Gsxd;

/**
 * 数据库操作类
 * Created by KJB3 on 2016/9/7.
 */
public class GsxdDBHelper extends SQLiteOpenHelper {
    private Context context;

    public GsxdDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String gsxd_table = context.getResources().getString(R.string.CREATE_TABLE_GSXD);
        db.execSQL(gsxd_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(context.getResources().getString(R.string.UPDATE_TABLE_GSXD));
        onCreate(db);
    }


    public boolean insertGsxd(Gsxd gsxd) {
        //TODO 插入数据
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("zhang_t",gsxd.getZhang().getTitle());
        values.put("zhang_c",gsxd.getZhang().getContent());
        db.insert("GSXD","ID",values);
        return true;
    }
}
