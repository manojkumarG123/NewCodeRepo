package com.login.login.LogInDao;

import com.login.login.LogInDao.mapper.LogInEntityMapper;
import com.login.login.LogInDto.CustomerResponse;
import com.login.login.LogInDto.LogInRequest;
import com.login.login.LogInDto.LogInResponse;
import com.login.login.Model.LogIn;
import com.login.login.clientHandler.CustomerClientHandler;
import com.login.login.exception.CustomerNotFoundException;
import com.login.login.repository.LogInRepository;
import jdk.jfr.StackTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LogInDao {
    LogInRepository logInRepository;
    LogInEntityMapper logInEntityMapper;
    CustomerClientHandler customerClientHandler;
    public  LogInDao(LogInRepository logInRepository, LogInEntityMapper logInEntityMapper, CustomerClientHandler customerClientHandler) {
        this.logInRepository = logInRepository;
        this.logInEntityMapper = logInEntityMapper;
        this.customerClientHandler = customerClientHandler;
    }
    public List<LogInResponse> getAllLogInUsers() {
        List<LogInResponse> logInResponseList = new ArrayList<>();
        List<LogIn>  logInList = logInRepository.findAll();
        for (LogIn logIn : logInList) {
            logInResponseList.add(logInEntityMapper.logInToLogInResponse(logIn));
        }
        return logInResponseList;
    }
    public LogInResponse getLogInUserById(Long logInId) {
        LogIn login = logInRepository.findById(logInId).get();
        return logInEntityMapper.logInToLogInResponse(login);
    }
    public LogInResponse createLogIn(LogInRequest logInRequest)  {
        LogIn login = logInEntityMapper.logInRequestToLogIn(logInRequest);
        logInRepository.save(login);
        return logInEntityMapper.logInToLogInResponse(login);
    }
    public void deleteLogInById(Long logInId) {
        logInRepository.deleteById(logInId);
    }
    public void deleteAllLogInUsers() {
        logInRepository.deleteAll();
    }

}
