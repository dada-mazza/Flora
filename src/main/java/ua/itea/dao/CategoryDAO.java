package ua.itea.dao;

import ua.itea.entity.Category;
import ua.itea.entity.SubCategory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<Category> {
    private final String NAME_TABLE = "categories";

    public CategoryDAO() {
    }

    @Override
    protected Category convertResultSetToEntity(ResultSet resultSet) throws SQLException {
        Category category = new Category();
        category.setId(resultSet.getLong("id"));
        category.setUkrName(resultSet.getString("ukr_name"));
        category.setEngName(resultSet.getString("eng_name"));
        List<SubCategory> subCategories = new SubCategoryDAO().getAllByCategory(category);
        category.setSubCategories(subCategories);

        return category;
    }

    @Override
    public Long create(Category category) {
        String sql = "INSERT INTO " + NAME_TABLE
                + " (ukr_name, eng_name)"
                + " VALUES (?, ?)";
        log.info(sql);
        try {
            PreparedStatement statement = getPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, category.getUkrName());
            statement.setString(2, category.getEngName());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Creating Category failed, no rows affected.");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            } else {
                throw new SQLException("Creating Category failed, no Id obtained.");
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            connectionClose();
        }
        return null;
    }

    @Override
    public boolean delete(Category category) {
        String sql = "DELETE FROM " + NAME_TABLE
                + " WHERE"
                + " id = '" + category.getId() + "'";
        log.info(sql);
        try {
            if (getStatement().executeUpdate(sql) == 0) {
                throw new SQLException("Deleting Category failed, no rows affected.");
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
    public boolean update(Category category) {
        String sql = "UPDATE " + NAME_TABLE + " "
                + " SET"
                + " ukr_name=?"
                + " eng_name=?"
                + " WHERE"
                + " id = " + category.getId();
        log.info(sql);
        log.info(category);
        try {
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setString(1, category.getUkrName());
            statement.setString(2, category.getEngName());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Updating Category failed, no rows affected.");
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
    public Category getEntityById(Long id) {
        String sql = "SELECT *" +
                " FROM " + NAME_TABLE +
                " WHERE" +
                " id = '" + id + "'" +
                ";";
        log.info(sql);
        try {
            ResultSet resultSet = getResultSet(sql);
            if (resultSet == null) {
                throw new SQLException("Retrieving Category failed.");
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
    public List<Category> getAll() {
        List<Category> list = null;
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
