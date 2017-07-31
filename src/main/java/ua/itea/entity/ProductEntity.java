package ua.itea.entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "ProductEntity.getAll",
                query = "select products from ProductEntity products"),
        @NamedQuery(name = "ProductEntity.getProductsByCategory",
                query = "select products from ProductEntity products where products.category = :category"),
        @NamedQuery(name = "ProductEntity.getProductsBySubCategory",
                query = "select products from ProductEntity products where products.subCategory = :subCategory")
})

public class ProductEntity implements FloraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", unique = true, nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id")
    private SubCategoryEntity subCategory;

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category.getId() +
                ", subCategory=" + (subCategory == null ? "" : subCategory.getId()) +
                '}';
    }

    private Integer quantity;

    public Integer getTotalAmount() {

        Integer totalAmount = 0;
        if (price != null && quantity != null) {
            totalAmount = price * quantity;
        }
        return totalAmount;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductEntity that = (ProductEntity) o;

        if (!id.equals(that.id)) {
            return false;
        }

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}