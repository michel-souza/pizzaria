package br.com.pizzaria.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;

import br.com.pizzaria.model.Pizza;
import br.com.pizzaria.model.repository.PizzaRepository;

@RestController
public class MainController {
	
	private List<Pizza> pizzas = new ArrayList<>();
	
	@Autowired
	private PizzaRepository repository;
	
	@Value("${welcome.message}")
    private String message;
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public ModelAndView index() {
        
        ModelAndView index = new ModelAndView("index");
        index.addObject("message", message);
        return index;
    }
	
	@RequestMapping(value = { "/pedido" }, method = RequestMethod.GET)
    public ModelAndView personList(Model model) {
 
		pizzas = Lists.newArrayList(repository.findAll());
		ModelAndView pedido = new ModelAndView("pedido");
        pedido.addObject("pizzas", pizzas); 
        return pedido;
    }

}
