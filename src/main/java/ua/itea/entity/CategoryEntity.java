package ua.itea.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "ukr_name", nullable = false)
    private String ukrName;

    @Column(name = "eng_name", nullable = false)
    private String engName;

    @Column(name = "sub_categories")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<SubCategoryEntity> subCategories;

}
