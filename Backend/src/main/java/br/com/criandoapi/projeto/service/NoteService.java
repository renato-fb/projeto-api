package br.com.criandoapi.projeto.service;

import br.com.criandoapi.projeto.entity.Note;
import br.com.criandoapi.projeto.repository.INote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final Logger logger = LoggerFactory.getLogger(NoteService.class);

    private final INote repository;

    public NoteService(INote repository) {
        this.repository = repository;
    }

    public List<Note> getNotes() {
        logger.info("Listando Notas");
        return repository.findAll();
    }

    public Note createNote(Note note) {
        logger.info("Criando Notas");
        return repository.save(note);
    }
}
