package com.elotech.testePratico.pessoa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Tabela_Pessoa")
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Pessoa")
	private Long id;

	@NotEmpty(message = "O nome não pode ser vazio")
	@NotNull(message = "O nome não pode ser nulo")
	private String nome;

	@NotEmpty(message = "O cpf não pode ser vazio")
	@NotNull(message = "O cpf não pode ser nulo")
	@CPF(message = "O cpf tem que ser válido")
	private String cpf;


	@NotNull(message = "A data de nascimento não pode ser nulo")
	@Past(message = "A data de nascimento deve estar no passado")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;

	@NotEmpty(message = "O contato não pode ser vazio")
	@NotNull(message = "O contato não pode ser nulo")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Contato> contatos;

	public Pessoa() {

	}

	public Pessoa(Long id, String nome, String cpf, String dataNascimento, List<Contato> contatos) throws ParseException {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
		this.contatos = contatos;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) throws ParseException {
		this.dataNascimento = dataNascimento;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	

}
