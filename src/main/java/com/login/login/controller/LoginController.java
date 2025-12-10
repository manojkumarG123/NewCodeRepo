package com.login.login.controller;

import com.login.login.LogInDto.CustomerRequest;
import com.login.login.LogInDto.CustomerResponse;
import com.login.login.LogInDto.LogInRequest;
import com.login.login.LogInDto.LogInResponse;
import com.login.login.exception.CustomerNotFoundException;
import com.login.login.service.LogInService;
import com.login.login.validation.LogInValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class LoginController {
    @Autowired
    private LogInService logInService;
    @GetMapping("/logInn")
    public List<LogInResponse> logIn() {
        return logInService.getallLogInDetails();
    }
    @GetMapping("/logIn/{id}")
    public LogInResponse logIn(@PathVariable Long id) {
        return logInService.getLogInDetailsById(id);
    }
    @PostMapping("/logInn")
    public LogInResponse createLogIn(@RequestBody LogInRequest logInRequest) throws CustomerNotFoundException {
        return logInService.createLogInUser(logInRequest);
    }
    @GetMapping("/customer")
    public List<CustomerResponse> customer() {
        return logInService.getAllCustomers();
    }
    

//    @DeleteMapping("/logIn")
//    public void deleteLogIn() {
//        logInService.deleteAllLogInUsers();
//    }
//    @DeleteMapping("/logIn/{id}")
//    public void deleteLogIn(@PathVariable Long id) {
//        logInService.deleteLogInById(id);
//    }

}
