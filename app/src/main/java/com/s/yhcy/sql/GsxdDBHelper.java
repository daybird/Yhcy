package com.s.yhcy.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.s.yhcy.R;
import com.s.yhcy.entity.Gsxd;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库操作类
 * Created by KJB3 on 2016/9/7.
 */
public class GsxdDBHelper extends SQLiteOpenHelper {
    private Context context;

    public static final String TABLE = "GSXD";
    public static final String DBFILE = "GSXD.db";
    public static final String NULLCOLUMNHACK = "id";

    public GsxdDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String gsxd_table = "CREATE TABLE GSXD(" +
                "ID INT PRIMARY KEY NOT NULL," +
                "ZHANG_T TEXT NOT NULL DEFAULT ''," +
                "ZHANG_C TEXT NOT NULL DEFAULT ''," +
                "JIE_T TEXT NOT NULL DEFAULT ''," +
                "JIE_C TEXT NOT NULL DEFAULT ''," +
                "XIAOJIE_T TEXT NOT NULL DEFAULT ''," +
                "XIAOJIE_C TEXT NOT NULL DEFAULT ''," +
                "NEIRONG_T TEXT NOT NULL DEFAULT ''," +
                "NEIRONG_C TEXT NOT NULL DEFAULT '')";
        db.execSQL(gsxd_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(context.getResources().getString(R.string.UPDATE_TABLE_GSXD));
        onCreate(db);
    }


    public long insertGsxd(Gsxd gsxd) {
        //TODO 插入数据
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = buildContentValues(gsxd);
        long result = db.insert(TABLE, NULLCOLUMNHACK, values);
        db.close();
        return result;
    }

    public long insertGsxdList(List<Gsxd> list) {
        SQLiteDatabase db = this.getWritableDatabase();
        long count = 0L;
        List<Long> errorlist = new ArrayList<>();
        for (Gsxd gsxd : list) {
            ContentValues values = buildContentValues(gsxd);
            if (db.insert(TABLE, NULLCOLUMNHACK, values) == 1)
                count++;
        }
        db.close();
        return count;
    }

    private ContentValues buildContentValues(Gsxd gsxd) {
        ContentValues values = new ContentValues();
        values.put("zhang_t", gsxd.getZhang().getTitle());
        values.put("zhang_c", gsxd.getZhang().getContent());
        values.put("jie_t", gsxd.getJie().getTitle());
        values.put("jie_c", gsxd.getJie().getContent());
        values.put("xiaoJie_t", gsxd.getXiaoJie().getTitle());
        values.put("xiaoJie_c", gsxd.getXiaoJie().getContent());
        values.put("neiRong_t", gsxd.getNeiRong().getTitle());
        values.put("neiRong_c", gsxd.getNeiRong().getContent());
        return values;
    }
}
