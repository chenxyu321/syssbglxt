package com.sys.model;

import java.util.Date;

public class Sbshdj {
    private Integer id;

    private Integer sbid;

    private Date shsj;

    private Integer uid;

    private String info;

    private Integer ztid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSbid() {
        return sbid;
    }

    public void setSbid(Integer sbid) {
        this.sbid = sbid;
    }

    public Date getShsj() {
        return shsj;
    }

    public void setShsj(Date shsj) {
        this.shsj = shsj;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getZtid() {
        return ztid;
    }

    public void setZtid(Integer ztid) {
        this.ztid = ztid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sbid=").append(sbid);
        sb.append(", shsj=").append(shsj);
        sb.append(", uid=").append(uid);
        sb.append(", info=").append(info);
        sb.append(", ztid=").append(ztid);
        sb.append("]");
        return sb.toString();
    }
}