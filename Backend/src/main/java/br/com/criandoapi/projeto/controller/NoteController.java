package br.com.criandoapi.projeto.controller;

import br.com.criandoapi.projeto.entity.Note;
import br.com.criandoapi.projeto.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/notes")
public class NoteController {

    public NoteService noteService;

    public NoteController(NoteService noteService) { this.noteService = noteService; }

    @GetMapping
    public ResponseEntity<List<Note>> getNotes() {
        return ResponseEntity.status(200).body(noteService.getNotes());
    }

    @PostMapping
    public ResponseEntity<Note> postNote(@Valid @RequestBody Note note) {
        return ResponseEntity.status(204).body(noteService.createNote(note));
    }
}
