package ua.itea;


import ua.itea.entity.Cart;
import ua.itea.entity.ProductEntity;

/**
 * Created by dada.mazza on 10.07.2017.
 */
public class Main {
    public static void main(String[] args) {

        Cart cart = new Cart();

        ProductEntity product1 = new ProductEntity();
        product1.setId(1L);
        product1.setName("Вишня");
        product1.setPrice(12000);

        ProductEntity product2 = new ProductEntity();
        product2.setId(1L);
        product2.setName("Вишня");
        product2.setPrice(12000);

        System.out.println(product1.equals(product2));

    }
}
