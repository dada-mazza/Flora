package ua.itea.dao.jdbc;

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
        CategoryEntity category = new CategoryEntity();
        category.setId(resultSet.getLong("id"));
        category.setName(resultSet.getString("name"));
        List<SubCategoryEntity> subCategories = new SubCategoryDAO().getAllByCategory(category);
        category.setSubCategories(subCategories);

        return category;
    }

    @Override
    public Long create(CategoryEntity category) {
        String sql = "INSERT INTO " + NAME_TABLE
                + " (name)"
                + " VALUES (?)";
        log.info(sql);
        try {
            PreparedStatement statement = getPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, category.getName());

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
            close();
        }
        return null;
    }

    @Override
    public void delete(CategoryEntity category) {
        String sql = "DELETE FROM " + NAME_TABLE
                + " WHERE"
                + " id = '" + category.getId() + "'";
        log.info(sql);
        try {
            if (getStatement().executeUpdate(sql) == 0) {
                throw new SQLException("Deleting Category failed, no rows affected.");
            }

        } catch (SQLException e) {
            log.error(e);
        } finally {
            close();
        }
    }

    @Override
    public CategoryEntity update(CategoryEntity category) {
        String sql = "UPDATE " + NAME_TABLE + " "
                + " SET"
                + " name=?"
                + " WHERE"
                + " id = " + category.getId();
        log.info(sql);
        log.info(category);
        try {
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setString(1, category.getName());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Updating Category failed, no rows affected.");
            }
            return category;
        } catch (SQLException e) {
            log.error(e);
        } finally {
            close();
        }
        return null;
    }

    @Override
    public CategoryEntity getEntityById(Class<CategoryEntity> entityClass, Long id) {
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
            close();
        }
        return null;
    }

    @Override
    public List<CategoryEntity> getAll(Class<CategoryEntity> entityClass) {
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
            close();
        }
        return list;
    }

}
