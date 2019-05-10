package com.imooc.security.core.properties;

/**
 * @Author: mhn
 * @Date: 2019/5/8 21:35
 * @Version 1.0
 * @Software: IntelliJ IDEA
 */
public class SmsCodeProperties {
    private int length = 4;
    private int expireIn = 60;
    private String url;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
