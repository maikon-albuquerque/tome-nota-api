package io.github.maikonalbuquerque.tome_nota.api.controller;

import io.github.maikonalbuquerque.tome_nota.domain.entities.Note;
import io.github.maikonalbuquerque.tome_nota.domain.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteRepository noteRepository;

    @GetMapping
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Note getById(@PathVariable Long id) {
        return noteRepository.findById(id);
    }
}
