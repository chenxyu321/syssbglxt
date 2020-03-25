package com.sys.model;

import java.util.Date;

public class Teacher {
    private Integer id;

    private String tname;

    private String sex;

    private Date birth;

    private String zyzc;

    private Integer zyid;

    private String tel;

    private String jl;

    private Integer idcard;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getZyzc() {
        return zyzc;
    }

    public void setZyzc(String zyzc) {
        this.zyzc = zyzc == null ? null : zyzc.trim();
    }

    public Integer getZyid() {
        return zyid;
    }

    public void setZyid(Integer zyid) {
        this.zyid = zyid;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getJl() {
        return jl;
    }

    public void setJl(String jl) {
        this.jl = jl == null ? null : jl.trim();
    }

    public Integer getIdcard() {
        return idcard;
    }

    public void setIdcard(Integer idcard) {
        this.idcard = idcard;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tname=").append(tname);
        sb.append(", sex=").append(sex);
        sb.append(", birth=").append(birth);
        sb.append(", zyzc=").append(zyzc);
        sb.append(", zyid=").append(zyid);
        sb.append(", tel=").append(tel);
        sb.append(", jl=").append(jl);
        sb.append(", idcard=").append(idcard);
        sb.append("]");
        return sb.toString();
    }
}