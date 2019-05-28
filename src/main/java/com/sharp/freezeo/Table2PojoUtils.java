package com.sharp.freezeo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Table2PojoUtils {

    //"_[a-z]","t_product_detail" TableName
    //"_[a-z]","product_id" ColumnName
    public static String PojoName(String regex, String name, int type) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher("_"+name);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb,m.group().substring(1,2).toUpperCase());
        }
        m.appendTail(sb);
        String fullName = sb.toString();
        //去掉首字母个数
        return fullName.substring(type);
    }

    public static String lowerInitial(String memberName) {
        String first = memberName.substring(0,1).toLowerCase();
        return first + memberName.substring(1);
    }

    public static String PojoName(String regex, String name, FormatName format, int type) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher("_"+name);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb,m.group().substring(1,2).toUpperCase());
        }
//        if(format.compareTo(FormatName.MethodName)==0) {
//            while(m.find()){
//                m.appendReplacement(sb,m.group().substring(1,2));
//            }
//        } else {
//            while(m.find()){
//                m.appendReplacement(sb,m.group().substring(1,2).toUpperCase());
//            }
//        }
        m.appendTail(sb);
        //去掉首字母个数
        String fullName = sb.toString().substring(type);

        if(format.compareTo(FormatName.MethodName)==0) {
            return lowerInitial(fullName);
        } else {
            return fullName;
        }

    }

//    public static String MemeberName(String regex, String name) {
//        Pattern p = Pattern.compile(regex);
//        Matcher m = p.matcher(name);
//        StringBuffer sb = new StringBuffer();
//        while(m.find()){
//            m.appendReplacement(sb,m.group().substring(1,2).toUpperCase());
//        }
//        m.appendTail(sb);
//        String fullName = sb.toString();
//        return fullName.
//    }

    public static void main(String[] args) {
//        String tableName = Table2PojoUtils.PojoName("_[a-z]","t_product_detail",1);
//        System.out.println(tableName);
//        String columnName = Table2PojoUtils.PojoName("_[a-z]","product_id",0);
//        System.out.println(columnName);
        //Product
        String pojoName = Table2PojoUtils.PojoName("_[a-z]","t_product",FormatName.PojoName, 1);
        System.out.println(pojoName);
        //productId
        String methodName = Table2PojoUtils.PojoName("_[a-z]","product_id",FormatName.MemberName, 0);
        System.out.println(methodName);
        //ProductId
        String memberName = Table2PojoUtils.PojoName("_[a-z]","product_id",FormatName.MethodName, 0);
        System.out.println(memberName);
    }
}
