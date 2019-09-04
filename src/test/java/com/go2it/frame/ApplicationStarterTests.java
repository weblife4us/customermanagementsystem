package com.go2it.frame;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zaxxer.hikari.HikariDataSource;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationStarterTests {

    @Autowired
    private DataSource dataSource;

    @DisplayName("Should show that the connection with DB is established and works fine")
    @Test
    public void hikariConnectionPoolIsConfigured() {
        assertAll(() -> {
            assertEquals("com.zaxxer.hikari.HikariDataSource", dataSource.getClass().getName());
            assertEquals("com.microsoft.sqlserver.jdbc.SQLServerDriver", ((HikariDataSource) dataSource).getDriverClassName());
        });
    }



}
