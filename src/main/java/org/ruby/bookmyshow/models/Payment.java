package org.ruby.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.ruby.bookmyshow.models.enums.PaymentGateway;
import org.ruby.bookmyshow.models.enums.PaymentMode;
import org.ruby.bookmyshow.models.enums.PaymentStatus;

import java.util.Date;

@Entity
@Getter
@Setter
public class Payment extends BaseModel {
    private double amount;
    private Date paymentDate;
    @Enumerated(value = EnumType.ORDINAL)
    private PaymentMode mode;
    private String refNumber;
    @Enumerated(value = EnumType.ORDINAL)
    private PaymentGateway paymentGateway;
    @Enumerated(value = EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    @ManyToOne
    private Booking bookings;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public PaymentGateway getPaymentGateway() {
        return paymentGateway;
    }

    public void setPaymentGateway(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Booking getBookings() {
        return bookings;
    }

    public void setBookings(Booking bookings) {
        this.bookings = bookings;
    }
}
