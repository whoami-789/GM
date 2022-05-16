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

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ZapisServise {
    private final ZapisRepository zapisRepository;

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public Optional<Zapis> zapisList(Long id){
        if (id != null) return zapisRepository.findAllById(id);
        return zapisRepository.findAll();
    }

    public List<Category> categoryList(String title){
        if (title != null) return categoryRepository.findByTitle(title);
        return categoryRepository.findAll();
    }

  /*  public User getUsersByPrincipal(Principal principal){
        if(principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }*/

    public List<User> userslist(String email){
        if (email != null) return userRepository.findByEmail(email);
        return userRepository.findAll();
    }

    public void saveZap(User user, Zapis zapis){
        userRepository.save(user);
        zapisRepository.save(zapis);
    }
}
