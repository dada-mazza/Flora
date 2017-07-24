package ua.itea.entity;

import java.util.List;

public class Category {

    private Long id;
    private String ukrName;
    private String engName;
    private List<SubCategory> subCategories;

    public Category() {
    }

    public Category(Long id, String ukrName, String engName, List<SubCategory> subCategories) {
        this.id = id;
        this.ukrName = ukrName;
        this.engName = engName;
        this.subCategories = subCategories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUkrName() {
        return ukrName;
    }

    public void setUkrName(String ukrName) {
        this.ukrName = ukrName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", ukrName='" + ukrName + '\'' +
                ", engName='" + engName + '\'' +
                ", subCategories=" + subCategories +
                '}';
    }
}
