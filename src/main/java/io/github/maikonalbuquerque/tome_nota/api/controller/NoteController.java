package io.github.maikonalbuquerque.tome_nota.api.controller;

import io.github.maikonalbuquerque.tome_nota.domain.entities.Note;
import io.github.maikonalbuquerque.tome_nota.domain.repositories.NoteRepository;
import io.github.maikonalbuquerque.tome_nota.domain.services.NoteService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAll() {
        return noteService.findAll();
    }

    @GetMapping("/{id}")
    public Note getById(@PathVariable Long id) {
        return noteService.findById(id);
    }

    @PostMapping
    public Note create(@RequestBody Note note) {
        return noteService.add(note);
    }

    @PutMapping("/{id}")
    public Note update(@RequestBody  Note note, @PathVariable Long id) {
        Note updatedNote = noteService.findById(id);

        BeanUtils.copyProperties(updatedNote, note, "id");
        return noteService.update(updatedNote);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Note deletedNote = noteService.findById(id);
        noteService.delete(deletedNote);
    }
}
