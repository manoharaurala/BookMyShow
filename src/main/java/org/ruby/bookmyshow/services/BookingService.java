package org.ruby.bookmyshow.services;

import org.ruby.bookmyshow.models.Booking;
import org.ruby.bookmyshow.models.Show;
import org.ruby.bookmyshow.models.ShowSeat;
import org.ruby.bookmyshow.models.User;
import org.ruby.bookmyshow.models.enums.SeatStaus;
import org.ruby.bookmyshow.repositories.BookingRepository;
import org.ruby.bookmyshow.repositories.ShowRepository;
import org.ruby.bookmyshow.repositories.ShowSeatRepository;
import org.ruby.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final UserRepository userRepository;

    public BookingService(BookingRepository bookingRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
    }

    public Booking bookTicket(
            Long showId,
            Long userId,
            List<Long> showSeatIds
    ) {
        //        1. Get user from the db
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User user = optionalUser.get();
        //        2. Get show from the db
        Optional<Show> showOptional = showRepository.findById(showId);
        if (showOptional.isEmpty()) {
            throw new RuntimeException("Show not found");
        }
        Show show = showOptional.get();
        //        3. Get showSeats
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        //        4. Check for the availability of the seats
        for (ShowSeat showSeat : showSeats) {
            if (showSeat.getSeatStaus() != SeatStaus.AVAILABLE) {
                throw new RuntimeException("how seats are not available at the moment.");
            }
        }
        //        5. if all are available , mark the status to blocked
        for (ShowSeat showSeat : showSeats) {
            showSeat.setSeatStaus(SeatStaus.BLOCKED);
            showSeat.setBlockedAt(new Date());
        }
        //        6. Make sure db is updated with the status
        showSeatRepository.saveAll(showSeats);
        //        7. Get the Booking object ready
        //        8. Find total amount of the seats
        //                Implement a different PriceCalculatorService
        //        9. Create , save and return the booking object
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setBookingDate(new Date());
        booking.setTotalAmount(showSeatIds.size() * 185.23);
        booking.setPayments(new ArrayList<>());
        booking.setShowSeats(showSeats);
        return bookingRepository.save(booking);

    }


// Very basic signUpFlow
// email password => userId

// 10 : 25 pm
}
