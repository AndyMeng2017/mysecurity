package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: mhn
 * @Date: 2019/5/9 22:06
 * @Version 1.0
 * @Software: IntelliJ IDEA
 */
public interface ValidateCodeProcessor {
    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;
}
