package com.login.login.LogInDto;

import lombok.Data;

@Data
public class CustomerResponse {
    private Long customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String customerPassword;
    private String customerEmail;
    private String customerAddress;
}
