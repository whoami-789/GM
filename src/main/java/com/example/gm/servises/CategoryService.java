package com.example.gm.servises;

import com.example.gm.dto.CategoryDTO;
import com.example.gm.models.Category;
import com.example.gm.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setTitle(categoryDTO.getTitle());
        category.setPrice(categoryDTO.getPrice());

        return categoryRepository.save(category);
    }

    public Category updateCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setPrice(categoryDTO.getPrice());

        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAllByOrderById();
    }

    public List<Category> getCategoryByTitle(String title){
        return categoryRepository.findByTitle(title);
    }
}
