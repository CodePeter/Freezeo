package com.sharp.freezeo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteJavaFile {

    private GenerateJavaFile generateJavaFile;
    private File file;
    private List<String> lines = new ArrayList<>();
    private TableEntity tableEntity;
    private List<ColumnEntity> columnEntities;

    public WriteJavaFile(GenerateJavaFile generateJavaFile) {
        this.generateJavaFile = generateJavaFile;
        this.file = generateJavaFile.getFile();
//        this.lines = lines;
        this.tableEntity = generateJavaFile.getTableEntity();
        this.columnEntities = tableEntity.getColumnEntityList();
    }

    public void writeClassNameInfo() throws IOException {
        writeTableAnnotation();
        writeClassStart();
        writeMembers();
        writeMethods();
        writeClassEnd();
        FileUtils.writeLines(file, "utf-8", lines, "\r\n", false);
    }

    public void writeTableAnnotation() throws IOException {
        String tableAnnotation = "@Table(\""+generateJavaFile.getTableName()+"\")";
        String pKAnnotation = "@PK(\"id\")";
        lines.add(tableAnnotation);
        lines.add(pKAnnotation);
//        FileUtils.writeStringToFile(file, tableAnnotation, "utf-8", true);
//        FileUtils.writeStringToFile(file, pKAnnotation, "utf-8", true);
    }

    public void writeClassStart() throws IOException {
        String firstLine = "public class "+generateJavaFile.getFileName()+" {";
//        FileUtils.writeStringToFile(file, firstLine, "utf-8", true);
        lines.add(firstLine);
    }

    public void writeClassEnd() throws IOException {
//        FileUtils.writeStringToFile(file, "}", "utf-8", true);
        lines.add(endLine());
    }

    public void writeMembers() {
        for(ColumnEntity columnEntity : columnEntities) {
            writeMemberAnnotation(columnEntity);
        }
    }

    public void writeMemberAnnotation(ColumnEntity columnEntity) {
        String memberAnnotation = "@Column(\""+columnEntity.getColumnName()+"\")";
        String memberLine = "private "+columnEntity.getPojoType()+" "+columnEntity.getMemeberName()+";";
        lines.add(memberAnnotation);
        lines.add(memberLine);
    }

    public void writeMethods() {
        for(ColumnEntity columnEntity : columnEntities) {
            writeMethods(columnEntity);
        }
    }

    public void writeMethods(ColumnEntity columnEntity) {
        String getMethod1 = "public "+columnEntity.getPojoType()+" get"+columnEntity.getMethodName()+"() {";
        String getMethod2 = "return "+columnEntity.getMemeberName()+";";
        lines.add(getMethod1);
        lines.add(getMethod2);
        lines.add(endLine());
        String setMethod1 = "public void set"+columnEntity.getMethodName()+"("+columnEntity.getPojoType()+" id) {";
        String setMethod2 = "this."+columnEntity.getMemeberName()+" = "+columnEntity.getMemeberName()+";";
        lines.add(setMethod1);
        lines.add(setMethod2);
        lines.add(endLine());
    }

    public String endLine() {
        return "}";
    }

    public GenerateJavaFile getGenerateJavaFile() {
        return generateJavaFile;
    }

    public void setGenerateJavaFile(GenerateJavaFile generateJavaFile) {
        this.generateJavaFile = generateJavaFile;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }
}
