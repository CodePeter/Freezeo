package com.sharp.freezeo;

import com.sharp.freezeo.constants.FreezeoConstant;

public class ColumnEntity {

    private String memeberName;
    private String methodName;
    private String pojoType;
    private String columnName;
    private String columnType;

    public String getMemeberName() {
        return Table2PojoUtils.PojoName(FreezeoConstant.REGEX, columnName, FormatName.MethodName, 0);
    }

    public void setMemeberName(String memeberName) {
        this.memeberName = memeberName;
    }

    public String getMethodName() {
        return Table2PojoUtils.PojoName(FreezeoConstant.REGEX, columnName, FormatName.MemberName, 0);
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getPojoType() {
        return pojoType;
    }

    public void setPojoType(String pojoType) {
        this.pojoType = pojoType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }
}
