package com.store.notification.service;

import com.store.notification.dto.*;
import com.store.notification.entity.Notification;
import com.store.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationResponse sendNotification(NotificationRequest request) {

        Notification notification = Notification.builder()
                .type(request.getType())
                .title(request.getTitle())
                .message(request.getMessage())
                .recipient(request.getRecipient())
                .status("SENT")
                .createdAt(LocalDateTime.now())
                .build();

        Notification saved = repository.save(notification);

        // Simulate sending
        System.out.println("🔔 Notification Sent: " + request.getMessage());

        return mapToResponse(saved);
    }

    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }

    public Notification getNotification(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
    }

    private NotificationResponse mapToResponse(Notification n) {
        return NotificationResponse.builder()
                .id(n.getId())
                .type(n.getType())
                .title(n.getTitle())
                .message(n.getMessage())
                .recipient(n.getRecipient())
                .status(n.getStatus())
                .createdAt(n.getCreatedAt())
                .build();
    }
}
