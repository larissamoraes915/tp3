package br.edu.infnet.larissa.model.domain;

public class Professor {
	private int registro; 
	private String nome;
	private float salario;
	private boolean mestre;
	
	public float calcularSalario() {
		
		float salarioTotal = salario + (mestre ? 1250: 750);
		
		return indicativoGratificacao() ? salarioTotal + 1000 : salarioTotal;
		
	}
	
	public boolean indicativoGratificacao() {
		return salario >= 5000 && mestre;
	}
	public int getRegistro() {
		return registro;
	}
	public void setRegistro(int registro) {
		this.registro = registro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public boolean isMestre() {
		return mestre;
	}
	public void setMestre(boolean mestre) {
		this.mestre = mestre;
	}
	
}
