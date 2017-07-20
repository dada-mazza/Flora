package ua.itea.dao;

import ua.itea.entity.Gender;
import ua.itea.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        user.setFirstName(resultSet.getString("firstName"));
        user.setSecondName(resultSet.getString("secondName"));
        user.setRegion(resultSet.getString("region"));
        user.setGender(Gender.valueOf(resultSet.getString("gender")));
        user.setSubscription(resultSet.getBoolean("subscription"));
        return user;
    }

    @Override
    public Long create(User user) {

        String sql = "INSERT INTO " + NAME_TABLE
                + " (email, password, firstName, secondName, region, gender, subscription)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";

        log.info(sql);
        try {
            PreparedStatement statement = getPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getSecondName());
            statement.setString(5, user.getRegion());
            statement.setString(6, user.getGender().name());
            statement.setBoolean(7, user.isSubscription());

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
                + " SET email=?, password=?, firstName=?, secondName=?, region=?, gender=?, subscription=?"
                + " WHERE"
                + " id = " + user.getId();
        log.info(sql);
        log.info(user);
        try {
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getSecondName());
            statement.setString(5, user.getRegion());
            statement.setString(6, user.getGender().name());
            statement.setBoolean(7, user.isSubscription());

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

    private User getEntity(String sql) {
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
        return getEntity(sql);
    }

    public User getEntityByEmail(String email) {
        String sql = "SELECT *" +
                " FROM " + NAME_TABLE +
                " WHERE" +
                " email = '" + email + "'" +
                ";";
        log.info(sql);
        return getEntity(sql);
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
