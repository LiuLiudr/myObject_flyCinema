package com.cn.flyCinema.entity;

public class Seating {
    private Integer id;
    private Integer sid;
    private Integer coord;
    private String selected;

    public Seating(Integer id, Integer sid, Integer coord, String selected) {
        this.id = id;
        this.sid = sid;
        this.coord = coord;
        this.selected = selected;
    }
    public Seating() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCoord() {
        return coord;
    }

    public void setCoord(Integer coord) {
        this.coord = coord;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Seating{" +
                "id=" + id +
                ", sid=" + sid +
                ", coord=" + coord +
                ", selected='" + selected + '\'' +
                '}';
    }
}
