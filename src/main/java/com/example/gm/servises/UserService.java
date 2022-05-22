package com.example.gm.servises;

import com.example.gm.exeptions.UserExistExeption;
import com.example.gm.models.User;
import com.example.gm.models.enums.Roles;
import com.example.gm.payload.request.SignUpRequest;
import com.example.gm.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    public User createUser(SignUpRequest userIn){
        User user = new User();
        user.setEmail(userIn.getEmail());
        user.setName(userIn.getName());
        user.setSurname(userIn.getSurname());
        user.setBdate(userIn.getBdate());
        user.setPhoneNumber(userIn.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(userIn.getPassword()));
        user.getRoles().add(Roles.PERSON);

        try {
            LOG.info("Saving user {}", userIn.getEmail());
            return userRepository.save(user);
        } catch (Exception e){
            LOG.error("Error during registration {}", e.getMessage());
            throw new UserExistExeption("User" + user.getEmail() + "already exists, please enter another email");
        }
    }
}
