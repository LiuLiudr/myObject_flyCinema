package com.cn.flyCinema.entity;

public class City {
    private Integer cid;
    private String name;

    public City(Integer cid, String name) {
        this.cid = cid;
        this.name = name;
    }
    public City() {

    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                '}';
    }
}
