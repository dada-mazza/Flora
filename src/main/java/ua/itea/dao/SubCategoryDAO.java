package ua.itea.dao;

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
        subCategoryEntity.setUkrName(resultSet.getString("ukr_name"));
        subCategoryEntity.setEngName(resultSet.getString("eng_name"));
        return subCategoryEntity;
    }

    protected SubCategoryEntity convertResultSetToEntity(ResultSet resultSet, CategoryEntity categoryEntity) throws SQLException {
        SubCategoryEntity subCategoryEntity = new SubCategoryEntity();
        subCategoryEntity.setId(resultSet.getLong("id"));
        subCategoryEntity.setUkrName(resultSet.getString("ukr_name"));
        subCategoryEntity.setEngName(resultSet.getString("eng_name"));
        subCategoryEntity.setCategoryEntity(categoryEntity);

        return subCategoryEntity;
    }

    @Override
    public Long create(SubCategoryEntity subCategoryEntity) {
        String sql = "INSERT INTO " + NAME_TABLE
                + " (category_id, ukr_name, eng_name)"
                + " VALUES (?, ?, ?)";
        log.info(sql);
        try {
            PreparedStatement statement = getPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, subCategoryEntity.getCategoryEntity().getId());
            statement.setString(2, subCategoryEntity.getUkrName());
            statement.setString(3, subCategoryEntity.getEngName());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Creating SubCategoryEntity failed, no rows affected.");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            } else {
                throw new SQLException("Creating SubCategoryEntity failed, no Id obtained.");
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            connectionClose();
        }
        return null;
    }

    @Override
    public boolean delete(SubCategoryEntity subCategoryEntity) {
        String sql = "DELETE FROM " + NAME_TABLE
                + " WHERE"
                + " id = '" + subCategoryEntity.getId() + "'";
        log.info(sql);
        try {
            if (getStatement().executeUpdate(sql) == 0) {
                throw new SQLException("Deleting SubCategoryEntity failed, no rows affected.");
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
    public boolean update(SubCategoryEntity subCategoryEntity) {
        String sql = "UPDATE " + NAME_TABLE + " "
                + " SET"
                + " category_id=?"
                + " ukr_name=?"
                + " eng_name=?"
                + " WHERE"
                + " id = " + subCategoryEntity.getId();
        log.info(sql);
        log.info(subCategoryEntity);
        try {
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setLong(1, subCategoryEntity.getCategoryEntity().getId());
            statement.setString(2, subCategoryEntity.getUkrName());
            statement.setString(3, subCategoryEntity.getEngName());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Updating SubCategoryEntity failed, no rows affected.");
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
    public SubCategoryEntity getEntityById(Long id) {
        String sql = "SELECT *" +
                " FROM " + NAME_TABLE +
                " WHERE" +
                " id = '" + id + "'" +
                ";";
        log.info(sql);
        try {
            ResultSet resultSet = getResultSet(sql);
            if (resultSet == null) {
                throw new SQLException("Retrieving SubCategoryEntity failed.");
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
    public List<SubCategoryEntity> getAll() {
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
            connectionClose();
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
            connectionClose();
        }
        return list;
    }

}
