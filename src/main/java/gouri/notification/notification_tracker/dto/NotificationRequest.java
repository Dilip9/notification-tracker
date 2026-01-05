package gouri.notification.notification_tracker.dto;
import gouri.notification.notification_tracker.enums.ChannelType;
import gouri.notification.notification_tracker.enums.MessageType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NotificationRequest {
    private String clientId;
    private String userId;
    private ChannelType channelType;
    private String recipient;

    @NotBlank
    private String content;
    private MessageType messageType;
}
