package model;

public class AuditEntity {
    private String schema;
    private String table;
    private String sqlStatement;

    public AuditEntity(String schema, String table, String sqlStatement) {
        this.schema = schema;
        this.table = table;
        this.sqlStatement = sqlStatement;
    }

    public String getSchema() {
        return schema;
    }

    public String getTable() {
        return table;
    }

    public String getSqlStatement() {
        return sqlStatement;
    }
}
