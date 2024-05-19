package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditEntity {
    private String schema;
    private String table;
    private String actionName;

    private LocalDateTime timestamp;

    public AuditEntity(String schema, String table, String actionName, LocalDateTime timestamp) {
        this.schema = schema;
        this.table = table;
        this.actionName = actionName;
        this.timestamp = timestamp;
    }

    public String getSchema() {
        return schema;
    }

    public String getTable() {
        return table;
    }

    public String getActionName() {
        return actionName;
    }

    public String getTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }
}
