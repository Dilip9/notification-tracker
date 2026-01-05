CREATE KEYSPACE IF NOT EXISTS notification_keyspace
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

CREATE TABLE IF NOT EXISTS notification_keyspace.notification_events (
    user_id text,
    notification_id uuid,
    channel text,
    message_type text,
    status text,
    content text,
    created_at timestamp,
    PRIMARY KEY (user_id, created_at)
) WITH CLUSTERING ORDER BY (created_at DESC);
