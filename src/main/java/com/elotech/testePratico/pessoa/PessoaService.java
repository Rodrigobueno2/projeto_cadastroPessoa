package com.elotech.testePratico.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;
	
	public Pessoa salvar(Pessoa novaPessoa) {
		 return repo.save(novaPessoa);
	}
	
	public List<Pessoa> listarTodasPessoas(){
		return repo.findAll();
	}
	
	public Pessoa listarPessoaPorId(Long id){
		if(repo.findById(id).isEmpty()) {
		   throw new RuntimeException("Não existe pessoa com este id");	
		}
		return repo.findById(id).get();
	}
	
	public void deletarPessoa(Long id) {
		if(repo.findById(id).isEmpty()) {
			throw new RuntimeException("Não existe pessoa com este id");
		}
		 repo.deleteById(id);
	}
	
	public Pessoa atualizarPessoa(Pessoa pessoa) {
		if(repo.findById(pessoa.getId()).isEmpty()) {
			throw new RuntimeException("Essa pessoa não existe faça primeiro um post");
		}
		return repo.save(pessoa);
	}
}
