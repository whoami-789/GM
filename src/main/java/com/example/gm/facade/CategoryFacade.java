package com.example.gm.facade;

import com.example.gm.dto.CategoryDTO;
import com.example.gm.models.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryFacade {

    public CategoryDTO CategoryToCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setTitle(category.getTitle());
        categoryDTO.setPrice(category.getPrice());

        return categoryDTO;
    }
}
