package com.elotech.testePratico.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/pessoas")
public class PessoaController {
   @Autowired
   private PessoaService service;
   
   @PostMapping
   public Pessoa salvar(@RequestBody Pessoa pessoa) {
	   return service.salvar(pessoa);
   }
   
   @GetMapping
   public List<Pessoa> listarPessoas(){
	   return service.listarTodasPessoas();
   }
   
   @GetMapping("/{id}")
   public Pessoa listarPessoa(@PathVariable Long id ) {
	   return service.listarPessoaPorId(id);
   }
   
   @DeleteMapping("/{id}")
   public void deletarPessoa(@PathVariable Long id) {
	   service.deletarPessoa(id);
   }
   
   @PutMapping("/{id}")
   public Pessoa atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
	   if(!id.equals(pessoa.getId())) {
		   throw new RuntimeException("O id da URL não é a correspondente da pessoa que deseja atualizar");
	   }
	   return service.atualizarPessoa(pessoa);
   }
}
