package org.ruby.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.ruby.bookmyshow.models.enums.SeatStaus;

import java.util.Date;

@Entity(name = "show_seat")
@Getter
@Setter
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(value = EnumType.ORDINAL)
    private SeatStaus seatStaus;
    private Date blockedAt;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public SeatStaus getSeatStaus() {
        return seatStaus;
    }

    public void setSeatStaus(SeatStaus seatStaus) {
        this.seatStaus = seatStaus;
    }

    public Date getBlockedAt() {
        return blockedAt;
    }

    public void setBlockedAt(Date blockedAt) {
        this.blockedAt = blockedAt;
    }
}

//Show Seat         Show
//1                   1
//Many to One         1

