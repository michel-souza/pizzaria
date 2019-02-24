package br.com.pizzaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.pizzaria.model.Adicional;
import br.com.pizzaria.model.Pizza;
import br.com.pizzaria.model.Sabor;
import br.com.pizzaria.model.Tamanho;
import br.com.pizzaria.model.repository.PizzaRepository;

@Component
public class PizzaService {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	public Pizza save(Pizza pizza) {
		int valor = 0;
		int tempo = 0;
		Sabor sabor = Sabor.valueOf(pizza.getSabor());
		tempo = sabor.getTempoAdd();
		Tamanho tamanho = Tamanho.valueOf(pizza.getTamanho());
		tempo += tamanho.getTempoPreparo();
		valor += tamanho.getPreco();
		for (String add : pizza.getAdicionais()) {
			Adicional adicional = Adicional.valueOf(add);
			tempo += adicional.getTempoExtra();
			valor += adicional.getValorExtra();
		}
		pizza.setTempo(tempo);
		pizza.setValor(valor);
		
		return this.pizzaRepository.save(pizza);
	}
	
	public void delete(Long id) {
		this.pizzaRepository.delete(id);
	}
	
	public Pizza get(Long id) {
		return this.pizzaRepository.findOne(id);
	}
	
	public List<Pizza> getAll() {
		Iterable<Pizza> findAll = this.pizzaRepository.findAll();
		List<Pizza> pizzas = new ArrayList<>();
		
		findAll.forEach(pizzas::add);
		
		return pizzas;
	}

}
