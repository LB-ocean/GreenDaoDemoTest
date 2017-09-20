package com.example.greendaodemotest.util;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendaodemotest.db.DaoMaster;
import com.example.greendaodemotest.db.StudentDao;
import com.example.greendaodemotest.db.TeacherDao;

import org.greenrobot.greendao.database.Database;


/**
 * Created by zhangqie on 2016/3/26.
 */

public class MySqlLiteOpenHelper extends DaoMaster.OpenHelper{

    public MySqlLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory)
    {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion)
    {
        super.onUpgrade(db, oldVersion, newVersion);
        MyLog.e("MySqlLiteOpenHelper---version:"+oldVersion + "---先前和更新之后的版本---" + newVersion);
        if (oldVersion < newVersion)
        {
            MigrationHelper.getInstance().migrate(db, StudentDao.class, TeacherDao.class);
            MyLog.e("MySqlLiteOpenHelper-----更新完成");
        }
    }
}
