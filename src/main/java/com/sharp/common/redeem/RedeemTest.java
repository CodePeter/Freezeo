package com.sharp.common.redeem;

import org.apache.commons.codec.binary.Base64;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class RedeemTest {
    //每次生成结果一样
    public static String redeem1() {
        String ss = new Base64().encode((UUID.randomUUID().toString()).getBytes()).toString();

        ss = ss.replace("[B@", "");
        return ss;
    }

    public static String redeem2() {
        int  maxNum = 36;
        int i;
        int count = 0;
        char[] str = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        while(count < 8){
            i = Math.abs(r.nextInt(maxNum));
            if (i >= 0 && i < str.length) {
                sb.append(str[i]);
                count ++;
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(redeem1());
        Set<String> redeemSet = new HashSet<>();
        for (int i=0; i<10; i++) {
            redeemSet.add(redeem1());
            System.out.println(redeem1());
        }
        System.out.println(redeemSet.size());
    }
}
