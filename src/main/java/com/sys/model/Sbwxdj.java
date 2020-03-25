package com.sys.model;

import java.util.Date;

public class Sbwxdj {
    private Integer id;

    private Integer sbid;

    private Date wssj;

    private String wxr;

    private Integer money;

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

    public Date getWssj() {
        return wssj;
    }

    public void setWssj(Date wssj) {
        this.wssj = wssj;
    }

    public String getWxr() {
        return wxr;
    }

    public void setWxr(String wxr) {
        this.wxr = wxr == null ? null : wxr.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
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
        sb.append(", wssj=").append(wssj);
        sb.append(", wxr=").append(wxr);
        sb.append(", money=").append(money);
        sb.append(", info=").append(info);
        sb.append(", ztid=").append(ztid);
        sb.append("]");
        return sb.toString();
    }
}