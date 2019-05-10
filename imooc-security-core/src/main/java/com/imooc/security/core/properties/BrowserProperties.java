package com.imooc.security.core.properties;

public class BrowserProperties {
    private String loginPage = "/imooc-signIn.html";

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
}
