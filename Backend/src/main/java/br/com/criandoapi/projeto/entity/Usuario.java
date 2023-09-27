package br.com.criandoapi.projeto.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotBlank(message = "O nome é obrigatório!")
	@Size(min = 3 , message = "O nome deve ter no mínimo 3 caracteres!")
	@Column(name = "nome", length = 200, nullable = true)
	private String nome;

	@Email(message = "Insira um email válido!")
	@NotBlank(message = "O email é obrigatório!")
	@Column(name = "email", length = 50, nullable = true)
	private String email;

	@NotBlank(message = "A senha é obrigatório!")
	@Size(min = 5 , message = "A senha deve ter no mínimo 3 caracteres!")
	@Column(name = "senha", columnDefinition = "TEXT", nullable = true)
	private String senha;
}
