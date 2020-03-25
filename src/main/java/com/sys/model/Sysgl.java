package com.sys.model;

public class Sysgl {
    private Integer id;

    private String sysname;

    private Integer lxid;

    private String bh;

    private String lc;

    private String fzrid;

    private Integer sfyy;

    private Integer yyrid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysname() {
        return sysname;
    }

    public void setSysname(String sysname) {
        this.sysname = sysname == null ? null : sysname.trim();
    }

    public Integer getLxid() {
        return lxid;
    }

    public void setLxid(Integer lxid) {
        this.lxid = lxid;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh == null ? null : bh.trim();
    }

    public String getLc() {
        return lc;
    }

    public void setLc(String lc) {
        this.lc = lc == null ? null : lc.trim();
    }

    public String getFzrid() {
        return fzrid;
    }

    public void setFzrid(String fzrid) {
        this.fzrid = fzrid;
    }

    public Integer getSfyy() {
        return sfyy;
    }

    public void setSfyy(Integer sfyy) {
        this.sfyy = sfyy;
    }

    public Integer getYyrid() {
        return yyrid;
    }

    public void setYyrid(Integer yyrid) {
        this.yyrid = yyrid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sysname=").append(sysname);
        sb.append(", lxid=").append(lxid);
        sb.append(", bh=").append(bh);
        sb.append(", lc=").append(lc);
        sb.append(", fzrid=").append(fzrid);
        sb.append(", sfyy=").append(sfyy);
        sb.append(", yyrid=").append(yyrid);
        sb.append("]");
        return sb.toString();
    }
}