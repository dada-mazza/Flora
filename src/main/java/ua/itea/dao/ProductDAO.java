package ua.itea.dao;

import ua.itea.entity.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends AbstractDAO<Product> {
    private final String NAME_TABLE = "products";

    public ProductDAO() {
    }

    @Override
    protected Product convertResultSetToEntity(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong("id"));
        product.setName(resultSet.getString("name"));
        product.setDescription(resultSet.getString("description"));
        product.setPrice(resultSet.getInt("price"));
        product.setCategory_id(resultSet.getLong("category_id"));
        return product;
    }

    @Override
    public Long create(Product product) {

        String sql = "INSERT INTO " + NAME_TABLE
                + " (name, description, price, category_id)"
                + " VALUES (?, ?, ?, ?)";

        log.info(sql);
        try {
            PreparedStatement statement = getPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setInt(3, product.getPrice());
            statement.setLong(4, product.getCategory_id());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Creating Product failed, no rows affected.");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            } else {
                throw new SQLException("Creating Product failed, no Id obtained.");
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            connectionClose();
        }
        return null;
    }

    @Override
    public boolean delete(Product product) {
        String sql = "DELETE FROM " + NAME_TABLE
                + " WHERE"
                + " id = '" + product.getId() + "'";
        log.info(sql);
        try {
            if (getStatement().executeUpdate(sql) == 0) {
                throw new SQLException("Deleting Product failed, no rows affected.");
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
    public boolean update(Product product) {
        String sql = "UPDATE " + NAME_TABLE + " "
                + " SET name=?, description=?, price=?, category_id=?"
                + " WHERE"
                + " id = " + product.getId();
        log.info(sql);
        log.info(product);
        try {
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setInt(3, product.getPrice());
            statement.setLong(4, product.getCategory_id());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Updating Product failed, no rows affected.");
            }
            return true;
        } catch (SQLException e) {
            log.error(e);
        } finally {
            connectionClose();
        }
        return false;
    }

    private Product getEntity(String sql) {
        try {
            ResultSet resultSet = getResultSet(sql);
            if (resultSet == null) {
                throw new SQLException("Retrieving Product failed.");
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
    public Product getEntityById(Long id) {
        String sql = "SELECT *" +
                " FROM " + NAME_TABLE +
                " WHERE" +
                " id = '" + id + "'" +
                ";";
        log.info(sql);
        return getEntity(sql);
    }

    private List<Product> getProducts(String sql) {
        try {
            ResultSet resultSet = getResultSet(sql);
            if (resultSet == null) {
                throw new SQLException("Retrieving Products failed.");
            }
            List<Product> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(convertResultSetToEntity(resultSet));
            }
            return list;
        } catch (SQLException e) {
            log.error(e);
        } finally {
            connectionClose();
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM " + NAME_TABLE + ";";
        log.info(sql);
        return getProducts(sql);
    }

    public List<Product> getAllByCategoryId(Long categoryId) {
        String sql = "SELECT * FROM " + NAME_TABLE +
                " WHERE" +
                " category_id = '" + categoryId + "'" +
                ";";
        log.info(sql);
        return getProducts(sql);
    }


}
