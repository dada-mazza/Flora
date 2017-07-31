package ua.itea.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private List<ProductEntity> products = new ArrayList<>();

    public Integer getTotalItems() {

        return products.size();
    }

    public Integer getTotalAmount() {

        Integer totalAmount = 0;
        for (ProductEntity product : products) {
            totalAmount += product.getTotalAmount();
        }
        return totalAmount;
    }
}
