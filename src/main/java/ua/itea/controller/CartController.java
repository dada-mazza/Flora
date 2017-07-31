package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.itea.entity.Cart;
import ua.itea.entity.ProductEntity;

import javax.servlet.http.HttpServlet;

@RestController
@RequestMapping("/addProductToCart")
@SessionAttributes("cart")
public class CartController extends HttpServlet {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String addProductToCart(ModelMap model,
                                   @RequestParam("product") String json) {

        log.info("jsonRequest : " + json);

        Cart cart = (Cart) model.get("cart");
        if (cart == null) {
            cart = new Cart();
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

        model.addAttribute("cart", cart);

        JSONObject response = new JSONObject();
        response.put("totalItems", cart.getTotalItems());
        response.put("totalAmount", cart.getTotalAmount());

        log.info("jsonResponse : " + response);

        return response.toString();
    }


}

