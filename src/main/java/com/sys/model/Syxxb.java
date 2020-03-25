package com.sys.model;

import java.util.Date;

public class Syxxb {
    private Integer id;

    private Integer cid;

    private Integer tid;

    private Integer sysid;

    private String info;

    private Date fbtime;

    private Integer sfwc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getSysid() {
        return sysid;
    }

    public void setSysid(Integer sysid) {
        this.sysid = sysid;
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

    public Integer getSfwc() {
        return sfwc;
    }

    public void setSfwc(Integer sfwc) {
        this.sfwc = sfwc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cid=").append(cid);
        sb.append(", tid=").append(tid);
        sb.append(", sysid=").append(sysid);
        sb.append(", info=").append(info);
        sb.append(", fbtime=").append(fbtime);
        sb.append(", sfwc=").append(sfwc);
        sb.append("]");
        return sb.toString();
    }
}