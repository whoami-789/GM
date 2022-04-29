package com.example.gm.servises;

import com.example.gm.models.Category;
import com.example.gm.models.User;
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

    public List<Zapis> zapisList(String id){
        if (id != null) return zapisRepository.findById(id);
        return zapisRepository.findAll();
    }

    public List<Category> categoryList(String title){
        if (title != null) return categoryRepository.findByTitle(title);
        return categoryRepository.findAll();
    }

    public User getUsersByPrincipal(Principal principal){
        if(principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public List<User> userslist(String name){
        if (name != null) return userRepository.findByName(name);
        return userRepository.findAll();
    }

/*    public void saveZap(User user, Zapis zapis, Category category){
        zapis.setUser(getUserByName(name));
    }*/
}
