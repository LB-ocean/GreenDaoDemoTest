package com.example.greendaodemotest.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by li biao
 * 2017/9/20
 * email:207563927@qq.com
 */
@Entity
public class Student
{
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private Long age;
    private Long uniqueNum;//此为 外键,和老师 对应起来
    @Generated(hash = 766599011)
    public Student(Long id, String name, Long age, Long uniqueNum) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.uniqueNum = uniqueNum;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getAge() {
        return this.age;
    }
    public void setAge(Long age) {
        this.age = age;
    }
    public Long getUniqueNum() {
        return this.uniqueNum;
    }
    public void setUniqueNum(Long uniqueNum) {
        this.uniqueNum = uniqueNum;
    }

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", uniqueNum=").append(uniqueNum);
        sb.append('}');
        return sb.toString();
    }
}
