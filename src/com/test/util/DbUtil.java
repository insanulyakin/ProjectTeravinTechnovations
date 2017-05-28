package com.test.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
	private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties properties = new Properties();
                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
                properties.load(inputStream);
                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String user = "root";
                String password = "";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
				// TODO: handle exception
            } catch (SQLException e) {
                e.printStackTrace();
				// TODO: handle exception
            } catch (FileNotFoundException e) {
                e.printStackTrace();
				// TODO: handle exception
            } catch (IOException e) {
                e.printStackTrace();
				// TODO: handle exception
            }
            return connection;
        }

    }

}
