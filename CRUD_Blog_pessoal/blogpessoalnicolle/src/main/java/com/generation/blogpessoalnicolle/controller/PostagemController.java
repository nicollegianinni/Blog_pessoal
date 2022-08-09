package com.generation.blogpessoalnicolle.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoalnicolle.model.PostagemModel;
import com.generation.blogpessoalnicolle.repository.PostagemRepository;

@RestController //
@RequestMapping("/postagem") // @crossOrigin : crossorigin "*",  allowedheadrs "*". o asteristico substitui os 2 
@CrossOrigin(origins = "*", allowedHeaders = "*") // importante para o front end ter acesso a nossa API


public class PostagemController {
   
	@Autowired // instaciar o acesso ao repositorio que eu criei na model
	private PostagemRepository repository;
    
    @GetMapping // ele procura nas minhas pastas/sql = localhost:8080/categoria puxa todos, se quiser puxar so um localhost:8080/categoria/3 
      public ResponseEntity<List<PostagemModel>>GetAll() { // get all = busca todos e no postaman/insomnia aparece  200 ok
    	return ResponseEntity.ok(repository.findAll());  // SELECT*FROM tb_postagens busca todos do meu repositorio    }
    } 
    @GetMapping("/{id}")
      public ResponseEntity<PostagemModel> GetById(@PathVariable Long id) {
    	 return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<PostagemModel>> GetByTitulo(@PathVariable String titulo){ //estava dando erro em postagemModel
		return  ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
    }
    @PostMapping
	  public ResponseEntity<PostagemModel> post (@Valid @RequestBody PostagemModel postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping
	  public ResponseEntity<PostagemModel> put (@RequestBody PostagemModel postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	  public void delete (@PathVariable Long id) {
		repository.deleteById(id);
	}
}



  