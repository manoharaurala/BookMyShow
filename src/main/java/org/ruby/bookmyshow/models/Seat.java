package org.ruby.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "seat")
@Getter
@Setter
public class Seat extends BaseModel {
    private String seatNumber;
    private int rowVal;
    private int columnVal;
    @ManyToOne
    private SeatType seatType;

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getRowVal() {
        return rowVal;
    }

    public void setRowVal(int rowVal) {
        this.rowVal = rowVal;
    }

    public int getColumnVal() {
        return columnVal;
    }

    public void setColumnVal(int columnVal) {
        this.columnVal = columnVal;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
