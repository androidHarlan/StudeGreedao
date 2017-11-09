package com.harlan.lhc.studegreedao.help;

import com.harlan.lhc.studegreedao.bean.Student;
import com.harlan.lhc.studegreedao.gen.StudentDao;

import java.util.List;

/**
 * Created by a1 on 2017/11/8.
 */
public class StudentHelp {
    /**
     * 添加数据
     *
     * @param
     */
    public static void insert(Student student) {
        DaoManager.getInstance().getDaoSession().getStudentDao().insert(student);
    }
    /**
     * 添加数据
     *
     * @param
     */
    public static void insertList(List<Student> students) {
        DaoManager.getInstance().getDaoSession().getStudentDao().insertInTx(students);
    }
    /**
     * 删除数据
     *
     * @param id
     */
    public static void delete(long id) {
        DaoManager.getInstance().getDaoSession().getStudentDao().deleteByKey(id);
    }

    /**
     * 更新数据
     *
     * @param
     */
    public static void update(Student student) {
        DaoManager.getInstance().getDaoSession().getStudentDao().update(student);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
    public static List<Student> queryAll() {
        return DaoManager.getInstance().getDaoSession().getStudentDao().queryBuilder().list();
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
    public static List<Student> queryAll(String name) {
        return DaoManager.getInstance().getDaoSession().getStudentDao().queryBuilder().where(StudentDao.Properties.Name.eq(name)).list();
    }
}
