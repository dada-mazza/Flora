package ua.itea.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

@Table(name = "sub_categories",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"category_id", "ukr_name"}),
                @UniqueConstraint(columnNames = {"category_id", "eng_name"})
        })

public class SubCategoryEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "category_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity categoryEntity;

    @Column(name = "ukr_name", nullable = false)
    private String ukrName;

    @Column(name = "eng_name", nullable = false)
    private String engName;


}
