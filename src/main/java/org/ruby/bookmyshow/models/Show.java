package org.ruby.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity(name = "shows")
@Getter
@Setter
public class Show extends BaseModel {
    private Date date;
    private String time;
    private String language;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Theater theater;
    @ManyToOne
    private Screen screen;
    @OneToMany
    private List<ShowSeatType> showSeatTypes;
    @OneToMany
    private List<ShowSeat> showSeats;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<ShowSeatType> getShowSeatTypes() {
        return showSeatTypes;
    }

    public void setShowSeatTypes(List<ShowSeatType> showSeatTypes) {
        this.showSeatTypes = showSeatTypes;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
    }
}
