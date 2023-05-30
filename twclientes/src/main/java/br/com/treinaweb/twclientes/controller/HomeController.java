package br.com.treinaweb.twclientes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //Class for Controller.
@RequestMapping("/") //Inform the route. And inform the default route "/"
public class HomeController {

    //@RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String home() { //Action.
        return "home"; //String Home. The view

    }

}
