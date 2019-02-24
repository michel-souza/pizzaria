package br.com.pizzaria.model;

import java.util.Arrays;
import java.util.Optional;

public enum Adicional {

	BACON("Extra Bacon", "B", 3, 0), CEBOLA("Sem Cebola", "C", 0, 0), BORDA("Borda Recheada", "R", 5, 5);
    private String adicionalExtra;
    private String valorPersistido;
    private int valorExtra;
    private int tempoExtra;
    
    Adicional(final String adicionalExtra, String valorPersistido, int valorExtra, int tempoExtra) {
        this.adicionalExtra = adicionalExtra;
        this.valorPersistido = valorPersistido;
        this.setValorExtra(valorExtra);
        this.setTempoExtra(valorExtra);
    }
    
    public static Optional<Adicional> getAdicionalPorAdicionalExtra(final String adicionalExtra) {
        return Arrays.asList(values()).stream().filter(p -> {
            return p.getAdicionalExtra().equals(adicionalExtra);
        }).findFirst();
    }
    
    public static Optional<Adicional> getAdicionalPorValorPersistido(final String valorPersisitido) {
        return Arrays.asList(values()).stream().filter(p -> {
            return p.getValorPersistido().equals(valorPersisitido);
        }).findFirst();
    }
    
    public String getAdicionalExtra() {
        return adicionalExtra;
    }

	public String getValorPersistido() {
		return valorPersistido;
	}

	public int getValorExtra() {
		return valorExtra;
	}

	public void setValorExtra(int valorExtra) {
		this.valorExtra = valorExtra;
	}

	public int getTempoExtra() {
		return tempoExtra;
	}

	public void setTempoExtra(int tempoExtra) {
		this.tempoExtra = tempoExtra;
	}
	
}
