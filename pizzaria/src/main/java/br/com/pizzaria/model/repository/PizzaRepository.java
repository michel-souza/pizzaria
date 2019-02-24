package br.com.pizzaria.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzaria.model.Pizza;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long> {

}
