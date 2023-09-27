package br.com.criandoapi.projeto.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "O título é obrigatório!")
    @Size(min = 3 , message = "O título deve ter no mínimo 3 caracteres!")
    @Column(name = "title", length = 100, nullable = true)
    private String title;

    @Column(name = "description", length = 500, nullable = true)
    private String description;
}
