package br.com.criandoapi.projeto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

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
	@Column(name = "nome_completo", length = 200, nullable = true)
	private String nome;

	@Email(message = "Insira um email válido!")
	@NotBlank(message = "O email é obrigatório!")
	@Column(name = "email", length = 50, nullable = true)
	private String email;

	@NotBlank(message = "A senha é obrigatório!")
	@Column(name = "senha", columnDefinition = "TEXT", nullable = true)
	private String senha;
}
