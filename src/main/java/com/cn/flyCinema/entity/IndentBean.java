package com.cn.flyCinema.entity;

public class IndentBean {
    private Movie movie;
    private Schedule schedule;
    private Cinema cinema;

    public IndentBean(Movie movie, Schedule schedule, Cinema cinema) {
        this.movie = movie;
        this.schedule = schedule;
        this.cinema = cinema;
    }

    public IndentBean() {

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

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}
