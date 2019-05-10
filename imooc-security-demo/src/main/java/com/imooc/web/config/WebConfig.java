package com.imooc.web.config;

import com.imooc.web.filter.TimeFilter;
import com.imooc.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TimeInterceptor timeInterceptor;

//    /**
//     * 监听异步请求处理
//     * @param configurer
//     */
//    @Override
//    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(timeInterceptor);
    }

    /**
     * 假设引入外部 filter ,没办法添加 @Component 注解 {@link TimeFilter}
     * @return
     */
//    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }

    @Primary
    @Bean(name ="prodDataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Bean(name = "prodJdbc")
//    public JdbcTemplate prodJdbcTemplate(@Qualifier("prodDataSource") DataSource prodDataSource){
//        return new JdbcTemplate(dataSource);
//    }
//
//    @Bean(name = "devDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.dev")
//    public DataSource devDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "devJdbc")
//    public JdbcTemplate devJdbcTemplate(@Qualifier("devDataSource") DataSource devDataSource) {
//        return new JdbcTemplate(devDataSource);
//    }
}
