package io.github.maikonalbuquerque.tome_nota.domain.repositories;

import io.github.maikonalbuquerque.tome_nota.domain.entities.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {

    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    void delete(Category category);

}
