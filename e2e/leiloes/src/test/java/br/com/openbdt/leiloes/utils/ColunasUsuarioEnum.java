package br.com.openbdt.leiloes.utils;

public enum ColunasUsuarioEnum {
	
	NOME(1), 
	EMAIL(2), 
	ACAO(3);
	
	private int valor;
	
	private ColunasUsuarioEnum(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return this.valor;
	}

}
