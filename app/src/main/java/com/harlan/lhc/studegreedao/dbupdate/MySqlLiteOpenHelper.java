package com.harlan.lhc.studegreedao.dbupdate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.harlan.lhc.studegreedao.gen.DaoMaster;
import com.harlan.lhc.studegreedao.gen.StudentDao;
import com.harlan.lhc.studegreedao.gen.UserDao;

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
        if (oldVersion < newVersion)
        {
            Log.e("backinfo","要更新数据库了");
            MigrationHelper.getInstance().migrate(db, StudentDao.class,UserDao.class);

        }
    }
}