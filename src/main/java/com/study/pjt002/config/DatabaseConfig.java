package com.study.pjt002.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * packageName    : com.study.pjt002.config
 * fileName       : DatabaseConfig
 * author         : dotdot
 * date           : 2024-10-03
 * description    : 스프링에 properties에서 MyBatis 설정을 읽을 수 있도록 빈(Bean)을 선언해줌.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-03        dotdot       최초 생성
 */
@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfig {

    @Autowired
    private ApplicationContext context;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setMapperLocations(context.getResources("classpath:/mappers/**/*Mapper.xml")); // Mapper 파일 경로.
        factoryBean.setConfiguration(mybatisConfig()); // mybatisConfig() Bean을 이용하여 MyBatis 옵션을 설정.
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis.configuration")
    // application.properties에서 mybatis.configuration으로 시작하는 모든 설정을 읽어 스프링 컨테이너에 Bean으로 등록함.
    public org.apache.ibatis.session.Configuration mybatisConfig() {
        return new org.apache.ibatis.session.Configuration();
    }

}
