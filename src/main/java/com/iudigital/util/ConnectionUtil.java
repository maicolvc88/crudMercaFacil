package com.iudigital.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static final String URL = "jdbc:postgresql://ec2-34-192-210-139.compute-1.amazonaws.com:5432/d1h258bro32tnm";
    private static final String USER = "budfwxqrxugdxm";
    private static final String PASSWORD = "1cccc8bd00b7a5071a35915398dcabb16cfbd345b62fecc658d07e038caf4d92";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
