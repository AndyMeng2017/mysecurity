package com.imooc.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;
/**
 * @Author: mhn
 * @Date: 2019/5/16 14:19
 * @Version 1.0
 * @Software: IntelliJ IDEA
 */
public class QQProperties extends SocialProperties {
    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
