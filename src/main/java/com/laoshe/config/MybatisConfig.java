package com.laoshe.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.laoshe.security.DesUtil;
/**

* 数据库登陆及分页插件注册
* @author hanyawei
* @Time 2018-11-13 23:00
*
*/

@Configuration
@EnableTransactionManagement
public class MybatisConfig {
	private static Logger logger = LoggerFactory.getLogger(MybatisConfig.class);
	
	@Autowired
	private DruidConfig duridConfig;
	@Bean(name="dataSource")
	public DataSource druidDataSource(){
		DruidDataSource druidDataSource = new DruidDataSource();
		try {
			druidDataSource.setDriverClassName(duridConfig.getDriverClassName());
			druidDataSource.setUrl(duridConfig.getUrl());
			druidDataSource.setUsername(duridConfig.getUserName());
			druidDataSource.setPassword(DesUtil.decrypt(duridConfig.getPassword()));
			druidDataSource.setMaxActive(duridConfig.getMaxActive());
			druidDataSource.setMinIdle(duridConfig.getMinIdle());
			druidDataSource.setInitialSize(duridConfig.getInitialSize());
			druidDataSource.setMaxWait(duridConfig.getMaxWait());
			druidDataSource.setTimeBetweenEvictionRunsMillis(duridConfig.getTimeBetweenEvictionRunsMillis());
			druidDataSource.setPoolPreparedStatements(duridConfig.isPoolPreparedStatements());
			druidDataSource.setMaxOpenPreparedStatements(duridConfig.getMaxOpenPreparedStatements());
			druidDataSource.setFilters(duridConfig.getFilters());
			druidDataSource.setMinEvictableIdleTimeMillis(duridConfig.getMinEvictableIdleTimeMillis());
			druidDataSource.setTestOnBorrow(duridConfig.isTestOnBorrow());
			druidDataSource.setValidationQuery(duridConfig.getValidationQuery());
			druidDataSource.setValidationQueryTimeout(duridConfig.getValidationQueryTimeout());
		} catch (Exception e) {
			logger.error("SQLException", e);
		}
		return druidDataSource;
	}
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(druidDataSource());
		sqlSessionFactoryBean.setTypeHandlersPackage("classpath:mapper/*.xml");
		//分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("rowBoundsWithCount", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		pageHelper.setProperties(properties);
		//添加插件
		sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	@Bean
	public PlatformTransactionManager transactionMangger(){
		return new DataSourceTransactionManager(druidDataSource());
	}
	@Bean(name="sqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
