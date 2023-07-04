package br.com.treinaweb.twclientes.controller;

import br.com.treinaweb.twclientes.model.Cliente;
import br.com.treinaweb.twclientes.repository.ClienteRepository;
import ch.qos.logback.core.net.server.Client;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.management.modelmbean.ModelMBean;
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

    @GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("cliente/detalhar.html");

        Cliente cliente = clienteRepository.getOne(id);
        modelAndView.addObject("cliente", cliente);

        return modelAndView;
    }

    @GetMapping("/{id}/exlcuir")
    public ModelAndView excluir(@PathVariable long id) { //passando o id do cliente que quer excluir.
        ModelAndView modelAndView = new ModelAndView("redirect:/cliente"); // redireciona para a página de cliente para listar o que restou.

        clienteRepository.deleteById(id);

        return modelAndView;

    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("/cliente/cadastro");

        modelAndView.addObject("cliente", new Cliente());

        return modelAndView;

    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrar(Cliente cliente) {
        ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

        clienteRepository.save(cliente);

        return modelAndView;

    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("cliente/edicao");

        Cliente cliente = clienteRepository.getOne(id);
        modelAndView.addObject("cliente", cliente);

        return modelAndView;

    }

    @PostMapping("/{id}/editar")
    public ModelAndView editar(Cliente cliente) {
        ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

        clienteRepository.save(cliente); //quando id for nulo ele entende que deve salvar, se tiver o id ele entende que precisa editar

        return modelAndView;

    }

}
