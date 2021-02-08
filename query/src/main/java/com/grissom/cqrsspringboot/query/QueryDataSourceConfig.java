package com.grissom.cqrsspringboot.query;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author Grissom
 * @date 2/3/2021 7:04 PM
 **/
@Configuration
@MapperScan(basePackages = "com.grissom.cqrsspringboot.query.dao", sqlSessionFactoryRef = "querySqlSessionFactory")
public class QueryDataSourceConfig {
    @Bean(name = "queryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.query")
    public DataSource getQueryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("querySqlSessionFactory")
    public SqlSessionFactory querySqlSessionFactory(MybatisProperties mybatisProperties) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(getQueryDataSource());
//        bean.setConfigurationProperties(mybatisProperties.getConfiguration().getVariables());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "queryTransactionManager")
    public DataSourceTransactionManager queryTransactionManager(@Qualifier("queryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "querySqlSessionTemplate")
    public SqlSessionTemplate querySqlSessionTemplate(@Qualifier("querySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
