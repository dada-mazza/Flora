package ua.itea.entity;

import lombok.Data;
import ua.itea.dao.jpa.ProductDAO;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sub_categories",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"category_id", "name"})
        })
@NamedQueries({
        @NamedQuery(name = "SubCategoryEntity.getAll",
                query = "select subCategory from SubCategoryEntity subCategory"),
        @NamedQuery(name = "SubCategoryEntity.getAllByCategory",
                query = "select subCategory from SubCategoryEntity subCategory where subCategory.category = :category")
})

public class SubCategoryEntity implements FloraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity category;

    @Column(name = "name", nullable = false)
    private String name;

    private Long numberOfItems;

    public Long getNumberOfItems() {
        if (numberOfItems == null) {
            numberOfItems = new ProductDAO().getNumberOfItemsInSubCategory(this);
        }
        return numberOfItems;
    }

}
