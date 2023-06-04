package com.example.ims.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ims.Model.User;

@CrossOrigin
@RestController
public class UserController {

    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {
        // Perform login logic
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Example login validation
        if (username.equals("admin") && password.equals("password")) {
            return "Login successful";
        } else {
            return "Login failed";
        }
    }

}
