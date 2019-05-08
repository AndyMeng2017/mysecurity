package com.imooc.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author: mhn
 * @Date: 2019/5/8 20:48
 * @Version 1.0
 * @Software: IntelliJ IDEA
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
