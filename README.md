# StudeGreedao
初学greedao代码
###学习步骤
~~~
http://www.jianshu.com/p/4986100eff90
~~~
关于GreenDao
~~~
关于多表联系http://www.jianshu.com/p/dbec25bd575f
http://www.jianshu.com/p/d61983df2341
~~~
greenDao是一个将对象映射到SQLite数据库中的轻量且快速的ORM解决方案。<br>
关于greenDAO的概念可以看官网greenDAO<br>

#greenDAO 优势<br>

###1、一个精简的库<br>
2、性能最大化<br>
3、内存开销最小化<br>
4、易于使用的 APIs<br>
5、对 Android 进行高度优化<br>

GreenDao 3.0使用<br>

GreenDao 3.0采用注解的方式来定义实体类，通过gradle插件生成相应的代码。<br>

一，在as中导入相关的包<br>

compile'org.greenrobot:greendao:3.0.1'<br>
compile'org.greenrobot:greendao-generator:3.0.0'<br>
二，在build.gradle中进行配置：<br>

apply plugin: 'org.greenrobot.greendao'<br>
buildscript { <br>
    repositories { <br>
        mavenCentral()  <br>  
}    <br>
dependencies {<br>
    classpath 'org.greenrobot:greendao-gradle-plugin:3.0.0'    <br>
    }<br>
}<br>
在gradle的根模块中加入上述代码。<br>

三，自定义路径<br>

greendao {<br>
    >>>schemaVersion 1<br>
    >>>daoPackage 'com.anye.greendao.gen'<br>
    >>>targetGenDir 'src/main/java'<br>
}<br>
在gradle的根模块中加入上述代码，就完成了我们的基本配置了。<br>
属性介绍：<br>
 schemaVersion--> 指定数据库schema版本号，迁移等操作会用到;<br>
 daoPackage --> dao的包名，包名默认是entity所在的包；<br>
 targetGenDir --> 生成数据库文件的目录;<br>

四，创建一个User的实体类<br>

@Entity<br>
public class User {<br>
    @Id <br>
    private Long id; <br>
    private String name; <br>
    @Transient <br>
    private int tempUsageCount; // not persisted  <br>
}
五，MakeProject<br>

 >>>编译项目，User实体类会自动编译，生成get、set方法并且会在com.anye.greendao.gen目录下生成三个文件；<br>


greenDao<br>
GreenDao使用<br>
~~~~

 public class MyApplication extends Application {
 private DaoMaster.DevOpenHelper mHelper;
 private SQLiteDatabase db;
 private DaoMaster mDaoMaster;
 private DaoSession mDaoSession;
 public static MyApplication instances;
 @Override    public void onCreate() {
     super.onCreate();
     instances = this;
     setDatabase();
 }
 public static MyApplication getInstances(){
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
    mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
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
}
获取UserDao对象：

  mUserDao = MyApplication.getInstances().getDaoSession().getUserDao();
简单的增删改查实现：

1. 增

mUser = new User((long)2,"anye3");
mUserDao.insert(mUser);//添加一个
2. 删

mUserDao.deleteByKey(id);
3. 改

mUser = new User((long)2,"anye0803");
mUserDao.update(mUser);
4. 查

List<User> users = mUserDao.loadAll();
String userName = "";
for (int i = 0; i < users.size(); i++) {
    userName += users.get(i).getName()+",";
}
mContext.setText("查询全部数据==>"+userName);
更多的操作就不一一介绍了，大家可以根据需要去查找资料；
~~~~
greendao中的注解<br>

(一) @Entity 定义实体<br>
@nameInDb 在数据库中的名字，如不写则为实体中类名<br>
@indexes 索引<br>
@createInDb 是否创建表，默认为true,false时不创建<br>
@schema 指定架构名称为实体<br>
@active 无论是更新生成都刷新<br>
(二) @Id<br>
(三) @NotNull 不为null<br>
(四) @Unique 唯一约束<br>
(五) @ToMany 一对多<br><br>
(六) @OrderBy 排序<br>
(七) @ToOne 一对一<br>
(八) @Transient 不存储在数据库中<br><br>
(九) @generated 由greendao产生的构造函数或方法<br>
~~~~
结束语

总体来说,GreenDao3.0在配置上相对于2.0要简单的多。
本文 Demo 下载链接：https://github.com/anye0803/GreenDao/，,如果喜欢的话可以star一下。
本教程旨在介绍 greenDAO3.0的基本用法与配置，更高级与详细的使用，请参见官网如本文有任何问题欢迎指正。

 Android

作者：anye0803
链接：http://www.jianshu.com/p/4986100eff90
來源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
~~~~
