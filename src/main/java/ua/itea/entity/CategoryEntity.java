package ua.itea.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
@NamedQueries({
        @NamedQuery(name = "CategoryEntity.getAll",
                query = "select category from CategoryEntity category")
})
public class CategoryEntity implements FloraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category", targetEntity = SubCategoryEntity.class)
    private List<SubCategoryEntity> subCategories;

}
