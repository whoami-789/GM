package com.example.gm.servises;

import com.example.gm.models.Category;
import com.example.gm.models.Users;
import com.example.gm.models.Zapis;
import com.example.gm.repositories.CategoryRepository;
import com.example.gm.repositories.UserRepository;
import com.example.gm.repositories.ZapisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ZapisServise {
    private final ZapisRepository zapisRepository;

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public List<Zapis> zapisList(String title){
        if (title != null) return zapisRepository.findByTitle(title);
        return zapisRepository.findAll();
    }

    public List<Category> categoryList(String catname){
        if (catname != null) return categoryRepository.findByTitle(catname);
        return categoryRepository.findAll();
    }

    public Users getUsersByPrincipal(Principal principal){
        if(principal == null) return new Users();
        return userRepository.findByEmail(principal.getName());
    }

}
