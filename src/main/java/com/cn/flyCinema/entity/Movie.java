package com.cn.flyCinema.entity;

import java.util.Date;

public class Movie {
    private Integer mid;
    private String name;
    private String director;
    private String protagonist;
    private String type;
    private String region;
    private String showtime;
    private String introduction;
    private Double score;
    private String img;
    private Date date;

    public Movie() {

    }

    public Movie(Integer mid, String name, String director, String protagonist, String type, String region, String showtime, String introduction, Double score, String img, Date date) {
        this.mid = mid;
        this.name = name;
        this.director = director;
        this.protagonist = protagonist;
        this.type = type;
        this.region = region;
        this.showtime = showtime;
        this.introduction = introduction;
        this.score = score;
        this.img = img;
        this.date = date;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(String protagonist) {
        this.protagonist = protagonist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", protagonist='" + protagonist + '\'' +
                ", type='" + type + '\'' +
                ", region='" + region + '\'' +
                ", showtime='" + showtime + '\'' +
                ", introduction='" + introduction + '\'' +
                ", score=" + score +
                ", img='" + img + '\'' +
                ", date=" + date +
                '}';
    }
}
