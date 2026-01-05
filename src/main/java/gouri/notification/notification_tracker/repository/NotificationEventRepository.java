package gouri.notification.notification_tracker.repository;

import gouri.notification.notification_tracker.model.NotificationEvent;
import gouri.notification.notification_tracker.model.NotificationPrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationEventRepository extends CassandraRepository<NotificationEvent, NotificationPrimaryKey> {


}
