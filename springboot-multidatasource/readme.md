# 异常情况
## jdbctemplate的多数据源配置
Access to DialectResolutionInfo cannot be null when 'hibernate.dialect' not set  
我在测试的时候出现上面的问题，主要是没有指定mysql mysql-connector-java的版本
```xml
	<dependencies>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.21</version>
		</dependency>
	</dependencies>
```
参考：https://gitee.com/didispace/SpringBoot-Learning/tree/master/Chapter3-2-3
