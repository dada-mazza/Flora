package ua.itea.dao;

import org.joda.time.DateTime;
import ua.itea.entity.Gender;
import ua.itea.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<User> {

    private final String NAME_TABLE = "users";

    public UserDAO() {
    }

    @Override
    protected User convertResultSetToEntity(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("second_name"));
        user.setDateOfBirth(new DateTime(resultSet.getDate("date_of_birth")));
        user.setGender(Gender.valueOf(resultSet.getString("gender")));
        user.setAddress(resultSet.getString("address"));
        user.setCity(resultSet.getString("city"));
        user.setPhoneNumber(resultSet.getString("phone_number"));
        user.setAdditionalInformation(resultSet.getString("additional_information"));
        return user;
    }

    @Override
    public Long create(User user) {

        String sql = "INSERT INTO " + NAME_TABLE
                + " (email,"
                + " password,"
                + " first_name,"
                + " second_name,"
                + " date_of_birth,"
                + " gender,"
                + " address,"
                + " city,"
                + " phone_number,"
                + " additional_information)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        log.info(sql);
        try {
            PreparedStatement statement = getPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setDate(5, new Date(user.getDateOfBirth().getMillis()));
            statement.setString(6, user.getGender().name());
            statement.setString(7, user.getAddress());
            statement.setString(8, user.getCity());
            statement.setString(9, user.getPhoneNumber());
            statement.setString(10, user.getAdditionalInformation());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Creating User failed, no rows affected.");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            } else {
                throw new SQLException("Creating User failed, no Id obtained.");
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            connectionClose();
        }
        return null;
    }

    @Override
    public boolean delete(User user) {
        String sql = "DELETE FROM " + NAME_TABLE
                + " WHERE"
                + " id = '" + user.getId() + "'";
        log.info(sql);
        try {
            if (getStatement().executeUpdate(sql) == 0) {
                throw new SQLException("Deleting User failed, no rows affected.");
            }
            return true;
        } catch (SQLException e) {
            log.error(e);
        } finally {
            connectionClose();
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        String sql = "UPDATE " + NAME_TABLE + " "
                + " SET email=?,"
                + " password=?,"
                + " first_name=?,"
                + " second_name=?,"
                + " date_of_birth=?,"
                + " gender=?,"
                + " address=?,"
                + " city=?,"
                + " phone_number=?,"
                + " additional_information=?)"
                + " WHERE"
                + " id = " + user.getId();
        log.info(sql);
        log.info(user);
        try {
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setDate(5, new Date(user.getDateOfBirth().getMillis()));
            statement.setString(6, user.getGender().name());
            statement.setString(7, user.getAddress());
            statement.setString(8, user.getCity());
            statement.setString(9, user.getPhoneNumber());
            statement.setString(10, user.getAdditionalInformation());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Updating User failed, no rows affected.");
            }
            return true;
        } catch (SQLException e) {
            log.error(e);
        } finally {
            connectionClose();
        }
        return false;
    }

    private User getEntityFromExecuteQuery(String sql) {
        try {
            ResultSet resultSet = getResultSet(sql);
            if (resultSet == null) {
                throw new SQLException("Retrieving User failed.");
            }
            while (resultSet.next()) {
                return convertResultSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            connectionClose();
        }
        return null;
    }

    @Override
    public User getEntityById(Long id) {
        String sql = "SELECT *" +
                " FROM " + NAME_TABLE +
                " WHERE" +
                " id = '" + id + "'" +
                ";";
        log.info(sql);
        return getEntityFromExecuteQuery(sql);
    }

    public User getEntityByEmail(String email) {
        String sql = "SELECT *" +
                " FROM " + NAME_TABLE +
                " WHERE" +
                " email = '" + email + "'" +
                ";";
        log.info(sql);
        return getEntityFromExecuteQuery(sql);
    }

    @Override
    public List<User> getAll() {
        List<User> list = null;
        String sql = "SELECT * FROM " + NAME_TABLE + ";";
        log.info(sql);
        try {
            ResultSet resultSet = getResultSet(sql);
            if (resultSet == null) {
                throw new SQLException("Retrieving Users failed.");
            }
            list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(convertResultSetToEntity(resultSet));
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            connectionClose();
        }
        return list;
    }

}
