package com.imooc.code;

import com.imooc.security.core.validate.code.ImageCode;
import com.imooc.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: mhn
 * @Date: 2019/5/8 22:46
 * @Version 1.0
 * @Software: IntelliJ IDEA
 */
@Component(value = "imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}
