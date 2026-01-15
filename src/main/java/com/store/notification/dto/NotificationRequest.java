package com.store.notification.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {

    private String type;
    private String title;
    private String message;
    private String recipient;
}
