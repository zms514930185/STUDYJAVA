package pojo;

public class TableName {
    private String tableName;
    private String column;
    private Object object;

    @Override
    public String toString() {
        return "tableName='" + tableName + '\'' +
                ", column='" + column + '\'' +
                ", object=" + object;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public TableName(String tableName, String column, Object object) {
        this.tableName = tableName;
        this.column = column;
        this.object = object;
    }

    public TableName() {
    }
}
