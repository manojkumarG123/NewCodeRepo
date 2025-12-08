package com.login.login.service;

import com.login.login.LogInDto.CustomerResponse;
import com.login.login.LogInDto.LogInRequest;
import com.login.login.LogInDto.LogInResponse;
import com.login.login.Model.LogIn;

import java.util.List;

public interface LogInService {
    List<LogInResponse> getallLogInDetails();
    LogInResponse getLogInDetailsById(Long id);
    LogInResponse createLogInUser(LogInRequest logInRequest);
    void deleteLogInById(Long id);
    void deleteAllLogInUsers();
    List<CustomerResponse> getAllCustomers();

}
