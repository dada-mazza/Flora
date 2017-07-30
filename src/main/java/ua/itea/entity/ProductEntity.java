package ua.itea.entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "ProductEntity.getAll",
                query = "select products from ProductEntity products"),
        @NamedQuery(name = "ProductEntity.getProductsByCategories",
                query = "select products from ProductEntity products where products.category = :category"),
        @NamedQuery(name = "ProductEntity.getProductsBySubCategories",
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
}