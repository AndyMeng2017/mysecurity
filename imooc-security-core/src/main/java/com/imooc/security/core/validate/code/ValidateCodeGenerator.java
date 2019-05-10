package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: mhn
 * @Date: 2019/5/8 22:26
 * @Version 1.0
 * @Software: IntelliJ IDEA
 */
public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest request);
}
