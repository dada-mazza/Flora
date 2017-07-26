package ua.itea.dao;

import ua.itea.entity.CategoryEntity;
import ua.itea.entity.SubCategoryEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryEntity> {
    private final String NAME_TABLE = "categories";

    public CategoryDAO() {
    }

    @Override
    protected CategoryEntity convertResultSetToEntity(ResultSet resultSet) throws SQLException {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(resultSet.getLong("id"));
        categoryEntity.setUkrName(resultSet.getString("ukr_name"));
        categoryEntity.setEngName(resultSet.getString("eng_name"));
        List<SubCategoryEntity> subCategories = new SubCategoryDAO().getAllByCategory(categoryEntity);
        // categoryEntity.setSubCategories(subCategories);

        return categoryEntity;
    }

    @Override
    public Long create(CategoryEntity categoryEntity) {
        String sql = "INSERT INTO " + NAME_TABLE
                + " (ukr_name, eng_name)"
                + " VALUES (?, ?)";
        log.info(sql);
        try {
            PreparedStatement statement = getPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, categoryEntity.getUkrName());
            statement.setString(2, categoryEntity.getEngName());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Creating CategoryEntity failed, no rows affected.");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            } else {
                throw new SQLException("Creating CategoryEntity failed, no Id obtained.");
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            connectionClose();
        }
        return null;
    }

    @Override
    public boolean delete(CategoryEntity categoryEntity) {
        String sql = "DELETE FROM " + NAME_TABLE
                + " WHERE"
                + " id = '" + categoryEntity.getId() + "'";
        log.info(sql);
        try {
            if (getStatement().executeUpdate(sql) == 0) {
                throw new SQLException("Deleting CategoryEntity failed, no rows affected.");
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
    public boolean update(CategoryEntity categoryEntity) {
        String sql = "UPDATE " + NAME_TABLE + " "
                + " SET"
                + " ukr_name=?"
                + " eng_name=?"
                + " WHERE"
                + " id = " + categoryEntity.getId();
        log.info(sql);
        log.info(categoryEntity);
        try {
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setString(1, categoryEntity.getUkrName());
            statement.setString(2, categoryEntity.getEngName());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Updating CategoryEntity failed, no rows affected.");
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
    public CategoryEntity getEntityById(Long id) {
        String sql = "SELECT *" +
                " FROM " + NAME_TABLE +
                " WHERE" +
                " id = '" + id + "'" +
                ";";
        log.info(sql);
        try {
            ResultSet resultSet = getResultSet(sql);
            if (resultSet == null) {
                throw new SQLException("Retrieving CategoryEntity failed.");
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
    public List<CategoryEntity> getAll() {
        List<CategoryEntity> list = null;
        String sql = "SELECT * FROM " + NAME_TABLE + ";";
        log.info(sql);
        try {
            ResultSet resultSet = getResultSet(sql);
            if (resultSet == null) {
                throw new SQLException("Retrieving Categories failed.");
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
