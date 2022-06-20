package com.example.gm.controllers;

import com.example.gm.dto.CategoryDTO;
import com.example.gm.facade.CategoryFacade;
import com.example.gm.models.Category;
import com.example.gm.payload.response.MessageResponse;
import com.example.gm.repositories.CategoryRepository;
import com.example.gm.servises.CategoryService;
import com.example.gm.validators.ResponseErrorValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryFacade categoryFacade;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ResponseErrorValidation responseErrorValidation;

    @PostMapping("/create")
    public ResponseEntity<Object> createCategory(@Valid @RequestBody CategoryDTO categoryDTO,
                                                 BindingResult bindingResult){
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errors)) return errors;

        Category category = categoryService.createCategory(categoryDTO);
        CategoryDTO createdCategory = categoryFacade.categoryToCategoryDTO(category);

        return new ResponseEntity<>(createdCategory, HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<Object> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,
                                                 BindingResult bindingResult){
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errors)) return errors;

        Category category = categoryService.updateCategory(categoryDTO);
        CategoryDTO createdCategory = categoryFacade.categoryToCategoryDTO(category);

        return new ResponseEntity<>(createdCategory, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategories()
                .stream()
                .map(categoryFacade::categoryToCategoryDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(categoryDTOList, HttpStatus.OK);
    }

    @PostMapping("/{categoryId}/delete")
    public ResponseEntity<MessageResponse> deleteCategory (@PathVariable("categoryId") String categoryId){
        categoryService.deleteCategory(Long.parseLong(categoryId));

        return new ResponseEntity<>(new MessageResponse("Category was deleted"), HttpStatus.OK);
    }


}
