package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import ua.itea.entity.CartEntity;
import ua.itea.entity.ProductEntity;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/addProductToCart")
public class CartController {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String addProductToCart(
            @RequestParam("product") String json,
            HttpSession session) {

        CartEntity cart = (CartEntity) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartEntity();
        }

        ProductEntity product = new ProductEntity();
        JSONObject jsonObj = new JSONObject(json);
        product.setId(jsonObj.getLong("id"));
        product.setName(jsonObj.getString("name"));
        product.setPrice(jsonObj.getInt("price"));

        if (cart.getProducts().contains(product)) {
            product = cart.getProducts().get(cart.getProducts().indexOf(product));
            product.setQuantity(product.getQuantity() + 1);
        } else {
            product.setQuantity(1);
            cart.getProducts().add(product);
        }

        session.setAttribute("cart", cart);

        JSONObject response = new JSONObject();
        response.put("totalItems", cart.getTotalItems());
        response.put("totalAmount", cart.getTotalAmount());

        log.info("jsonResponse : " + response);

        return response.toString();
    }
}

