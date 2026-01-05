package gouri.notification.notification_tracker.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("notification_events")
public class NotificationEvent {
    private NotificationPrimaryKey key;
    private UUID notificationId;
    private String messageType;
    private String status;
    private String content;
    private LocalDateTime createdAt;
}
