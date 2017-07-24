package ua.itea.dao;

import ua.itea.entity.Category;
import ua.itea.entity.SubCategory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubCategoryDAO extends AbstractDAO<SubCategory> {
    private final String NAME_TABLE = "sub_categories";

    public SubCategoryDAO() {
    }

    @Override
    protected SubCategory convertResultSetToEntity(ResultSet resultSet) throws SQLException {
        SubCategory subCategory = new SubCategory();
        subCategory.setId(resultSet.getLong("id"));
        subCategory.setUkrName(resultSet.getString("ukr_name"));
        subCategory.setEngName(resultSet.getString("eng_name"));
        return subCategory;
    }

    protected SubCategory convertResultSetToEntity(ResultSet resultSet, Category category) throws SQLException {
        SubCategory subCategory = new SubCategory();
        subCategory.setId(resultSet.getLong("id"));
        subCategory.setUkrName(resultSet.getString("ukr_name"));
        subCategory.setEngName(resultSet.getString("eng_name"));
        subCategory.setCategory(category);

        return subCategory;
    }

    @Override
    public Long create(SubCategory subCategory) {
        String sql = "INSERT INTO " + NAME_TABLE
                + " (category_id, ukr_name, eng_name)"
                + " VALUES (?, ?, ?)";
        log.info(sql);
        try {
            PreparedStatement statement = getPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, subCategory.getCategory().getId());
            statement.setString(2, subCategory.getUkrName());
            statement.setString(3, subCategory.getEngName());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Creating SubCategory failed, no rows affected.");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            } else {
                throw new SQLException("Creating SubCategory failed, no Id obtained.");
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            connectionClose();
        }
        return null;
    }

    @Override
    public boolean delete(SubCategory subCategory) {
        String sql = "DELETE FROM " + NAME_TABLE
                + " WHERE"
                + " id = '" + subCategory.getId() + "'";
        log.info(sql);
        try {
            if (getStatement().executeUpdate(sql) == 0) {
                throw new SQLException("Deleting SubCategory failed, no rows affected.");
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
    public boolean update(SubCategory subCategory) {
        String sql = "UPDATE " + NAME_TABLE + " "
                + " SET"
                + " category_id=?"
                + " ukr_name=?"
                + " eng_name=?"
                + " WHERE"
                + " id = " + subCategory.getId();
        log.info(sql);
        log.info(subCategory);
        try {
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setLong(1, subCategory.getCategory().getId());
            statement.setString(2, subCategory.getUkrName());
            statement.setString(3, subCategory.getEngName());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Updating SubCategory failed, no rows affected.");
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
    public SubCategory getEntityById(Long id) {
        String sql = "SELECT *" +
                " FROM " + NAME_TABLE +
                " WHERE" +
                " id = '" + id + "'" +
                ";";
        log.info(sql);
        try {
            ResultSet resultSet = getResultSet(sql);
            if (resultSet == null) {
                throw new SQLException("Retrieving SubCategory failed.");
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
    public List<SubCategory> getAll() {
        String sql = "SELECT * FROM " + NAME_TABLE + ";";
        log.info(sql);
        List<SubCategory> list = null;
        try {
            ResultSet resultSet = getResultSet(sql);
            if (resultSet == null) {
                throw new SQLException("Retrieving SubCategories failed.");
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

    public List<SubCategory> getAllByCategory(Category category) {
        String sql = "SELECT *" +
                " FROM " + NAME_TABLE +
                " WHERE" +
                " category_id = '" + category.getId() + "'" +
                ";";
        log.info(sql);
        List<SubCategory> list = null;
        try {
            ResultSet resultSet = getResultSet(sql);
            if (resultSet == null) {
                throw new SQLException("Retrieving SubCategories failed.");
            }
            list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(convertResultSetToEntity(resultSet, category));
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            connectionClose();
        }
        return list;
    }

}
