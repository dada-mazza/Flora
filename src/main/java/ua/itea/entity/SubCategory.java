package ua.itea.entity;

public class SubCategory {

    private Long id;
    private Category category;
    private String ukrName;
    private String engName;

    public SubCategory() {
    }

    public SubCategory(Long id, Category category, String ukrName, String engName) {
        this.id = id;
        this.category = category;
        this.ukrName = ukrName;
        this.engName = engName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
}
