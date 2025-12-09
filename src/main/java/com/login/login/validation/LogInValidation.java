package com.login.login.validation;

import com.login.login.LogInDto.CustomerResponse;
import com.login.login.LogInDto.LogInRequest;
import com.login.login.LogInDto.LogInResponse;
import com.login.login.exception.CustomerNotFoundException;
import com.login.login.service.LogInService;
import org.springframework.stereotype.Component;



@Component
public class LogInValidation {
    LogInService logInService;
    public LogInValidation() {
        this.logInService = logInService;
    }
    public void customerValidation(LogInRequest logInRequest) throws CustomerNotFoundException {

        for(CustomerResponse list1 :logInService.getAllCustomers()){
            if( !logInRequest.getUserEmail().equals(list1.getCustomerEmail()) && !logInRequest.getUserPassword().equals(list1.getCustomerPassword()) ){
                throw new CustomerNotFoundException("customer not found");
        }
            else{
                throw new CustomerNotFoundException("customer not found");
            }
        }
    }
}
