package com.kubrafelek.homework04.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import com.kubrafelek.homework04.model.enumeration.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TransactionLogger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int courseCode;
    private long studentId;
    private LocalDateTime transactionDataTime;
    private String clientIpAddress;
    private String clientUrl;
    private String sessionActivityId;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
}
