package com.generation.blogpessoalnicolle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoalnicolle.model.PostagemModel;
// ações
@Repository   // comunicação com banco de dados
public interface PostagemRepository extends JpaRepository <PostagemModel, Long>{
	

	
}
