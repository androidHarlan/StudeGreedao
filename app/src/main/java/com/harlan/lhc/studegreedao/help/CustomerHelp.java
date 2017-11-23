package com.harlan.lhc.studegreedao.help;

import com.harlan.lhc.studegreedao.OneToMany.Customer;
import com.harlan.lhc.studegreedao.OneToMany.Order;
import com.harlan.lhc.studegreedao.gen.StudentDao;

import java.util.List;

/**
 * Created by a1 on 2017/11/8.
 */
public class CustomerHelp {
    /**
     * 添加数据
     *
     * @param
     */
    public static void insert(Customer customer) {
        DaoManager.getInstance().getDaoSession().getCustomerDao().insert(customer);
    }
    public static void insert(Order orders) {
        DaoManager.getInstance().getDaoSession().getOrderDao().insert(orders);
    }
    /**
     * 添加数据
     *
     * @param
     */
    public static void insertList(List<Customer> customers) {
        DaoManager.getInstance().getDaoSession().getCustomerDao().insertInTx(customers);
    }
    /**
     * 删除数据
     *
     * @param id
     */
    public static void delete(long id) {
        DaoManager.getInstance().getDaoSession().getCustomerDao().deleteByKey(id);
    }
    /**
     * 删除数据
     *
     * @param
     */
    public static void deleteall() {
        DaoManager.getInstance().getDaoSession().getCustomerDao().deleteAll();
    }
    /**
     * 更新数据
     *
     * @param
     */
    public static void update(Customer customer) {
        DaoManager.getInstance().getDaoSession().getCustomerDao().update(customer);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
    public static List<Customer> queryAll() {

        return DaoManager.getInstance().getDaoSession().getCustomerDao().queryBuilder().list();
    }
    public static List<Order> queryOrderAll() {
        return DaoManager.getInstance().getDaoSession().getOrderDao().queryBuilder().list();
    }
    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *  List<Student> list = msgBeanDao.queryBuilder()
     .offset(1)//偏移量，相当于 SQL 语句中的 skip
     .limit(3)//只获取结果集的前 3 个数据
     .orderAsc(StudentMsgBeanDao.Properties.StudentNum)//通过 StudentNum 这个属性进行正序排序
     .where(StudentMsgBeanDao.Properties.Name.eq("zone"))//数据筛选，只获取 Name = "zone" 的数据。
     .build()
     .list();
     * @return
     */
    public static List<Customer> queryAll(String name) {
        return DaoManager.getInstance().getDaoSession().getCustomerDao().queryBuilder().where(StudentDao.Properties.Name.eq(name)).list();
    }

    /**
     * @param offset
     * @return
     * 分页加载20条数据，getTwentyRec(int offset)中控制页数offset++即可
     */
    public static List<Customer> getTwentyRec(int offset) {
        return DaoManager.getInstance().getDaoSession().getCustomerDao().queryBuilder().offset(offset*20).limit(20).list();
    }
}
