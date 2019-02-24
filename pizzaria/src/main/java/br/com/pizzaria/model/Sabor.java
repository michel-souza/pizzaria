package br.com.pizzaria.model;

import java.util.Arrays;
import java.util.Optional;

public enum Sabor {

	CALABRESA("Calabresa", "C", 0), MARGUERITA("Marguerita", "M", 0), PORTUGUESA("Portuguesa", "P", 5);
    private String recheio;
    private String valorPersistido;
    private int tempoAdd;
    
    Sabor(final String recheio, String valorPersistido, int tempoAdd) {
        this.recheio = recheio;
        this.valorPersistido = valorPersistido;
        this.setTempoAdd(tempoAdd);
    }
    
    public static Optional<Sabor> getSaborPorRecheio(final String recheio) {
        return Arrays.asList(values()).stream().filter(p -> {
            return p.getRecheio().equals(recheio);
        }).findFirst();
    }
    
    public static Optional<Sabor> getSaborPorValorPersistido(final String valorPersisitido) {
        return Arrays.asList(values()).stream().filter(p -> {
            return p.getValorPersistido().equals(valorPersisitido);
        }).findFirst();
    }
    
    public String getRecheio() {
        return recheio;
    }

	public String getValorPersistido() {
		return valorPersistido;
	}

	public int getTempoAdd() {
		return tempoAdd;
	}

	public void setTempoAdd(int tempoAdd) {
		this.tempoAdd = tempoAdd;
	}
	
}
