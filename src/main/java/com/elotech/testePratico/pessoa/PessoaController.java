package com.elotech.testePratico.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
   public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa) {
	    Pessoa p = service.salvar(pessoa);
	    return ResponseEntity.ok(p);
   }
   
   @GetMapping
   public ResponseEntity<List<Pessoa>> listarPessoas(){
	    List<Pessoa>pessoas = service.listarTodasPessoas();
	    return ResponseEntity.ok(pessoas);
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Pessoa> listarPessoa(@PathVariable Long id ) {
	    Pessoa pessoa = service.listarPessoaPorId(id);
	    return ResponseEntity.ok(pessoa);
   }
   
   @DeleteMapping("/{id}")
   public void deletarPessoa(@PathVariable Long id) {
	   service.deletarPessoa(id);
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
	   if(!id.equals(pessoa.getId())) {
		   throw new RuntimeException("O id da URL não é a correspondente da pessoa que deseja atualizar");
	   }
	   Pessoa p = service.atualizarPessoa(pessoa);
	   return ResponseEntity.ok(p);
   }
}
