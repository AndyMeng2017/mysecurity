package com.imooc.security.browser;

import com.imooc.security.browser.authentication.ImoocAuthenticationFailureHandler;
import com.imooc.security.browser.authentication.ImoocAuthenticationSuccessHandler;
import com.imooc.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.imooc.security.core.properties.SecurityProperties;
import com.imooc.security.core.validate.code.SmsCodeFilter;
import com.imooc.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler imoocAuthenticationFailureHandler;

    @Autowired
    @Qualifier("prodDataSource")
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    /**
     * 同一个密码，每次加密结果是不一样的
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistenceTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        // 只有第一次打开
        //tokenRepository.setCreateTableOnStartup(true);
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(imoocAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        SmsCodeFilter smsCodeFilter = new SmsCodeFilter();
        smsCodeFilter.setAuthenticationFailureHandler(imoocAuthenticationFailureHandler);
        smsCodeFilter.setSecurityProperties(securityProperties);
        smsCodeFilter.afterPropertiesSet();

        http.addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                    // 自定义页面
    //                .loginPage("/imooc-signIn.html")
                    .loginPage("/authentication/require")
                    // 自定义 UsernamePasswordAuthenticationFilter 的拦截路径，默认为：/login
                    .loginProcessingUrl("/authentication/form")
                    // 自定义登录成功后的处理器，处理跳转
                    .successHandler(imoocAuthenticationSuccessHandler)
                    .failureHandler(imoocAuthenticationFailureHandler)
                    .and()
                .rememberMe()
                    .tokenRepository(persistenceTokenRepository())
                    .tokenValiditySeconds(securityProperties.getBrowser().getRemeberMeSeconds())
                    .userDetailsService(userDetailsService)
                    .and()
                .authorizeRequests()
                .antMatchers(
                        "/authentication/require",
                        securityProperties.getBrowser().getLoginPage(),
                        "/code/*"
                ).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                .apply(smsCodeAuthenticationSecurityConfig);
    }
}
