package com.generation.blogpessoalnicolle.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="tb_postagem")

public class PostagemModel { //primary key
   
	@Id // id que é gerado no mySQL
    @GeneratedValue(strategy = GenerationType.IDENTITY) // sequencias 1 2 3 .. AUTOINCREMENT 
	private Long id; 
    
    @NotBlank(message = "O atributo título é Obrigatório e não pode utilizar espaços em branco!") 
    @Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
    private String titulo;
    
    @NotNull(message = "O atributo texto é Obrigatório!")// aceita escrever errados 
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 500 caracteres")
	private String texto;
    
    
    // para a camada usuarioModel adiciona ... (message= "O atributo Usuario é obrigatorio")@NotNull 
    //@ email
    // private 
    // notblank nao pode ter espaço em branco e nulo  ex.: nome compelta das pessoas  | @notnull  pode esta em espaço vazio ex.:  nome completo texto
    //@one to many para usuarioModel 
    // @ na classe postagem many to one ...("postagem") e @ many to one ("tema")
    
    @UpdateTimestamp
    private LocalDateTime data;
    
    @ManyToOne
	@JsonIgnoreProperties("postagem")
	private TemaModel tema;

    @ManyToOne
  	@JsonIgnoreProperties("postagem")
  	private UsuarioModel usuario;
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public TemaModel getTema() {
		return tema;
	}

	public void setTema(TemaModel tema) {
		this.tema = tema;
	}
   
	
    
}

