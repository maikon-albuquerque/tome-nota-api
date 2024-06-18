package io.github.maikonalbuquerque.tome_nota.infrastructure.repositories;

import io.github.maikonalbuquerque.tome_nota.domain.entities.Note;
import io.github.maikonalbuquerque.tome_nota.domain.repositories.NoteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoteRepositoryImpl implements NoteRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Note> findAll() {
        return em.createQuery("from Note", Note.class).getResultList();
    }

    @Override
    public Note findById(long id) {
        return em.find(Note.class, id);
    }

    @Override
    public Note save(Note note) {
        return em.merge(note);
    }

    @Override
    public void delete(Note note) {
        Note deleted = findById(note.getId());
        em.remove(deleted);
    }

}
