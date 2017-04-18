package za.co.discovery.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.discovery.web.client.RoutesClient;

/**
 * Created by tinashehondo on 4/18/17.
 */
@RequestMapping("/routes")
@Controller
public class RouteController {

    @Autowired
    private RoutesClient routesClient;

    @RequestMapping("/{destination}")
    public String showCustomer(@PathVariable String destination, Model model) {
       // model.addAttribute("routes", routesClient.calculateShortestRoute(destination));
        return "/routes";
    }

    @RequestMapping({ "/test"})
    public String test(Model model){
        routesClient.calculateShortestRoute("C");
        return "customer/list";
    }

}
