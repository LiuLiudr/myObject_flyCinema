package com.cn.flyCinema.entity;


public class Indent {
    private Integer id;
    private Integer uid;
    private Integer sid;
    private Integer coord;
    private Movie movie;
    private Schedule schedule;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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


    @Override
    public String toString() {
        return "Indent{" +
                "id=" + id +
                ", uid=" + uid +
                ", sid=" + sid +
                ", coord=" + coord +
                ", movie=" + movie +
                ", schedule=" + schedule +
                '}';
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Indent() {
    }
}
