package com.example.gm.servises;

import com.example.gm.models.User;
import com.example.gm.repositories.ResultRepository;
import com.example.gm.repositories.UserRepository;
import com.example.gm.repositories.ZapisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class ResultService {
    public static final Logger LOG = LoggerFactory.getLogger(ResultService.class);

    private ResultRepository resultRepository;
    private UserRepository userRepository;
    private ZapisRepository zapisRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository, UserRepository userRepository, ZapisRepository zapisRepository) {
        this.resultRepository = resultRepository;
        this.userRepository = userRepository;
        this.zapisRepository = zapisRepository;
    }

    private User getUserByPrincipal(Principal principal){
        String email = principal.getName();
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found" + email));
    }
}
