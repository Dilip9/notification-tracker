package gouri.notification.notification_tracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyClass
public class NotificationPrimaryKey {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String userId;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private Instant createdAt;
}
