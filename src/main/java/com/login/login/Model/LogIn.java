package com.login.login.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.time.LocalDateTime;

@Entity
@Table(name="login")
@Data
public class LogIn {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "login_id")
    private Long LogInId;
    @Column(name = "user_email")
    private String UserEmail;
    @Column(name = "user_password")
    private String UserPassword;
    @Column(name = "customer_id")
    private Long CustomerId;
    @CreationTimestamp
    @Column(name ="created_timestamp")
    private LocalDateTime CreatedTimestamp;
    @UpdateTimestamp
    @Column(name =" login_update_timestamp")
    private LocalDateTime LoginUpdateTimestamp;
}
