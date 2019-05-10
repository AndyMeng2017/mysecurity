package com.imooc.security.core.validate.code.sms;

/**
 * @Author: mhn
 * @Date: 2019/5/9 21:34
 * @Version 1.0
 * @Software: IntelliJ IDEA
 */
public interface SmsCodeSender {
    void send(String mobile, String code);
}
