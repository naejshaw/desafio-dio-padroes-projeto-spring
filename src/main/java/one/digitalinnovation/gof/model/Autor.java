package one.digitalinnovation.gof.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Autor {

	@Id
	private String genero;
	private String nome;
	private String sobrenome;
	private String nacionalidade;
	private Long anoPublicacao;

	public Long getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(Long anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	

}
