package com.store.notification.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;        // INVENTORY_LOW, PURCHASE, BILLING
    private String title;
    private String message;
    private String recipient;   // email / phone / userId
    private String status;      // SENT, FAILED

    private LocalDateTime createdAt;
}
