package com.login.login.LogInDto;

import lombok.Data;

@Data
public class LogInRequest {
    private Long LogInId;
    private String UserEmail;
    private String UserPassword;
    private Long CustomerId;
}
