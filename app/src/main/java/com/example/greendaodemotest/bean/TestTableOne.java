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
public class TestTableOne
{
    @Id(autoincrement = true)
    private Long id;
    private String testTableOnename;
    @Generated(hash = 173280430)
    public TestTableOne(Long id, String testTableOnename) {
        this.id = id;
        this.testTableOnename = testTableOnename;
    }
    @Generated(hash = 1640429853)
    public TestTableOne() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTestTableOnename() {
        return this.testTableOnename;
    }
    public void setTestTableOnename(String testTableOnename) {
        this.testTableOnename = testTableOnename;
    }

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("TestTableOne{");
        sb.append("id=").append(id);
        sb.append(", testTableOnename='").append(testTableOnename).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
