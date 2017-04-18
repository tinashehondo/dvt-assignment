package za.co.discovery.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.discovery.web.services.ShortestRouteClient;

/**
 * Created by primrose on 4/4/17.
 */
@Controller
public class DefaultController {
@Autowired
private ShortestRouteClient shortestRouteClient;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
       shortestRouteClient.getShortestDistance("A","Z");

        return "home/index";
    }
}
