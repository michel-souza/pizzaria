package br.com.pizzaria.model;

import java.util.Arrays;
import java.util.Optional;

public enum Tamanho {

	PEQUENA("Pequena", "P", 20, 15), MEDIA("Média", "M", 30, 20), GRANDE("Grande", "G", 40, 25);
    private String nome;
    private String valorPersistido;
    private int preco;
    private int tempoPreparo;
    
    Tamanho(final String nome, String valorPersistido, int preco, int tempoPreparo) {
        this.nome = nome;
        this.valorPersistido = valorPersistido;
        this.setPreco(preco);
        this.setTempoPreparo(tempoPreparo);
    }
    
    public static Optional<Tamanho> getTamanhosPorNome(final String nome) {
        return Arrays.asList(values()).stream().filter(p -> {
            return p.getNome().equals(nome);
        }).findFirst();
    }
    
    public static Optional<Tamanho> getTamanhosPorValorPersistido(final String ValorPersisitido) {
        return Arrays.asList(values()).stream().filter(p -> {
            return p.getValorPersistido().equals(ValorPersisitido);
        }).findFirst();
    }
    
    public String getNome() {
        return nome;
    }

	public String getValorPersistido() {
		return valorPersistido;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public int getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(int tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}
	
}
