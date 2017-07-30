package ua.itea.dao.jdbc.manager;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Клас реалізує підключення до Бази данних
 */
public class LocalManagerJDBC implements ManagerJDBC {

    private Log log = LogFactory.getLog(getClass());

    private final String URL = "jdbc:postgresql://localhost:5432/flora";
    private final String LOGIN = "postgres";
    private final String PASSWORD = "postgres";


    public LocalManagerJDBC() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
    }

    private Connection connection;

    @Override
    public Connection getConnection() throws SQLException {
        log.info(URL);
        connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        return connection;
    }

    @Override
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
