package entity;

import java.util.List;

public class GeneralTable {
    private String name;
    private List<GeneralColumn> columns;
    private List<GeneralColumn> partitions;
    private String dbType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GeneralColumn> getPartitions() {
        return partitions;
    }

    public void setPartitions(List<GeneralColumn> partitions) {
        this.partitions = partitions;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public List<GeneralColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<GeneralColumn> columns) {
        this.columns = columns;
    }
}
