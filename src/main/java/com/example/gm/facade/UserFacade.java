package com.example.gm.facade;

import com.example.gm.dto.UserDTO;
import com.example.gm.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

     public UserDTO userToUserDTO(User user) {
         UserDTO userDTO = new UserDTO();
         userDTO.setId(user.getId());
         userDTO.setName(user.getName());
         userDTO.setLastname(user.getLastname());
         userDTO.setEmail(user.getEmail());
         userDTO.setBdate(user.getBdate());
         userDTO.setPhoneNumber(user.getPhoneNumber());
         return userDTO;
     }
}
