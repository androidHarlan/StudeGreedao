package com.harlan.lhc.studegreedao.help;

import com.harlan.lhc.studegreedao.BaseApplication;
import com.harlan.lhc.studegreedao.bean.User;

import java.util.List;

/**
 * Created by a1 on 2017/11/8.
 */
public class UserHelp {

    /**
     * 添加数据
     *
     * @param
     */
    public static void insert(User user) {
        BaseApplication.getDaoInstant().getUserDao().insert(user);
    }
    /**
     * 添加数据
     *
     * @param
     */
    public static void insertList(List<User> users) {
        BaseApplication.getDaoInstant().getUserDao().insertInTx(users);
    }
    /**
     * 删除数据
     *
     * @param id
     */
    public static void delete(long id) {
        BaseApplication.getDaoInstant().getUserDao().deleteByKey(id);
    }

    /**
     * 更新数据
     *
     * @param shop
     */
    public static void update(User shop) {
        BaseApplication.getDaoInstant().getUserDao().update(shop);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
    public static List<User> queryAll() {
        return BaseApplication.getDaoInstant().getUserDao().queryBuilder().list();
    }
}
