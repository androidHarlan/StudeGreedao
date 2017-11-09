package com.harlan.lhc.studegreedao.help;

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
        DaoManager.getInstance().getDaoSession().getUserDao().insert(user);
    }
    /**
     * 添加数据
     *
     * @param
     */
    public static void insertList(List<User> users) {
        DaoManager.getInstance().getDaoSession().getUserDao().insertInTx(users);
    }
    /**
     * 删除数据
     *
     * @param id
     */
    public static void delete(long id) {
        DaoManager.getInstance().getDaoSession().getUserDao().deleteByKey(id);
    }

    /**
     * 更新数据
     *
     * @param shop
     */
    public static void update(User shop) {
        DaoManager.getInstance().getDaoSession().getUserDao().update(shop);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
    public static List<User> queryAll() {
        return DaoManager.getInstance().getDaoSession().getUserDao().queryBuilder().list();
    }
}
