package br.com.criandoapi.projeto.repository;

import br.com.criandoapi.projeto.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INote extends JpaRepository<Note, Integer> {
}
