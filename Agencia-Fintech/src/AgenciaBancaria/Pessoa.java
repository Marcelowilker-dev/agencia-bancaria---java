package AgenciaBancaria;

public  class Pessoa {

	private static int contador = 1;
	private String nome;
	
	
	public Pessoa(String nome) {
		this.nome = nome;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
