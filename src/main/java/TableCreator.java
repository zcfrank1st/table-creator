import entity.GeneralColumn;
import entity.GeneralTable;
import util.TypeTransformer;

import java.util.List;

/**
 * Created by zcfrank1st on 8/13/15.
 */
public class TableCreator {
    private static final String TYPE_HIVE = "hive";
    private static final String TYPE_SQLSERVER = "sqlserver";

    public static String generateCreateTableSentence(GeneralTable generalTable) {
        return genFromType(generalTable);
    }

    private static String genFromType(GeneralTable generalTable) {
        if (generalTable.getDbType().equals(TYPE_HIVE)) {
            return genHiveCreateTableSentence(generalTable);
        } else if (generalTable.getDbType().equals(TYPE_SQLSERVER)) {
            return genSqlserverCreateTableSentence(generalTable);
        } else {
            throw new RuntimeException("generate table, type not supported!");
        }
    }

    private static String genHiveCreateTableSentence(GeneralTable generalTable) {
        StringBuilder builder = new StringBuilder();
        builder = buildHead(builder, generalTable.getName());
        for (GeneralColumn column : generalTable.getColumns()) {
            String columnName = column.getName();
            String columnType = "string";
            String columnComment = column.getComment();
            builder = buildBody(builder, columnName, columnType, columnComment);
        }
        List<GeneralColumn> partitions = generalTable.getPartitions();
        if (null != partitions) {
            builder = buildPartition(deleteRedundancy(builder), partitions);
        }
        builder = buildTail(deleteRedundancy(builder), TYPE_HIVE);
        return builder.toString();
    }

    private static String genSqlserverCreateTableSentence(GeneralTable generalTable) {
        StringBuilder builder = new StringBuilder();
        builder = buildHead(builder, generalTable.getName());
        for (GeneralColumn column : generalTable.getColumns()) {
            String columnName = column.getName();
            String columnType = TypeTransformer.transformHive(column.getType());
            String columnComment = column.getComment();
            builder = buildBody(builder, columnName, columnType, columnComment);
        }

        builder = buildTail(deleteRedundancy(builder), TYPE_SQLSERVER);
        return builder.toString();
    }

    private static StringBuilder buildHead (StringBuilder builder, String name) {
        return builder.append("CREATE TABLE `").append(name).append("` ( \n");
    }

    private static StringBuilder buildBody (StringBuilder builder, String name, String type, String comment) {
        return builder.append("    ").append("`").append(name).append("`").append(" ")
                .append(type).append(" ")
                .append("COMMENT '").append(comment).append("'").append(",\n");
    }

    private static StringBuilder buildPartition(StringBuilder builder, List<GeneralColumn> partitions) {
        builder.append("\n").append(")");
        builder.append(" PARTITIONED BY (").append("\n");
        for (GeneralColumn generalColumn : partitions) {
            builder.append("    ").append("`").append(generalColumn.getName()).append("`").append(" ")
                    .append(generalColumn.getType()).append(" ")
                    .append("COMMENT '").append(generalColumn.getComment()).append("'").append(",\n");
        }
        return builder;
    }

    private static StringBuilder buildTail (StringBuilder builder, String type) {
        builder.append("\n").append(")");
        if (type.equals(TYPE_HIVE)) {
            builder.append("\n").append("ROW FORMAT DELIMITED").append("\n")
                    .append("FIELDS TERMINATED BY '\\t';");
        }
        return builder;
    }

    private static StringBuilder deleteRedundancy(StringBuilder builder) {
        return builder.delete(builder.length() - 2, builder.length());
    }
}
