package com.harlan.lhc.studegreedao.ManyToMany;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by a1 on 2017/11/23.
 */
@Entity
public class TeacherJoinStudentBean {
    @Id
    private Long id;
    private Long tId;
    private Long sId;
    public Long getSId() {
        return this.sId;
    }
    public void setSId(Long sId) {
        this.sId = sId;
    }
    public Long getTId() {
        return this.tId;
    }
    public void setTId(Long tId) {
        this.tId = tId;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 998000662)
    public TeacherJoinStudentBean(Long id, Long tId, Long sId) {
        this.id = id;
        this.tId = tId;
        this.sId = sId;
    }
    @Generated(hash = 1542025906)
    public TeacherJoinStudentBean() {
    }
}
