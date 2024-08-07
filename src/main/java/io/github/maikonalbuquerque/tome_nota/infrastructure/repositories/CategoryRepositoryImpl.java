package io.github.maikonalbuquerque.tome_nota.infrastructure.repositories;

import io.github.maikonalbuquerque.tome_nota.domain.entities.Category;
import io.github.maikonalbuquerque.tome_nota.domain.repositories.CategoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryRepositoryImpl implements CategoryRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Category> findAll() {
        return em.createQuery("select c from Category c", Category.class).getResultList();
    }

    @Override
    public Category findById(Long id) {
        return em.find(Category.class, id);
    }

    @Transactional
    @Override
    public Category save(Category category) {
        return em.merge(category);
    }

    @Override
    public void delete(Category category) {
        Category categoryToDelete = findById(category.getId());
        em.remove(categoryToDelete);
    }
}
