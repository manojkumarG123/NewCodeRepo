package com.login.login.LogInDao.mapper;

import com.login.login.LogInDto.LogInRequest;
import com.login.login.LogInDto.LogInResponse;
import com.login.login.Model.LogIn;
import org.springframework.stereotype.Component;

@Component
public class LogInEntityMapper {
    public LogIn logInRequestToLogIn(LogInRequest logInRequest){
        LogIn logIn = new LogIn();
        logIn.setLogInId(logInRequest.getLogInId());
        logIn.setUserEmail(logInRequest.getUserEmail());
        logIn.setUserPassword(logInRequest.getUserPassword());
        logIn.setCustomerId(logInRequest.getCustomerId());
        return logIn;
    }
    public LogInResponse logInToLogInResponse(LogIn logIn){
        LogInResponse logInResponse = new LogInResponse();
        logInResponse.setLogInId(logIn.getLogInId());
        logInResponse.setUserEmail(logIn.getUserEmail());
        logInResponse.setUserPassword(logIn.getUserPassword());
        logInResponse.setCustomerId(logIn.getCustomerId());
        return logInResponse;
    }
}
