package com.store.notification.controller;

import com.store.notification.dto.NotificationRequest;
import com.store.notification.dto.NotificationResponse;
import com.store.notification.entity.Notification;
import com.store.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @PostMapping
    public NotificationResponse send(@RequestBody NotificationRequest request) {
        return service.sendNotification(request);
    }

    @GetMapping
    public List<Notification> getAll() {
        return service.getAllNotifications();
    }

    @GetMapping("/{id}")
    public Notification getById(@PathVariable Long id) {
        return service.getNotification(id);
    }
}
