package com.elotech.testePratico.pessoa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class PessoaServiceTest {
   
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	Pessoa pessoa = new Pessoa();
	Contato contato = new Contato();
	ArrayList<Contato> listaDeContatos = new ArrayList();
	
	@Test
	public void inserirPessoaTest() throws ParseException {
		contato.setEmail("teste@teste.com");
		contato.setNome("principal");
		contato.setTelefone("33333333");
		listaDeContatos.add(contato);
		
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse("20/02/2020");
        pessoa.setDataNascimento(data);
        pessoa.setCpf("189.957.870-66");
        pessoa.setNome("Maria");
        pessoa.setContatos(listaDeContatos);
        pessoaService.salvar(pessoa);
        assertFalse(pessoaRepository.findById(pessoa.getId()).isEmpty());
        
	}
	
	@Test
	public void listarPessoaPorIdTest(){
		Pessoa pessoa = pessoaService.listarPessoaPorId(752L);
		assertEquals("Maria", pessoa.getNome());
		assertEquals("189.957.870-66", pessoa.getCpf());
		assertEquals("2020-02-20 00:00:00.0",pessoa.getDataNascimento().toString());
		
	}
	
	@Test
	public void deletarPessoaTest() {
		pessoaService.deletarPessoa(602L);
		assertFalse(pessoaRepository.findById(21L).isPresent());
	}
	
	@Test
	public void listarTodasPessoasTest() {
		List<Pessoa> pessoas = pessoaService.listarTodasPessoas();
		assertThat(pessoas).size().isGreaterThan(0);
	}
	
	@Test
	public void atualizarPessoaTest() {
		Pessoa pessoa = pessoaRepository.findById(6L).get();
		pessoa.setNome("Marcos");
		
		pessoaService.atualizarPessoa(pessoa);
		assertNotEquals("Lucas",pessoa.getNome());
	}
	
	
}
