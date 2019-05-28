package com.sharp.freezeo;

import java.io.IOException;
import java.sql.SQLException;

public class FreezeoMain {
    public static void main(String[] args) throws SQLException, IOException {
       TableEntity tableEntity = TableInfo.transferTable2Pojo("t_product");
       System.out.println(tableEntity);
       GenerateJavaFile generateJavaFile = new GenerateJavaFile(tableEntity, "E:/JavaBeans");
       WriteJavaFile writeJavaFile = new WriteJavaFile(generateJavaFile);
       writeJavaFile.writeClassNameInfo();
    }
}
