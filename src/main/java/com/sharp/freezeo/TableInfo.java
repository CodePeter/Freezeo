package com.sharp.freezeo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableInfo {
    public static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://172.17.5.21:5432/xuexifang?prepareThreshold=0", "web_xuexifang_user", "A4215FD6-1FBF-4EEB-A91D-4F2073701FDA");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static TableEntity transferTable2Pojo(String tableName) throws SQLException {
        DatabaseMetaData metaData = DbInfo.conn.getMetaData();
        ResultSet set = metaData.getColumns("xuexifang", "%", tableName, "%");
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName(tableName);
        tableEntity.setPojoName(Table2PojoUtils.PojoName("_[a-z]", tableName, FormatName.PojoName, 1));
        List<ColumnEntity> columnEntities = new ArrayList<>();
        while (set.next()) {

            String columnName = set.getString("COLUMN_NAME");
            String columnType = set.getString("TYPE_NAME");
            int datasize = set.getInt("COLUMN_SIZE");
            int digits = set.getInt("DECIMAL_DIGITS");
            int nullable = set.getInt("NULLABLE");
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setColumnName(columnName);
            columnEntity.setColumnType(columnType);
            columnEntity.setPojoType(getMemberType(columnType, digits));
            columnEntities.add(columnEntity);
            System.out.println(columnName + " " + columnType + " " + datasize + " " + digits + " " + nullable);
            System.out.println(columnEntity.getMemeberName());
            System.out.println(columnEntity.getMethodName());
            System.out.println(columnEntity.getPojoType());
        }
        tableEntity.setColumnEntityList(columnEntities);
        return tableEntity;
    }

    public static String getMemberType(String columnType, int digits) {
        if(columnType.equals("serial")) {
            return "Long";
        }
        if(columnType.equals("varchar")) {
            return "String";
        }
        if(columnType.equals("numeric") && digits > 0) {
            return "BigDecimal";
        }
        if(columnType.equals("numeric") && digits == 0) {
            return "Integer";
        }
        if(columnType.equals("int2") || columnType.equals("int4")) {
            return "Integer";
        }
        if(columnType.equals("timestamp")) {
            return "Date";
        }
        return "";
    }

    public static void main(String[] args) throws SQLException {
        TableInfo.transferTable2Pojo("t_product");
    }

}
