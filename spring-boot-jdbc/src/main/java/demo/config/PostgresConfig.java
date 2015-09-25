package demo.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
public class PostgresConfig {

    @Value("${postgres.url}")
    private String jdbcUrl;

    @Value("${postgres.username}")
    private String jdbcUsername;

    @Value("${postgres.password}")
    private String jdbcPassword;

    @Value("${postgres.driverClass}")
    private String driverClass;
/*
    @Value("${postgres.idleMaxAgeInMinutes}")
    private Integer idleMaxAgeInMinutes;

    @Value("${postgres.idleConnectionTestPeriodInMinutes}")
    private Integer idleConnectionTestPeriodInMinutes;

    @Value("${postgres.maxConnectionsPerPartition}")
    private Integer maxConnectionsPerPartition;

    @Value("${postgres.minConnectionsPerPartition}")
    private Integer minConnectionsPerPartition;

    @Value("${postgres.partitionCount}")
    private Integer partitionCount;

    @Value("${postgres.acquireIncrement}")
    private Integer acquireIncrement;

    @Value("${postgres.statementsCacheSize}")
    private Integer statementsCacheSize;
    */

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();        
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        /*
        dataSource.setAcquireIncrement(acquireIncrement);
        dataSource.setMinPoolSize(minConnectionsPerPartition);
        dataSource.setMaxPoolSize(maxConnectionsPerPartition);
        dataSource.setIdleConnectionTestPeriod(idleConnectionTestPeriodInMinutes);
        */
        return dataSource;
    }

}