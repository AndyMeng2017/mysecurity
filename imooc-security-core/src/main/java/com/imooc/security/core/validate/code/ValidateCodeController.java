package com.imooc.security.core.validate.code;

import com.imooc.security.core.properties.SecurityConstants;
import com.imooc.security.core.validate.code.image.ImageCode;
import com.imooc.security.core.validate.code.sms.SmsCodeSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: mhn
 * @Date: 2019/5/8 20:07
 * @Version 1.0
 * @Software: IntelliJ IDEA
 */
@RestController
public class ValidateCodeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    @Autowired
    protected AuthenticationFailureHandler imoocAuthenticationFailureHandler;

    /**
     * 创建验证码，根据验证码类型不同，调用不同的 {@link ValidateCodeProcessor}接口实现
     *
     * @param request
     * @param response
     * @param type
     * @throws Exception
     */
    @GetMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
        try {
            // 这里已经决定验证码生成器为什么了
            validateCodeProcessorHolder.findValidateCodeProcessor(type).create(new ServletWebRequest(request, response));
            logger.info("生成" + type + "验证码通过");
        } catch (ValidateCodeException exception) {
            imoocAuthenticationFailureHandler.onAuthenticationFailure(request, response, exception);
            return;
        }

    }
}
