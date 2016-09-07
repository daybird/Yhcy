package com.s.yhcy.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.s.yhcy.R;
import com.s.yhcy.entity.Gsxd;
import com.s.yhcy.entity.Item;

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
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
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
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = buildContentValues(gsxd);
        long result = db.insert(TABLE, NULLCOLUMNHACK, values);
        db.close();
        return result;
    }

    public long insertGsxdList(List<Gsxd> list) {
        SQLiteDatabase db = this.getWritableDatabase();
        long count = 0L;
        for (Gsxd gsxd : list) {
            long result = db.insert(TABLE, NULLCOLUMNHACK, buildContentValues(gsxd));
            if (result != -1)
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
        values.put("xiaojie_t", gsxd.getXiaoJie().getTitle());
        values.put("xiaojie_c", gsxd.getXiaoJie().getContent());
        values.put("neirong_t", gsxd.getNeiRong().getTitle());
        values.put("neirong_c", gsxd.getNeiRong().getContent());
        return values;
    }

    public List<Gsxd> queryGsxd() {
        List<Gsxd> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE, null, null, null, null, null, null, null);
        for (cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()) {
            Gsxd gsxd = new Gsxd();
            gsxd.setZhang(new Item(cursor.getString(1), cursor.getString(2)));
            gsxd.setJie(new Item(cursor.getString(3), cursor.getString(4)));
            gsxd.setXiaoJie(new Item(cursor.getString(5), cursor.getString(6)));
            gsxd.setNeiRong(new Item(cursor.getString(7), cursor.getString(8)));
            list.add(gsxd);
        }
        return list;
    }

    public int deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE, null, null);
        db.close();
        return result;
    }
}
