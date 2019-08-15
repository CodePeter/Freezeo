package com.sharp.statics;

public class OssClient {

    private String name;
    private int count;
    private Long duration;

    public OssClient(String name, int count, Long duration) {
        this.name = name;
        this.count = count;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
