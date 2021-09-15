package com.kubrafelek.homework04.model;

import com.kubrafelek.homework04.model.enumeration.ExceptionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExceptionsLogger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int status;
    private String message;
    private LocalDateTime exceptionDataTime;
    private String clientIpAddress;
    private String clientUrl;
    private String sessionActivityId;
    @Enumerated(EnumType.STRING)
    private ExceptionType exceptionType;
}
