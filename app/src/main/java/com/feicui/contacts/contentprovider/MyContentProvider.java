package com.feicui.contacts.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.feicui.contacts.sqlite.MyOpenHelper;
import com.feicui.contacts.sqlite.TypeEntry;


/**
 * Created by lichao on 16/9/11.
 */

public class MyContentProvider extends ContentProvider {
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI("com.feicui.contacts", TypeEntry.TABLE_NAME, 1);

    }

    private MyOpenHelper mOpenHelper;


    @Override
    public boolean onCreate() {

        mOpenHelper = new MyOpenHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        //获取可读的database对象，通过打开固定路径的方式
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(
                TypeEntry.DATABASE_PATH + "/phone.db", null
        );
        Cursor mCursor = null;

        switch (uriMatcher.match(uri)) {
            case 1:
                //查询数据库,返回一个游标
                mCursor = db.query(TypeEntry.TABLE_NAME, //表名
                        null,
                        null, //WHERE
                        null, //Where args
                        null, //GROUP BY
                        null, //HAVING
                        null //ORDER BY
                );
                break;
        }

        return mCursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        String mType = null;
        switch (uriMatcher.match(uri)) {
            case 1:
                mType = "vnd.android.cursor.dir/com.feicui.contacts.PhoneType";
                break;
        }
        return mType;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        //获取可读的database对象，通过打开固定路径的方式
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(
                TypeEntry.DATABASE_PATH + "/phone.db", null
        );

        switch (uriMatcher.match(uri)) {
            case 1:
                db.insert(TypeEntry.TABLE_NAME, //表名
                        null,
                        values
                );
                db.close();
                break;
        }

        return uri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        //获取可读的database对象，通过打开固定路径的方式
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(
                TypeEntry.DATABASE_PATH + "/phone.db", null
        );
        int i_delete = 0;
        switch (uriMatcher.match(uri)) {
            case 1:
                i_delete =  db.delete(TypeEntry.TABLE_NAME, //表名
                        selection,
                        selectionArgs
                );
                db.close();
                break;
        }
        return i_delete;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        //获取可读的database对象，通过打开固定路径的方式
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(
                TypeEntry.DATABASE_PATH + "/phone.db", null
        );
        int i_update = 0;
        switch (uriMatcher.match(uri)) {
            case 1:
                i_update = db.update(TypeEntry.TABLE_NAME, //表名
                        values,
                        selection,
                        selectionArgs
                );
                db.close();
                break;
        }
        return i_update;
    }
}
