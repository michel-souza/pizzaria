package br.com.pizzaria.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.pizzaria.model.Adicional;
import br.com.pizzaria.model.Pizza;
import br.com.pizzaria.model.Sabor;
import br.com.pizzaria.model.Tamanho;
import br.com.pizzaria.service.PizzaService;

@RestController
public class PizzaController {
	private static final String ZERO = "0";

	@Autowired
	private PizzaService service;
	
	@Value("${error.message}")
	private String errorMessage;
	
	@RequestMapping(value = "/addPizza", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addPizza(@RequestParam(value = "tamanho") String tamanho,
        @RequestParam(value = "sabor") String sabor, @RequestParam(value = "extras", required = false) String[] extras) {
		
		if (tamanho.equals(ZERO) || sabor.equals(ZERO)) {
			ModelAndView modelAndView = new ModelAndView("pizza");
			modelAndView.addObject("tamanhos", Arrays.asList(Tamanho.values()));
			modelAndView.addObject("sabores", Arrays.asList(Sabor.values()));
			modelAndView.addObject("adicionais", Arrays.asList(Adicional.values()));
			modelAndView.addObject("errorMessage", errorMessage);
			return modelAndView;
		}
		Pizza pizza = new Pizza();
		pizza.setTamanho(tamanho);
		pizza.setSabor(sabor);
		if (extras != null) {
			for (String add : extras) {
				pizza.addAdicionais(add);
			}
		}
		service.save(pizza);
        
        return new ModelAndView("redirect:/pedido");
    }
	
	@RequestMapping(value = {"/pizza" }, method = RequestMethod.GET)
    public ModelAndView index() {
		
        ModelAndView modelAndView = new ModelAndView("pizza");
        modelAndView.addObject("tamanhos", Arrays.asList(Tamanho.values()));
        modelAndView.addObject("sabores", Arrays.asList(Sabor.values()));
        modelAndView.addObject("adicionais", Arrays.asList(Adicional.values()));
		return modelAndView;
    }
	
	@RequestMapping(value = {"/del" }, method = RequestMethod.GET)
	public ModelAndView del(@RequestParam(value = "id") Long id) {
		List<Pizza> all = service.getAll();		
		service.delete(all.get(id.intValue()).getId());
		all.remove(id);
		
		ModelAndView pedido = new ModelAndView("redirect:/pedido");
        pedido.addObject("pizzas", service.getAll()); 
        return pedido;
	}

}
