package io.github.maikonalbuquerque.tome_nota.api.controller;

import io.github.maikonalbuquerque.tome_nota.domain.entities.Category;
import io.github.maikonalbuquerque.tome_nota.domain.repositories.CategoryRepository;
import io.github.maikonalbuquerque.tome_nota.domain.services.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    public CategoryController(CategoryRepository categoryRepository, CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Category updatedCategory = categoryRepository.findById(id);
        BeanUtils.copyProperties(category, updatedCategory, "id");
        return categoryRepository.save(updatedCategory);
    }
}
