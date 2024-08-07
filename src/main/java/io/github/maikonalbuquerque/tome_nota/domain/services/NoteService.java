package io.github.maikonalbuquerque.tome_nota.domain.services;

import io.github.maikonalbuquerque.tome_nota.domain.entities.Note;
import io.github.maikonalbuquerque.tome_nota.domain.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Note findById(Long id) {
        return noteRepository.findById(id);
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public Note update(Note note) {
        return noteRepository.save(note);
    }

    public void delete(Note note) {
        noteRepository.delete(note);
    }
}
