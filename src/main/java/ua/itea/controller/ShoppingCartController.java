package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.itea.dao.jpa.ProductDAO;
import ua.itea.entity.Cart;
import ua.itea.entity.ProductEntity;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String service() {

        String url = "shoppingCart";
        log.info("url -> " + url);
        return url;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String openCart(@RequestParam("productId") Long productId,
                           HttpSession session) {

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        ProductEntity product = new ProductDAO().getProductById(productId);

        if (product != null && cart.getProducts().contains(product)) {
            product = cart.getProducts().get(cart.getProducts().indexOf(product));
            product.setQuantity(product.getQuantity() + 1);
        } else if (product != null) {
            product.setQuantity(1);
            cart.getProducts().add(product);
        }

        session.setAttribute("cart", cart);

        String url = "shoppingCart";
        log.info("url -> " + url);
        return url;
    }
}
