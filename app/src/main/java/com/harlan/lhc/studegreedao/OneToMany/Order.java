package com.harlan.lhc.studegreedao.OneToMany;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by a1 on 2017/11/23.
 */
@Entity
public class Order {
    @Id
    private Long id;
    private long customerId;//此为 外键,和customer 对应起来
    private String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getCustomerId() {
        return this.customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 517394230)
    public Order(Long id, long customerId, String name) {
        this.id = id;
        this.customerId = customerId;
        this.name = name;
    }
    @Generated(hash = 1105174599)
    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", name='" + name + '\'' +
                '}';
    }
}