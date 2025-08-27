package com.example.notification;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Create or update a notification
    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    // Get all notifications
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Get notification by ID
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    // Delete notification by ID
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

    // Get notifications by type
    public List<Notification> getNotificationsByType(NotificationType type) {
        return notificationRepository.findAll().stream()
                .filter(n -> n.getType() == type)
                .toList();
    }
}
