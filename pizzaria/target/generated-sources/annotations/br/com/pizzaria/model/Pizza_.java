package br.com.pizzaria.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pizza.class)
public abstract class Pizza_ {

	public static volatile ListAttribute<Pizza, String> adicionais;
	public static volatile SingularAttribute<Pizza, String> tamanho;
	public static volatile SingularAttribute<Pizza, String> sabor;
	public static volatile SingularAttribute<Pizza, Integer> valor;
	public static volatile SingularAttribute<Pizza, Integer> tempo;
	public static volatile SingularAttribute<Pizza, Long> id;

}

