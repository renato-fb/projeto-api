package br.com.criandoapi.projeto.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome_completo", length = 200, nullable = true)
	private String nome;
	
	@Column(name = "email", length = 50, nullable = true)
	private String email;
	
	@Column(name = "senha", columnDefinition = "TEXT", nullable = true)
	private String senha;
}
