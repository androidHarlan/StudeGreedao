package com.harlan.lhc.studegreedao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.harlan.lhc.studegreedao.dbupdate.MySqlLiteOpenHelper;
import com.harlan.lhc.studegreedao.gen.DaoMaster;
import com.harlan.lhc.studegreedao.gen.DaoSession;
import com.harlan.lhc.studegreedao.help.DaoManager;

/**
 * Created by a1 on 2017/11/8.
 */
public class BaseApplication extends Application {
    //创建数据库的名字
    private static final String DB_NAME = "harlan.db";

 //   private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static MySqlLiteOpenHelper mHelper;
    public static BaseApplication instances;
    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        setDatabase();
        DaoManager.getInstance().init(this);

    }
    public static BaseApplication getInstances(){
        return instances;
    }

    /**
     * 设置greenDao
     */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new MySqlLiteOpenHelper(this, DB_NAME, null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }
    public DaoSession getDaoSession() {
        return mDaoSession;
    }
    public SQLiteDatabase getDb() {
        return db;
    }
    public void closeHelper()
    {
        if(mHelper != null)
        {
            mHelper.close();
            mHelper = null;
        }
    }

}