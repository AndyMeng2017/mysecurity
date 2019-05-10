package com.imooc.security.core.properties;

/**
 * @Author: mhn
 * @Date: 2019/5/8 21:35
 * @Version 1.0
 * @Software: IntelliJ IDEA
 */
public class ImageCodeProperties extends SmsCodeProperties {
    private int width = 80;
    private int height = 30;

    public ImageCodeProperties(){
        setLength(4);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
