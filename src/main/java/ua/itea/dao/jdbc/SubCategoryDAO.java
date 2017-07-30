package ua.itea.dao.jdbc;

import ua.itea.entity.CategoryEntity;
import ua.itea.entity.SubCategoryEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubCategoryDAO extends AbstractDAO<SubCategoryEntity> {
    private final String NAME_TABLE = "sub_categories";

    public SubCategoryDAO() {
    }

    @Override
    protected SubCategoryEntity convertResultSetToEntity(ResultSet resultSet) throws SQLException {
        SubCategoryEntity subCategoryEntity = new SubCategoryEntity();
        subCategoryEntity.setId(resultSet.getLong("id"));
        subCategoryEntity.setName(resultSet.getString("name"));
        return subCategoryEntity;
    }

    protected SubCategoryEntity convertResultSetToEntity(ResultSet resultSet, CategoryEntity category) throws SQLException {
        SubCategoryEntity subCategoryEntity = new SubCategoryEntity();
        subCategoryEntity.setId(resultSet.getLong("id"));
        subCategoryEntity.setName(resultSet.getString("name"));
        subCategoryEntity.setCategory(category);

        return subCategoryEntity;
    }

    @Override
    public Long create(SubCategoryEntity subCategory) {
        String sql = "INSERT INTO " + NAME_TABLE
                + " (category_id, name)"
                + " VALUES (?, ?)";
        log.info(sql);
        try {
            PreparedStatement statement = getPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(2, subCategory.getName());

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
            close();
        }
        return null;
    }

    @Override
    public void delete(SubCategoryEntity subCategory) {
        String sql = "DELETE FROM " + NAME_TABLE
                + " WHERE"
                + " id = '" + subCategory.getId() + "'";
        log.info(sql);
        try {
            if (getStatement().executeUpdate(sql) == 0) {
                throw new SQLException("Deleting SubCategory failed, no rows affected.");
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            close();
        }
    }

    @Override
    public SubCategoryEntity update(SubCategoryEntity subCategory) {
        String sql = "UPDATE " + NAME_TABLE + " "
                + " SET"
                + " category_id=?"
                + " name=?"
                + " WHERE"
                + " id = " + subCategory.getId();
        log.info(sql);
        log.info(subCategory);
        try {
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setLong(1, subCategory.getCategory().getId());
            statement.setString(2, subCategory.getName());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Updating SubCategory failed, no rows affected.");
            }

        } catch (SQLException e) {
            log.error(e);
        } finally {
            close();
        }
        return subCategory;
    }

    @Override
    public SubCategoryEntity getEntityById(Class<SubCategoryEntity> entityClass, Long id) {
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
            close();
        }
        return null;
    }

    @Override
    public List<SubCategoryEntity> getAll(Class<SubCategoryEntity> entityClass) {
        String sql = "SELECT * FROM " + NAME_TABLE + ";";
        log.info(sql);
        List<SubCategoryEntity> list = null;
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
            close();
        }
        return list;
    }

    public List<SubCategoryEntity> getAllByCategory(CategoryEntity categoryEntity) {
        String sql = "SELECT *" +
                " FROM " + NAME_TABLE +
                " WHERE" +
                " category_id = '" + categoryEntity.getId() + "'" +
                ";";
        log.info(sql);
        List<SubCategoryEntity> list = null;
        try {
            ResultSet resultSet = getResultSet(sql);
            if (resultSet == null) {
                throw new SQLException("Retrieving SubCategories failed.");
            }
            list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(convertResultSetToEntity(resultSet, categoryEntity));
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            close();
        }
        return list;
    }

}
