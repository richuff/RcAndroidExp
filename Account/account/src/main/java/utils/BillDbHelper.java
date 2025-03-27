package utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import Entity.BillInfo;

public class BillDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "user.db";
    private static final int DB_VSERSION = 1;

    private static final String TABLE_NAME = "bill_info";
    public static BillDbHelper mhelper = null;
    private SQLiteDatabase mRdb = null;

    private SQLiteDatabase mWdb = null;
    private BillDbHelper(Context context){
        super(context,DB_NAME,null,DB_VSERSION);
    }

    //利用单例模式获取数据库帮助器的唯一实例
    public static BillDbHelper getInstance(Context context){
        if (mhelper == null){
            mhelper = new BillDbHelper(context);
        }
        return mhelper;
    }
    //打开数据库的读连接
    public SQLiteDatabase openReadLink(){
        if (mRdb == null || mRdb.isOpen()){
            mRdb = mhelper.getReadableDatabase();
        }
        return mRdb;
    }
    //打开数据库的写连接
    public SQLiteDatabase openWriteLink(){
        if (mWdb == null || mWdb.isOpen()){
            mWdb = mhelper.getWritableDatabase();
        }
        return mWdb;
    }
    //关闭数据库
    public  void closeLink(){
        if (mRdb != null && mRdb.isOpen()){
            mRdb.close();
            mRdb = null;
        }
        if (mWdb != null && mWdb.isOpen()){
            mWdb.close();
            mWdb = null;
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists "+TABLE_NAME+
                "(_id integer primary key autoincrement not null,"+
                "date varchar not null,"+
                "type integer not null,"+
                "amount double not null,"+
                "remark varchar not null);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //保存一条数据
    public long insertInfo(BillInfo info){
        ContentValues cv = new ContentValues();
        cv.put("date",info.getDate());
        cv.put("type",info.getType());
        cv.put("amount",info.getAmount());
        cv.put("remark",info.getRemark());
        return mWdb.insert(TABLE_NAME,null,cv);
    }
}
