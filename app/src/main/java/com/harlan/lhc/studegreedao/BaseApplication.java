package com.harlan.lhc.studegreedao;

import android.app.Application;
import android.content.Context;

import com.harlan.lhc.studegreedao.help.DaoManager;

/**
 * Created by a1 on 2017/11/8.
 */
public class BaseApplication extends Application {

    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        DaoManager.getInstance().init(this);
    }
    public static Context getContext()
    {
        return context;
    }

}