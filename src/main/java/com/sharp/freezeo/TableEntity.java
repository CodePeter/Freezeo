package com.sharp.freezeo;

import java.util.List;

public class TableEntity {

    private String pojoName;
    private String tableName;
    private List<ColumnEntity> columnEntityList;

    public String getPojoName() {
        return pojoName;
    }

    public void setPojoName(String pojoName) {
        this.pojoName = pojoName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnEntity> getColumnEntityList() {
        return columnEntityList;
    }

    public void setColumnEntityList(List<ColumnEntity> columnEntityList) {
        this.columnEntityList = columnEntityList;
    }
}
