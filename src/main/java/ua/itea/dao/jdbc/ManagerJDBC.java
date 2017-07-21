package ua.itea.dao.jdbc;


import java.sql.Connection;
import java.sql.SQLException;


/**
 * Клас реалізує підключення до Бази данних
 */
public interface ManagerJDBC {

    public Connection getConnection() throws SQLException;

    public void connectionClose();

}
