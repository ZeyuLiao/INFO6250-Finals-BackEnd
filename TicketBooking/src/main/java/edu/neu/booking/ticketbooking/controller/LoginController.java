package edu.neu.booking.ticketbooking.controller;

import edu.neu.booking.ticketbooking.controller.model.UserModel;
import edu.neu.booking.ticketbooking.service.LoginService;
import edu.neu.booking.ticketbooking.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserModel userModel) throws Exception {

        return ResponseEntity.ok(loginService.login(userModel));
    }

    @PostMapping("/logout")
    public void logout() throws Exception {
        loginService.logout();
    }
}
