package com.hospital.admin.service;

import com.hospital.admin.entity.Notification;
import com.hospital.admin.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    public Notification createNotification(Notification notification) {
        return repository.save(notification);
    }

    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }
}