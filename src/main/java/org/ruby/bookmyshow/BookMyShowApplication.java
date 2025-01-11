package org.ruby.bookmyshow;

import org.ruby.bookmyshow.controllers.UserController;
import org.ruby.bookmyshow.dtos.SignUpRequestDTO;
import org.ruby.bookmyshow.dtos.SignUpResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

    private final UserController userController;

    public BookMyShowApplication(UserController userController) {
        this.userController = userController;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDTO requestDTO = new SignUpRequestDTO();
        requestDTO.setFirstName("John");
        requestDTO.setEmail("john@gmail.com");
        requestDTO.setPassword("password");
        SignUpResponseDTO responseDTO = userController.signUp(requestDTO);

    }


    // Agenda
// Completing one functionality of Booking the ticket
// Basic Sign up flow which will be working

// HW : Complete the book my show functionality by adding data to the db

// created the models
// created the tables in the db

// Controller(ReqDto) : Response -> Service -> repository

}
