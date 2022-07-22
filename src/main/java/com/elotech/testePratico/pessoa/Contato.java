package com.elotech.testePratico.pessoa;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tabela_Contato")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="contato")
	private Long id;

	@NotEmpty(message="O nome não pode ser vazio")
	@NotNull(message="O nome não pode ser nulo")
	private String nome;

	@NotEmpty(message="O telefone não pode ser vazio")
	@NotNull(message="O telefone não pode ser nulo")
	private String telefone;

	@NotEmpty(message="O email não pode ser vazio")
	@NotNull(message="O email não pode ser nulo")
	@Email(message = "O email tem que ser válido")
	private String email;
	
	public Contato() {
		
	}
	
	
	public Contato(Long id, String nome, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
