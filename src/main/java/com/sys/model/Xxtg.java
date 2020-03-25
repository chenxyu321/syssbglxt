package com.sys.model;

import java.util.Date;

public class Xxtg {
    private Integer id;

    private Integer fbrid;

    private String info;

    private Date fbtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFbrid() {
        return fbrid;
    }

    public void setFbrid(Integer fbrid) {
        this.fbrid = fbrid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Date getFbtime() {
        return fbtime;
    }

    public void setFbtime(Date fbtime) {
        this.fbtime = fbtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fbrid=").append(fbrid);
        sb.append(", info=").append(info);
        sb.append(", fbtime=").append(fbtime);
        sb.append("]");
        return sb.toString();
    }
}