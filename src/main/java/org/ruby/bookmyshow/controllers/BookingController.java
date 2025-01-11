package org.ruby.bookmyshow.controllers;

import org.ruby.bookmyshow.dtos.BookTicketRequestDto;
import org.ruby.bookmyshow.dtos.BookTicketResponseDto;
import org.ruby.bookmyshow.dtos.ResponseStatus;
import org.ruby.bookmyshow.models.Booking;
import org.ruby.bookmyshow.services.BookingService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookTicketResponseDto bookTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto) {
        // call the service
        // call the repository
        // return the response
        BookTicketResponseDto bookTicketResponseDto = new BookTicketResponseDto();
        try {
            Booking booking = bookingService.bookTicket(
                    bookTicketRequestDto.getShowId(),
                    bookTicketRequestDto.getUserId(),
                    bookTicketRequestDto.getShowSeatIds()
            );
            bookTicketResponseDto.setBookingId(booking.getId());
            bookTicketResponseDto.setAmount(booking.getTotalAmount());
            bookTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

        } catch (RuntimeException e) {
            bookTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return bookTicketResponseDto;
    }

//@Component , @Controller, @Service , @Repository
// hardcoded

}
