package com.cn.flyCinema.entity;

public class Area {
    private Integer aid;
    private String name;
    private Integer cid;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Area() {

    }

    public Area(Integer aid, String name, Integer cid) {
        this.aid = aid;
        this.name = name;
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Area{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", cid=" + cid +
                '}';
    }
}
