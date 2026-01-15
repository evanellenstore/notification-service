package com.store.notification.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class NotificationResponse {

    private Long id;
    private String type;
    private String title;
    private String message;
    private String recipient;
    private String status;
    private LocalDateTime createdAt;
}
