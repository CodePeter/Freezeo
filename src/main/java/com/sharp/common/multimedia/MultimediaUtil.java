package com.sharp.common.multimedia;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;

public class MultimediaUtil {

    /**
     * 音频文件获取文件时长
     *
     * @param source
     * @return
     */
    public static Long getDuration(File source) {

        Encoder encoder = new Encoder();
        long ls = 0;
        MultimediaInfo m;
        try {
            m = encoder.getInfo(source);
            ls = m.getDuration() / 1000;

        } catch (Exception e) {
            System.out.println("获取音频时长有误：" + e.getMessage());
        }
        return ls;
    }

    public static void main(String[] args) {
        File videoFile = new File("C:\\Users\\chen.chang\\Desktop\\嗯哈.mp4");
//        File audioFile = new File("C:\\Users\\chen.chang\\Desktop\\绿茶.mp3");

        System.out.println(MultimediaUtil.getDuration(videoFile));
//        System.out.println(MultimediaUtil.getDuration(audioFile));
    }
}
