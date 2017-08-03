package ua.itea.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.itea.entity.enumeratiom.OrderEntity;

import java.util.Random;

@Controller
@RequestMapping("/order")
public class OrderController {

    protected Log log = LogFactory.getLog(getClass());

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String service(@RequestParam("totalAmount") Integer totalAmount,
                          ModelMap model) {

        OrderEntity order = new OrderEntity();
        order.setNumber(new Random().nextInt(1000));
        order.setTotalAmount(totalAmount);
        model.addAttribute("order", order);

        String url = "order";
        log.info("url -> " + url);
        return url;
    }
}
