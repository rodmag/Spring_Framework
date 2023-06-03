package br.com.treinaweb.twclientes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //Class for Controller.
@RequestMapping("/") //Inform the route. And inform the default route "/"
public class HomeController {

    //@RequestMapping(path = "/", method = RequestMethod.GET)
    // When accesing the route "/" in the browser.
    @GetMapping("/")
    public String home() { //Action.
        return "home"; //String Home. The view
    }

    @GetMapping("/mensagem")
    public ModelAndView mensagem() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("mensagem");
        modelAndView.addObject("mensagem", "Mensagem do servidor");

        return modelAndView;
    }

    @GetMapping("/saudacao")
    //http://localhost:8080/saudacao?nome=Teste
    public ModelAndView saudacao(
            @RequestParam(required = false, defaultValue = "Sem nome no parametro") String nome) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("saudacao");
        modelAndView.addObject("nome", nome);

        return modelAndView;
    }
}

