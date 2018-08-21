package com.zhangyiming.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "module")
public class Module {

    @Id
    private Integer mid;
    private String mname;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
}