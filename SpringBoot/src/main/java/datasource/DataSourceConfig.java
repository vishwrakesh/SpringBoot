package datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
	@Value("${db.host}")
	String host;
	
	@Value("${db.port}")
	String port;
	
	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder builder = DataSourceBuilder.create();
		builder.driverClassName("org.hibernate.dialect.PostgreSQL9Dialect");
		builder.url("jdbc:postgresql://"+host+":"+port+"/postgres");
		builder.username("postgres");
		builder.password("password");
		return builder.build();
	}
}
