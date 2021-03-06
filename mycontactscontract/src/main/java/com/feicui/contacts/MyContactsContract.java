package com.feicui.contacts;

import android.net.Uri;

/**
 * @description 我的联系人内容提供者协定类
 * Created by lichao on 16/9/13.
 */

public final class MyContactsContract {

    public static final String AUTHORITY = "com.feicui.contacts";

    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    public static final String PHONETYPE = "PhoneType";

    public static final String TYPENAME = "type";

    public static final String ID = "_id";

    public static final Uri PHONETYPE_URI = Uri.withAppendedPath(AUTHORITY_URI, PHONETYPE);

    public static final String DATABASE_PATH = "/data/data/com.feicui.contacts/databases/phone.db";

}
