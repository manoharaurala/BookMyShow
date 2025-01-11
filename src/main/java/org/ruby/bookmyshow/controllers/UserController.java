package org.ruby.bookmyshow.controllers;

import org.ruby.bookmyshow.dtos.ResponseStatus;
import org.ruby.bookmyshow.dtos.SignUpRequestDTO;
import org.ruby.bookmyshow.dtos.SignUpResponseDTO;
import org.ruby.bookmyshow.models.User;
import org.ruby.bookmyshow.services.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO) {
        SignUpResponseDTO response = new SignUpResponseDTO();
        try {
            User user = userService.signUp(
                    signUpRequestDTO.getFirstName(),
                    signUpRequestDTO.getEmail(),
                    signUpRequestDTO.getPassword()
            );
            response.setUserId(user.getId());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            System.out.println(ex.getMessage());
        }
        return response;
    }
}
