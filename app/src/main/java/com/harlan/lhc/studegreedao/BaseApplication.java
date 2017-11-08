package com.harlan.lhc.studegreedao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.harlan.lhc.studegreedao.gen.DaoMaster;
import com.harlan.lhc.studegreedao.gen.DaoSession;

/**
 * Created by a1 on 2017/11/8.
 */
public class BaseApplication extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        //配置数据库
        setupDatabase();
    }

    /**
     * 配置数据库
     */
    private void setupDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "harlan.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }
}