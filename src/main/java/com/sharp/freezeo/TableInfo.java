package com.sharp.freezeo;

import com.sharp.freezeo.constants.FreezeoConstant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableInfo {

    public static Connection conn;

    public static void getPgSqlConnection(String url, String username, String password) throws SQLException {
//        conn = DriverManager.getConnection("jdbc:postgresql://172.17.5.21:5432/xuexifang?prepareThreshold=0", "web_xuexifang_user", "A4215FD6-1FBF-4EEB-A91D-4F2073701FDA");
        conn = DriverManager.getConnection(url, username, password);
    }

    public static void getSqlServerConnection(String url, String username, String password) throws SQLException {
//        conn = DriverManager.getConnection("jdbc:sqlserver://175.63.100.235:1433;DatabaseName=CampusRD2012", "qa", "qa@123");
        conn = DriverManager.getConnection(url, username, password);
    }

    public static TableEntity transferTable2Pojo(String dbName, String tableName, int startPojo) throws SQLException {
        DatabaseMetaData metaData = DbInfo.conn.getMetaData();
        ResultSet set = metaData.getColumns(dbName, "%", tableName, "%");
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName(tableName);
        tableEntity.setPojoName(Table2PojoUtils.PojoName(FreezeoConstant.REGEX, tableName, FormatName.PojoName, startPojo));
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
        if (columnType.equals("serial") || columnType.equals("bigint")) {
            return "Long";
        }
        if (columnType.equals("char") || columnType.equals("varchar") || columnType.equals("nvarchar")
                || columnType.equals("text") || columnType.equals("ntext")) {
            return "String";
        }
        if (columnType.equals("numeric") && digits > 0) {
            return "BigDecimal";
        }
        if (columnType.equals("numeric") && digits == 0) {
            return "Integer";
        }
        if (columnType.equals("tinyint") || columnType.equals("int") || columnType.equals("int2") || columnType.equals("int4")) {
            return "Integer";
        }
        if (columnType.equals("timestamp") || columnType.equals("datetime")) {
            return "Date";
        }
        return "";
    }

    public static void main(String[] args) throws SQLException {
        TableInfo.getSqlServerConnection("jdbc:sqlserver://175.63.100.235:1433;DatabaseName=CampusRD2012", "qa", "qa@123");
        TableInfo.transferTable2Pojo("CampusRD2012","Job_position",0);
    }

}
