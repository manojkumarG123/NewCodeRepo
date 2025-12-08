package com.login.login.service.impl;

import com.login.login.LogInDao.LogInDao;
import com.login.login.LogInDto.CustomerResponse;
import com.login.login.LogInDto.LogInRequest;
import com.login.login.LogInDto.LogInResponse;
import com.login.login.clientHandler.CustomerClientHandler;
import com.login.login.exception.CustomerNotFoundException;
import com.login.login.service.LogInService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogInServiceImpl implements LogInService {
    LogInDao logInDao;
    CustomerClientHandler customerClientHandler;
    public LogInServiceImpl(LogInDao logInDao, CustomerClientHandler customerClientHandler) {
        this.logInDao = logInDao;
        this.customerClientHandler = customerClientHandler;
    }
    @Override
    public List<LogInResponse> getallLogInDetails() {
        return logInDao.getAllLogInUsers();
    }

    @Override
    public LogInResponse getLogInDetailsById(Long id) {
        return logInDao.getLogInUserById(id);
    }

    @Override
    public LogInResponse createLogInUser(LogInRequest logInRequest) {
       for(CustomerResponse customer:customerClientHandler.getAllDetails())
       {
           if(logInRequest.getUserEmail().equals(customer.getCustomerEmail()) && logInRequest.getUserPassword().equals(customer.getCustomerPassword()))
           {
               return logInDao.createLogIn(logInRequest);
           }else
           {
               throw new CustomerNotFoundException("Customer not found");
           }
       }
        return null;
    }

    @Override
    public void deleteLogInById(Long id) {
        logInDao.deleteLogInById(id);
    }

    @Override
    public void deleteAllLogInUsers() {
        logInDao.deleteAllLogInUsers();
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<CustomerResponse> customerResponseList = customerClientHandler.getAllDetails();
        return customerResponseList;
    }


}
