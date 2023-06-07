package br.com.treinaweb.twclientes.controller;

import br.com.treinaweb.twclientes.model.Cliente;
import br.com.treinaweb.twclientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ModelAndView listar() { //Método publico tipo ModelandView
        ModelAndView modelAndView = new ModelAndView("cliente/listar.html"); //Criado um modelandview que vai utilizar o caminha

        List<Cliente> clientes = clienteRepository.findAll(); //Busca no banco de dados. E coloca os dados dentro de um variavel clientes.
        modelAndView.addObject("clientes", clientes);


        return modelAndView;
    }

}
