package br.edu.infnet.larissa.model.domain;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Escola {
    private Integer id;
    private String nome;
    private String email;
    private List<Professor> professores;
    private Endereco endereco;

    public Escola() {}

    public Escola(String nome, String email, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Escola: " + nome + " - " + email + " - " + endereco + " - " + professores;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

	public void setEndereco(String string) {
		// TODO Auto-generated method stub
		
	}

	public Object[] getEndereco() {
		// TODO Auto-generated method stub
		return null;
	}

}