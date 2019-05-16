package com.imooc.security.core.social.qq.connet;

import com.imooc.security.core.social.qq.api.QQ;
import com.imooc.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @Author: mhn
 * @Date: 2019/5/16 14:25
 * @Version 1.0
 * @Software: IntelliJ IDEA
 */
public class QQAdapter implements ApiAdapter<QQ> {

    @Override
    public boolean test(QQ api) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        QQUserInfo userInfo = api.getUserInfo();

        // 昵称
        values.setDisplayName(userInfo.getNickname());
        // 用户头像
        values.setImageUrl(userInfo.getFigureurl_qq_1());
        // 设置用户的主页url
        values.setProfileUrl(null);
        // 服务商的用户id
        values.setProviderUserId(userInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ api) {
        return null;
    }

    /**
     * 类似发送一个消息到用户主页，例如qq没有相关的设置，时间线，主页等信息
     * @param api
     * @return
     */
    @Override
    public void updateStatus(QQ api, String message) {
        // do nothing
    }
}
