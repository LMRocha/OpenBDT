package br.com.openbdt.leiloes.utils;

public enum ColunasLeilaoEnum {
	
	NOME(1), 
	DT_ABERTURA(2), 
	VALOR_INICIAL(3),
	USUARIO(4),
	USADO(5);
	
	private int valor;
	
	private ColunasLeilaoEnum(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return this.valor;
	}

}
