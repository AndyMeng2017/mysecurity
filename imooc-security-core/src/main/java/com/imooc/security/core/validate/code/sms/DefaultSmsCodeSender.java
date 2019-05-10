package com.imooc.security.core.validate.code.sms;

/**
 * @Author: mhn
 * @Date: 2019/5/9 21:36
 * @Version 1.0
 * @Software: IntelliJ IDEA
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机"+ mobile +"发送短信验证码" + code);
    }
}
