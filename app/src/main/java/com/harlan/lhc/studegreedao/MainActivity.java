package com.harlan.lhc.studegreedao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.harlan.lhc.studegreedao.ManyToMany.StudentBean;
import com.harlan.lhc.studegreedao.ManyToMany.TeacherBean;
import com.harlan.lhc.studegreedao.ManyToMany.TeacherJoinStudentBean;
import com.harlan.lhc.studegreedao.OneToMany.Customer;
import com.harlan.lhc.studegreedao.OneToMany.Order;
import com.harlan.lhc.studegreedao.OneToOne.Student;
import com.harlan.lhc.studegreedao.OneToOne.User;
import com.harlan.lhc.studegreedao.help.CustomerHelp;
import com.harlan.lhc.studegreedao.help.StudentHelp;
import com.harlan.lhc.studegreedao.help.TeacherAndStudentHelp;
import com.harlan.lhc.studegreedao.help.UserHelp;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.username)
    EditText username;
    @Bind(R.id.insertuser)
    Button insertuser;
    @Bind(R.id.selectuser)
    Button selectuser;
    @Bind(R.id.deleteuser)
    Button deleteuser;
    @Bind(R.id.updatauser)
    Button updatauser;
    @Bind(R.id.studentname)
    EditText studentname;
    @Bind(R.id.studentsex)
    EditText studentsex;
    @Bind(R.id.studentaddress)
    EditText studentaddress;
    @Bind(R.id.studentage)
    EditText studentage;
    @Bind(R.id.studentinsert)
    Button studentinsert;
    @Bind(R.id.studentselect)
    Button studentselect;
    @Bind(R.id.studentdelete)
    Button studentdelete;
    @Bind(R.id.studentupdata)
    Button studentupdata;
    @Bind(R.id.result)
    TextView result;
    Gson gon = new Gson();
    @Bind(R.id.updatadb)
    Button updatadb;
    @Bind(R.id.customername)
    EditText customername;
    @Bind(R.id.ordername)
    EditText ordername;
    @Bind(R.id.insertorder)
    Button insertorder;
    @Bind(R.id.selectorder)
    Button selectorder;
    @Bind(R.id.deleteorder)
    Button deleteorder;
    @Bind(R.id.updataorder)
    Button updataorder;
    @Bind(R.id.manytomany)
    Button manytomany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CustomerHelp.deleteall();
        Log.e("backinfo", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @OnClick({R.id.updatadb, R.id.insertuser, R.id.selectuser, R.id.deleteuser, R.id.updatauser, R.id.studentinsert, R.id.studentselect, R.id.studentdelete, R.id.studentupdata})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.insertuser:
                if (username.getText().toString().equals("") || username.getText().toString().equals(null)) {
                    Toast.makeText(MainActivity.this, "请输入用户名", Toast.LENGTH_LONG).show();
                } else {
                    User user = new User();
                    user.setName(username.getText().toString());
                    user.setAge("bbbb");
                    Student student = new Student();
                    student.setName(studentname.getText().toString());
                    student.setAddress(studentaddress.getText().toString());
                    student.setSex(studentsex.getText().toString());
                    student.setAge(studentage.getText().toString());
                    user.setStudent(student);
                    UserHelp.insert(user);
                }
                break;
            case R.id.selectuser:
                result.setText(gon.toJson(UserHelp.queryAll()));
                break;
            case R.id.deleteuser:
                UserHelp.delete(1);
                break;

            case R.id.updatauser:
                break;
            case R.id.updatadb:

                break;
            case R.id.studentinsert:
                if (studentname.getText().toString().equals("") || studentname.getText().toString().equals(null)) {
                    Toast.makeText(MainActivity.this, "请输入用户名", Toast.LENGTH_LONG).show();
                } else {
                    Student student = new Student();
                    student.setName(studentname.getText().toString());
                    student.setAddress(studentaddress.getText().toString());
                    student.setSex(studentsex.getText().toString());
                    student.setAge(studentage.getText().toString());
                    StudentHelp.insert(student);
                }
                break;
            case R.id.studentselect:
                result.setText(gon.toJson(StudentHelp.queryAll()));
                break;
            case R.id.studentdelete:
                break;
            case R.id.studentupdata:
                break;
        }
    }

    @OnClick({R.id.manytomany,R.id.insertorder, R.id.selectorder, R.id.deleteorder, R.id.updataorder})
    public void oncustomerClicked(View view) {
        switch (view.getId()) {
            case R.id.insertorder:
                if (customername.getText().toString().trim().length() > 0 && ordername.getText().toString().trim().length() > 0) {
                    for (int i = 0; i < 2; i++) {
                        Customer customer = new Customer();

                        customer.setName(customername.getText().toString().trim() + i);
                        CustomerHelp.insert(customer);

                    }
                    List<Customer> customers = CustomerHelp.queryAll();

                    for (int j = 0; j < customers.size(); j++) {
                        Log.e("backinfo", "顾客id:" + customers.get(j).getId());
                        Order order = new Order();
                        order.setCustomerId(customers.get(j).getId());
                        order.setName(ordername.getText().toString().trim());
                        CustomerHelp.insert(order);
                    }

                } else {
                    Toast.makeText(MainActivity.this, "请输入顾客名或订单名称", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.selectorder:
                result.setText(gon.toJson(CustomerHelp.queryOrderAll()));
                break;
            case R.id.deleteorder:

                break;
            case R.id.manytomany:
                //2个教师和3个学生的关系
//教师1，带学生1、2
//教师2，带学生1、3
//学生1，选修教师1和教师2的课

                List<TeacherBean> teacherList = new ArrayList<TeacherBean>();
                for (long i = 1; i < 3; i++) {
                    TeacherBean teacherBean = new TeacherBean();
                    teacherBean.setId(i);
                    teacherList.add(teacherBean);
                }
                TeacherAndStudentHelp.teacherBeanDao().insertInTx(teacherList);

                List<StudentBean> studentList = new ArrayList<StudentBean>();
                for (long j = 1; j < 4; j++) {
                    StudentBean studentBean = new StudentBean();
                    studentBean.setId(j);
                    studentList.add(studentBean);
                }
                TeacherAndStudentHelp.studentBeanDao().insertInTx(studentList);

                List<TeacherJoinStudentBean> teacherJoinStudentList = new ArrayList<TeacherJoinStudentBean>();
//教师1带学生1、2
                TeacherJoinStudentBean teacherJoinStudentBean1 = new TeacherJoinStudentBean(null,1l,1l);
                teacherJoinStudentList.add(teacherJoinStudentBean1);
                TeacherJoinStudentBean teacherJoinStudentBean2 = new TeacherJoinStudentBean(null,1l,2l);
                teacherJoinStudentList.add(teacherJoinStudentBean2);
//教师2带学生1、3
                TeacherJoinStudentBean teacherJoinStudentBean3 = new TeacherJoinStudentBean(null,2l,1l);
                teacherJoinStudentList.add(teacherJoinStudentBean3);

                TeacherJoinStudentBean teacherJoinStudentBean4 = new TeacherJoinStudentBean(null,2l,3l);
                teacherJoinStudentList.add(teacherJoinStudentBean4);
                TeacherAndStudentHelp.teacherJoinStudentBeanDao().insertInTx(teacherJoinStudentList);
                Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_LONG).show();
                break;
            case R.id.updataorder:
                break;
        }
    }
}
