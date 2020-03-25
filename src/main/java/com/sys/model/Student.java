package com.sys.model;

import java.util.Date;

public class Student {
    private Integer id;

    private String sname;

    private Integer idcard;

    private String sex;

    private Integer zid;

    private Date birth;

    private Integer cid;

    private String tel;

    private String jl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public Integer getIdcard() {
        return idcard;
    }

    public void setIdcard(Integer idcard) {
        this.idcard = idcard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getZid() {
        return zid;
    }

    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getJl() {
        return jl;
    }

    public void setJl(String jl) {
        this.jl = jl == null ? null : jl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sname=").append(sname);
        sb.append(", idcard=").append(idcard);
        sb.append(", sex=").append(sex);
        sb.append(", zid=").append(zid);
        sb.append(", birth=").append(birth);
        sb.append(", cid=").append(cid);
        sb.append(", tel=").append(tel);
        sb.append(", jl=").append(jl);
        sb.append("]");
        return sb.toString();
    }
}