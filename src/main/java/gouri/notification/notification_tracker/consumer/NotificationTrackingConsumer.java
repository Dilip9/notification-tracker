package gouri.notification.notification_tracker.consumer;

import gouri.notification.notification_tracker.dto.NotificationRequest;
import gouri.notification.notification_tracker.model.NotificationEvent;
import gouri.notification.notification_tracker.model.NotificationPrimaryKey;
import gouri.notification.notification_tracker.repository.NotificationEventRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class NotificationTrackingConsumer {

    private final NotificationEventRepository repository;

    public NotificationTrackingConsumer(NotificationEventRepository repository){
        this.repository = repository;
    }

    @KafkaListener(topics = {
            "notification_sms",
            "notification_email",
            "notification_push",
            "notification_sms_dlq",

    })
    public void trackEvent(NotificationRequest request){
        NotificationEvent event = new NotificationEvent();
        event.setKey(new NotificationPrimaryKey(request.getUserId(),
                Instant.now()));
        event.setNotificationId(UUID.randomUUID());
        event.setChannelType(String.valueOf(request.getChannelType()));
        event.setMessageType(String.valueOf(request.getMessageType()));
        event.setStatus("Processed");
        event.setContent(request.getContent());
        repository.save(event);
    }
}
