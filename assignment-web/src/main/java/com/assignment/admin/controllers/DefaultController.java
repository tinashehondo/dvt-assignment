package com.assignment.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by primrose on 4/4/17.
 */
@Controller
public class DefaultController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "home/index";
    }
}
