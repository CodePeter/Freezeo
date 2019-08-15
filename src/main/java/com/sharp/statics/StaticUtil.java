package com.sharp.statics;

public class StaticUtil {


    public static String getName() {
        init();
        return init().getName();
    }

    public static OssClient init() {
        return new OssClient("kobe1", 10 , 200L);
    }

    public static void main(String[] args) {
        OssClient ossClient1 = StaticUtil.init();
        OssClient ossClient2 = StaticUtil.init();
        System.out.println(ossClient1.getName()+ossClient2.getName());
    }
}
