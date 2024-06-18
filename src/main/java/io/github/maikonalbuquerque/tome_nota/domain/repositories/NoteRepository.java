package io.github.maikonalbuquerque.tome_nota.domain.repositories;

import io.github.maikonalbuquerque.tome_nota.domain.entities.Note;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository {

    List<Note> findAll();
    Note findById(long id);
    Note save(Note note);
    void delete(Note note);
}
