package com.hospital.admin.controller;

import com.hospital.admin.entity.Notification;
import com.hospital.admin.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    /**
     * POST - Create Notification
     */
    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification saved = notificationService.createNotification(notification);
        return ResponseEntity.ok(saved);
    }

    /**
     * GET - Get All Notifications
     */
    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> list = notificationService.getAllNotifications();
        return ResponseEntity.ok(list);
    }
}