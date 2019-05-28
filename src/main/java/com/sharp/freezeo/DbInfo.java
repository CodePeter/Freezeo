package com.sharp.freezeo;

import java.sql.*;

/**
 * id serial 10 0 0
 * product_id varchar 36 0 0
 * product_name varchar 100 0 0
 * summary varchar 400 0 1
 * img_url varchar 300 0 1
 * product_type numeric 2 0 1
 * sell_mode numeric 1 0 1
 * price numeric 8 2 1
 * status numeric 1 0 1
 * order_weight int2 5 0 0
 * putaway_time timestamp 29 6 1
 * create_time timestamp 29 6 0
 * modify_time timestamp 29 6 0
 * view_count int4 10 0 1
 * subscribe_count int4 10 0 1
 */
public class DbInfo {

    public static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://172.17.5.21:5432/xuexifang?prepareThreshold=0", "web_xuexifang_user", "A4215FD6-1FBF-4EEB-A91D-4F2073701FDA");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        DatabaseMetaData metaData = DbInfo.conn.getMetaData();
        ResultSet set = metaData.getColumns("xuexifang", "%", "t_product", "%");
        while (set.next()) {
            String columnName = set.getString("COLUMN_NAME");
            String columnType = set.getString("TYPE_NAME");
            int datasize = set.getInt("COLUMN_SIZE");
            int digits = set.getInt("DECIMAL_DIGITS");
            int nullable = set.getInt("NULLABLE");
            System.out.println(columnName + " " + columnType + " " + datasize + " " + digits + " " + nullable);
        }

//        FileUtils.writeStringToFile();

    }
}
