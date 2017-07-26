package ua.itea.dao;

import org.joda.time.DateTime;
import ua.itea.entity.UserEntity;
import ua.itea.entity.enumeratiom.Gender;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<UserEntity> {

    private final String NAME_TABLE = "users";

    public UserDAO() {
    }

    @Override
    protected UserEntity convertResultSetToEntity(ResultSet resultSet) throws SQLException {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(resultSet.getLong("id"));
        userEntity.setEmail(resultSet.getString("email"));
        userEntity.setPassword(resultSet.getString("password"));
        userEntity.setFirstName(resultSet.getString("first_name"));
        userEntity.setLastName(resultSet.getString("second_name"));
        userEntity.setDateOfBirth(new DateTime(resultSet.getDate("date_of_birth")));
        userEntity.setGender(Gender.valueOf(resultSet.getString("gender")));
        userEntity.setAddress(resultSet.getString("address"));
        userEntity.setCity(resultSet.getString("city"));
        userEntity.setPhoneNumber(resultSet.getString("phone_number"));
        userEntity.setAdditionalInformation(resultSet.getString("additional_information"));
        return userEntity;
    }

    @Override
    public Long create(UserEntity userEntity) {

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
            statement.setString(1, userEntity.getEmail());
            statement.setString(2, userEntity.getPassword());
            statement.setString(3, userEntity.getFirstName());
            statement.setString(4, userEntity.getLastName());
            statement.setDate(5, new Date(userEntity.getDateOfBirth().getMillis()));
            statement.setString(6, userEntity.getGender().name());
            statement.setString(7, userEntity.getAddress());
            statement.setString(8, userEntity.getCity());
            statement.setString(9, userEntity.getPhoneNumber());
            statement.setString(10, userEntity.getAdditionalInformation());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Creating UserEntity failed, no rows affected.");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            } else {
                throw new SQLException("Creating UserEntity failed, no Id obtained.");
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            connectionClose();
        }
        return null;
    }

    @Override
    public boolean delete(UserEntity userEntity) {
        String sql = "DELETE FROM " + NAME_TABLE
                + " WHERE"
                + " id = '" + userEntity.getId() + "'";
        log.info(sql);
        try {
            if (getStatement().executeUpdate(sql) == 0) {
                throw new SQLException("Deleting UserEntity failed, no rows affected.");
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
    public boolean update(UserEntity userEntity) {
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
                + " id = " + userEntity.getId();
        log.info(sql);
        log.info(userEntity);
        try {
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setString(1, userEntity.getEmail());
            statement.setString(2, userEntity.getPassword());
            statement.setString(3, userEntity.getFirstName());
            statement.setString(4, userEntity.getLastName());
            statement.setDate(5, new Date(userEntity.getDateOfBirth().getMillis()));
            statement.setString(6, userEntity.getGender().name());
            statement.setString(7, userEntity.getAddress());
            statement.setString(8, userEntity.getCity());
            statement.setString(9, userEntity.getPhoneNumber());
            statement.setString(10, userEntity.getAdditionalInformation());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Updating UserEntity failed, no rows affected.");
            }
            return true;
        } catch (SQLException e) {
            log.error(e);
        } finally {
            connectionClose();
        }
        return false;
    }

    private UserEntity getEntityFromExecuteQuery(String sql) {
        try {
            ResultSet resultSet = getResultSet(sql);
            if (resultSet == null) {
                throw new SQLException("Retrieving UserEntity failed.");
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
    public UserEntity getEntityById(Long id) {
        String sql = "SELECT *" +
                " FROM " + NAME_TABLE +
                " WHERE" +
                " id = '" + id + "'" +
                ";";
        log.info(sql);
        return getEntityFromExecuteQuery(sql);
    }

    public UserEntity getEntityByEmail(String email) {
        String sql = "SELECT *" +
                " FROM " + NAME_TABLE +
                " WHERE" +
                " email = '" + email + "'" +
                ";";
        log.info(sql);
        return getEntityFromExecuteQuery(sql);
    }

    @Override
    public List<UserEntity> getAll() {
        List<UserEntity> list = null;
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
