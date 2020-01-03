package com.sharp.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplacePhone {
    public static void main(String[] args) {
//        String phone = "12345678901";
//        String phone = "12345";
//        int length = phone.length();
//        if (length >= 6) {
//            int asterisk = 4;
//            int front = (length - 4) / 2;
//            int back = length - front - asterisk;
//            String pattern = "(\\d{" + front + "})\\d{" + asterisk + "}(\\d{" + back + "})";
//            Pattern r = Pattern.compile(pattern);
//            Matcher m = r.matcher(phone);
//            if (m.find( )) {
//                System.out.println("Found value: " + m.group(0) );
//                System.out.println("Found value: " + m.group(1) );
//                System.out.println("Found value: " + m.group(2) );
//            } else {
//                System.out.println("NO MATCH");
//            }
//        } else {
//            String first = phone.substring(0, 1);
//            String last = phone.replaceAll("\\d","*");
//            System.out.println(first+last.substring(1));
//        }
        String email = "370460199@zhaopin.com.cn";
        int indexAt = email.indexOf("@");
        String beforeAt = email.substring(0, indexAt);
        System.out.println(beforeAt.substring(0, 2) + "****" +
                beforeAt.substring(beforeAt.length() - 2) + email.substring(indexAt));
    }
}
