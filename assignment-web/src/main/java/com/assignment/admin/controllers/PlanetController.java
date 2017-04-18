package com.assignment.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.discovery.model.Planet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by primrose on 4/18/17.
 */
@Controller
@RequestMapping("/planet")
public class PlanetController {


        @RequestMapping("/")
        public String getPlanetHomePage() {
            return "planet/form";
        }

        @RequestMapping(value = "/search/",method = RequestMethod.POST)
        public String searchPlanets(Model model, @RequestParam(required = true) String field1,@RequestParam(required = true) String field2) {
            System.out.println("Search Planets with :"+field1+" and :"+field2);
            //do service call and get list of planets
            List<Planet> planetsResultList=new ArrayList<>();
            planetsResultList.add(new Planet("node1","1"));
            planetsResultList.add(new Planet("node2","2"));
            planetsResultList.add(new Planet("node3","3"));
            planetsResultList.add(new Planet("node4","name4"));
            model.addAttribute("planets",planetsResultList);
            model.addAttribute("field1",field1);
            model.addAttribute("field2",field2);
            return "planet/form";
        }
}
