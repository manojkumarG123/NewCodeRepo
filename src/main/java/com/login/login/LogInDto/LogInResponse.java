package com.login.login.LogInDto;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Data
public class LogInResponse {
    private Long LogInId;
    private String UserEmail;
    private String UserPassword;
    private Long CustomerId;


}
