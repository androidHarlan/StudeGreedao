package com.harlan.lhc.studegreedao.help;

import com.harlan.lhc.studegreedao.ManyToMany.StudentBean;
import com.harlan.lhc.studegreedao.ManyToMany.TeacherBean;
import com.harlan.lhc.studegreedao.gen.StudentBeanDao;
import com.harlan.lhc.studegreedao.gen.TeacherBeanDao;
import com.harlan.lhc.studegreedao.gen.TeacherJoinStudentBeanDao;

import java.util.List;

/**
 * Created by a1 on 2017/11/8.
 */
public class TeacherAndStudentHelp {
    /**
     * 添加数据
     *
     * @param
     */
    public static void insertStudentBean(StudentBean studentBean) {
        DaoManager.getInstance().getDaoSession().getStudentBeanDao().insert(studentBean);
    }

    public static void insert(TeacherBean teacherBean) {
        DaoManager.getInstance().getDaoSession().getTeacherBeanDao().insert(teacherBean);
    }

    /**
     * 添加数据
     *
     * @param
     */
    public static void insertTeacherBeanList(List<TeacherBean> teacherBeans) {
        DaoManager.getInstance().getDaoSession().getTeacherBeanDao().insertInTx(teacherBeans);
    }

    /**
     * 添加数据
     *
     * @param
     */
    public static void insertStudentBeanList(List<StudentBean> studentBeans) {
        DaoManager.getInstance().getDaoSession().getStudentBeanDao().insertInTx(studentBeans);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public static void deleteeacherBean(long id) {
        DaoManager.getInstance().getDaoSession().getTeacherBeanDao().deleteByKey(id);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public static void deleteStudentBean(long id) {
        DaoManager.getInstance().getDaoSession().getStudentBeanDao().deleteByKey(id);
    }

    /**
     * 删除数据
     *
     * @param
     */
    public static void deleteteeacherBeanall() {
        DaoManager.getInstance().getDaoSession().getTeacherBeanDao().deleteAll();
    }

    /**
     * 删除数据
     *
     * @param
     */
    public static void deleteStudentBeanall() {
        DaoManager.getInstance().getDaoSession().getStudentBeanDao().deleteAll();
    }

    /**
     * 更新数据
     *
     * @param
     */
    public static void updateStudentBean(StudentBean studentBean) {
        DaoManager.getInstance().getDaoSession().getStudentBeanDao().update(studentBean);
    }

    /**
     * 更新数据
     *
     * @param
     */
    public static void updateteeacherBean(TeacherBean teacherBean) {
        DaoManager.getInstance().getDaoSession().getTeacherBeanDao().update(teacherBean);
    }

    public static TeacherBeanDao teacherBeanDao() {
        return DaoManager.getInstance().getDaoSession().getTeacherBeanDao();
    }

    public static StudentBeanDao studentBeanDao() {
        return DaoManager.getInstance().getDaoSession().getStudentBeanDao();
    }
    public static TeacherJoinStudentBeanDao teacherJoinStudentBeanDao() {
        return DaoManager.getInstance().getDaoSession().getTeacherJoinStudentBeanDao();
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
    public static List<TeacherBean> queryteacherBeanAll() {

        return DaoManager.getInstance().getDaoSession().getTeacherBeanDao().queryBuilder().list();
    }

    public static List<StudentBean> querystudentBeanAll() {
        return DaoManager.getInstance().getDaoSession().getStudentBeanDao().queryBuilder().list();
    }

}
