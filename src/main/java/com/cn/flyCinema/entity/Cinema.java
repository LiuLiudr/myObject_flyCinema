package com.cn.flyCinema.entity;

public class Cinema {
    private Integer cid;
    private String name;
    private Integer aid;
    private String address;
    private  String img;
    private  String phone;
    private  Double score;

    public Cinema() {
    }

    public Cinema(Integer cid, String name, Integer aid, String address, String img, String phone, Double score) {
        this.cid = cid;
        this.name = name;
        this.aid = aid;
        this.address = address;
        this.img = img;
        this.phone = phone;
        this.score = score;
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

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", aid=" + aid +
                ", address='" + address + '\'' +
                ", img='" + img + '\'' +
                ", phone='" + phone + '\'' +
                ", score=" + score +
                '}';
    }
}
