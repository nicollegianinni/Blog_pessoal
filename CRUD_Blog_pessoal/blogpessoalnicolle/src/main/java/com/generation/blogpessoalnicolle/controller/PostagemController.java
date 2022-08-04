package com.generation.blogpessoalnicolle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoalnicolle.model.PostagemModel;
import com.generation.blogpessoalnicolle.repository.PostagemRepository;

@RestController //
@RequestMapping("/postagens") // @crossOrigin : crossorigin "*",  allowedheadrs "*". o asteristico substitui os 2 
@CrossOrigin("*") // importante para o front end ter acesso a nossa API

public class PostagemController {
   
	@Autowired // instaciar o acesso ao repositorio que eu criei na model
	private PostagemRepository postagemRepository;
    
   @GetMapping // ele procura nas minhas pastas/sql = localhost:8080/categoria puxa todos, se quiser puxar so um localhost:8080/categoria/3 
    public ResponseEntity<List<PostagemModel>>getAll(){ // get all = busca todos e no postaman/insomnia aparece  200 ok
    	return ResponseEntity.ok(postagemRepository.findAll());  // SELECT*FROM tb_postagens busca todos do meu repositorio    }
 
  }

}

  