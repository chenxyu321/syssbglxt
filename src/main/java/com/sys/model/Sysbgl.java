package com.sys.model;

import java.util.Date;

public class Sysbgl {
    private Integer id;

    private String sbname;

    private String bh;

    private Integer sysid;

    private Date cgsj;

    private Integer price;

    private Integer ztid;

    private Integer sfbx;

    private String info;

    private String img;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSbname() {
        return sbname;
    }

    public void setSbname(String sbname) {
        this.sbname = sbname == null ? null : sbname.trim();
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh == null ? null : bh.trim();
    }

    public Integer getSysid() {
        return sysid;
    }

    public void setSysid(Integer sysid) {
        this.sysid = sysid;
    }

    public Date getCgsj() {
        return cgsj;
    }

    public void setCgsj(Date cgsj) {
        this.cgsj = cgsj;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getZtid() {
        return ztid;
    }

    public void setZtid(Integer ztid) {
        this.ztid = ztid;
    }

    public Integer getSfbx() {
        return sfbx;
    }

    public void setSfbx(Integer sfbx) {
        this.sfbx = sfbx;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sbname=").append(sbname);
        sb.append(", bh=").append(bh);
        sb.append(", sysid=").append(sysid);
        sb.append(", cgsj=").append(cgsj);
        sb.append(", price=").append(price);
        sb.append(", ztid=").append(ztid);
        sb.append(", sfbx=").append(sfbx);
        sb.append(", info=").append(info);
        sb.append(", img=").append(img);
        sb.append("]");
        return sb.toString();
    }
}