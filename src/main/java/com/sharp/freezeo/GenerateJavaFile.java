package com.sharp.freezeo;

import java.io.File;
import java.util.List;

public class GenerateJavaFile {

    private List<TableEntity> tableEntities;
    private TableEntity tableEntity;
    private String fileDirectory;
    private String tableName;

    public GenerateJavaFile(TableEntity tableEntity, String fileDirectory) {
        this.tableEntity = tableEntity;
        this.fileDirectory = fileDirectory;
        this.tableName = tableEntity.getTableName();
    }

    public GenerateJavaFile(List<TableEntity> tableEntities, String fileDirectory) {
        this.tableEntities = tableEntities;
        this.fileDirectory = fileDirectory;
    }

    public File getFile() {
        String fileName = getFileName();
        File pojoFile = new File(fileDirectory+File.separator+fileName+".java");
        return pojoFile;
    }

    public String getFileName() {
        return Table2PojoUtils.PojoName("_[a-z]",tableEntity.getPojoName(), FormatName.PojoName, 1);
    }

    public String getMethodName(ColumnEntity columnEntity) {
        return Table2PojoUtils.PojoName("_[a-z]",columnEntity.getColumnName(), FormatName.MethodName, 0);
    }

    public String getMemberName(ColumnEntity columnEntity) {
        return Table2PojoUtils.PojoName("_[a-z]",columnEntity.getColumnName(), FormatName.MemberName, 0);
    }

    public List<TableEntity> getTableEntities() {
        return tableEntities;
    }

    public void setTableEntities(List<TableEntity> tableEntities) {
        this.tableEntities = tableEntities;
    }

    public String getFileDirectory() {
        return fileDirectory;
    }

    public void setFileDirectory(String fileDirectory) {
        this.fileDirectory = fileDirectory;
    }

    public TableEntity getTableEntity() {
        return tableEntity;
    }

    public void setTableEntity(TableEntity tableEntity) {
        this.tableEntity = tableEntity;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
