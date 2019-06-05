package com.sharp.freezeo;

import com.sharp.freezeo.enums.DBType;

import java.io.IOException;
import java.sql.SQLException;

public class FreezeoMain {
    public static void main(String[] args) throws SQLException, IOException {
        String dbname = "";
        String tableName = "";
        int startPojo = 0;
        String url = "";
        String username = "";
        String password = "";
        String directory = "";
        if(args.length == 6) {
            dbname = args[0];
            tableName = args[1];
            startPojo = Integer.parseInt(args[2]);
            url = args[3];
            username = args[4];
            password = args[5];
        } else {
            //测试数据
            dbname = "CampusRD2012";
            tableName = "Job_position";
            startPojo = 0;
            url = "jdbc:sqlserver://175.63.100.235:1433;DatabaseName=CampusRD2012";
            username = "qa";
            password = "qa@123";
            directory = "E:/JavaBeans";
        }
        // 设置数据库类型
        TableInfo.getSqlServerConnection(url, username, password);
        TableEntity tableEntity = TableInfo.transferTable2Pojo(dbname,tableName,startPojo);
        System.out.println(tableEntity);
        GenerateJavaFile generateJavaFile = new GenerateJavaFile(tableEntity, directory);
        WriteJavaFile writeJavaFile = new WriteJavaFile(generateJavaFile);
        writeJavaFile.writeClassNameInfo();
    }

//    public static void ConnectionSetting(DBType dbType) throws SQLException {
//        if (DBType.PgSql == dbType) {
//            TableInfo.getPgSqlConnection();
//        } else if (DBType.SqlServer == dbType) {
//            TableInfo.getPgSqlConnection();
//        }
//    }
}
