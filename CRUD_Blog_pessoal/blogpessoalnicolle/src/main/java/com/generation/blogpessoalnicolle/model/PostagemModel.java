package com.generation.blogpessoalnicolle.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name ="tb_postagens")

public class PostagemModel { //primary key
   
	@Id // id que é gerado no mySQL
    @GeneratedValue(strategy = GenerationType.IDENTITY) // sequencias 1 2 3 .. AUTOINCREMENT 
	private Long id; 
    
    @NotBlank(message = "O atributo título é Obrigatório e não pode utilizar espaços em branco!") 
    @Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
    private String titulos;
    
    @NotNull(message = "O atributo texto é Obrigatório!")// aceita escrever errados 
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 500 caracteres")
	private String texto;
    
    @UpdateTimestamp
    private LocalDateTime data;

   
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulos() {
		return titulos;
	}

	public void setTitulos(String titulos) {
		this.titulos = titulos;
		
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	
}

