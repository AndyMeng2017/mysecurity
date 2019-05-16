package com.imooc.security.core.properties;

/**
 * @Author: mhn
 * @Date: 2019/5/16 14:18
 * @Version 1.0
 * @Software: IntelliJ IDEA
 */
public class SocialProperties {
    private QQProperties qq = new QQProperties();

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }
}
