package ua.itea.dao;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Клас реалізує підключення до Бази данних
 */
public class ManagerJDBC {

    private Log log = LogFactory.getLog(getClass());

    private final String URL = "jdbc:postgresql://ec2-79-125-5-199.eu-west-1.compute.amazonaws.com:5432/dcogjakbcm9051";
    private final String LOGIN = "clbkfqyykwplrn";
    private final String PASSWORD = "861835dc32f50fb4199319fd404196b29906cd9bf97b768f7074c27a71ee8eb9";

    public ManagerJDBC() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
    }

    private Connection connection;

    public Connection getConnection() throws SQLException {
        log.info(URL);
        connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        return connection;
    }

    public void connectionClose() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error(e);
            }
        }
    }
}
