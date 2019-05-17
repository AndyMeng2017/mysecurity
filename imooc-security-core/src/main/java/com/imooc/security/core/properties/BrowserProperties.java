package com.imooc.security.core.properties;

public class BrowserProperties {
    private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

    private String signUpUrl = "/imooc-signUp.html";

    private LoginType loginType = LoginType.JSON;

    private int remeberMeSeconds = 3600;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public int getRemeberMeSeconds() {
        return remeberMeSeconds;
    }

    public void setRemeberMeSeconds(int remeberMeSeconds) {
        this.remeberMeSeconds = remeberMeSeconds;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }
}
