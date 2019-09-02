package com.project.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;

@SpringBootApplication
public class HelloworldApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(HelloworldApplication.class, args);


        Connection con = null;

        try {


            con = getConnection();

            System.out.println("Connection ok");


        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }


    }


    public static Connection getConnection() throws IOException, SQLException {
        Connection conn;
        Properties props = new Properties();
        try (BufferedReader in = Files.newBufferedReader(Paths.get("C:\\Users\\Hp\\IdeaProjects\\basic\\src\\main\\resources\\environment.propeties"), Charset.forName("UTF-8"))) {
            props.load(in);
        }
        String dbUrl = props.getProperty("dbUrlAddress");
        String userName = props.getProperty("userName");
        String pass = props.getProperty("password");
        conn = DriverManager.getConnection(dbUrl, userName, pass);
        return conn;
    }




}



