package com.sys.model;

import java.util.Date;

public class Jydj {
    private Integer id;

    private Integer sbid;

    private Date jysj;

    private Integer uid;

    private Date ghsj;

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

    public Date getJysj() {
        return jysj;
    }

    public void setJysj(Date jysj) {
        this.jysj = jysj;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getGhsj() {
        return ghsj;
    }

    public void setGhsj(Date ghsj) {
        this.ghsj = ghsj;
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
        sb.append(", jysj=").append(jysj);
        sb.append(", uid=").append(uid);
        sb.append(", ghsj=").append(ghsj);
        sb.append(", info=").append(info);
        sb.append(", ztid=").append(ztid);
        sb.append("]");
        return sb.toString();
    }
}