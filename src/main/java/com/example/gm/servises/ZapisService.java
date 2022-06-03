package com.example.gm.servises;

import com.example.gm.dto.ZapisDTO;
import com.example.gm.exeptions.CategoryNotFoundException;
import com.example.gm.exeptions.ZapisNotFoundException;
import com.example.gm.models.Address;
import com.example.gm.models.Category;
import com.example.gm.models.User;
import com.example.gm.models.Zapis;
import com.example.gm.repositories.AddressRepository;
import com.example.gm.repositories.CategoryRepository;
import com.example.gm.repositories.UserRepository;
import com.example.gm.repositories.ZapisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class ZapisService {
    public static final Logger LOG = LoggerFactory.getLogger(ZapisService.class);

    private final ZapisRepository zapisRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public ZapisService(ZapisRepository zapisRepository, UserRepository userRepository,
                        CategoryRepository categoryRepository, AddressRepository addressRepository) {
        this.zapisRepository = zapisRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.addressRepository = addressRepository;
    }

    public Zapis createZapis(ZapisDTO zapisDTO, Principal principal, Long categoryId, Long addressId) {
        User user = getUserByPrincipal(principal);
        Zapis zapis = new Zapis();
        Category category = categoryRepository.findCategoryById(categoryId)
                        .orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        Address address = addressRepository.findAddressById(addressId)
                .orElseThrow(() -> new CategoryNotFoundException("Address not found"));
        zapis.setCategory(category);
        zapis.setAddress(address);
        zapis.setUser(user);
        zapis.setDate(zapisDTO.getDate());
        zapis.setTime(zapisDTO.getTime());

        LOG.info("Saving new zapis: {}", zapisDTO.getId());
        return zapisRepository.save(zapis);
    }

    public List<Zapis> getAllZaps() {
        return zapisRepository.findAllByOrderById();
    }

    public Zapis getZapById(Long id, Principal principal) {
        User user = getUserByPrincipal(principal);
        return zapisRepository.findZapisByIdAndUser(id, user)
                .orElseThrow(() -> new ZapisNotFoundException("Zapis cannot be found"));
    }

    public List<Zapis> getAllZapsForUsers(Principal principal) {
        User user = getUserByPrincipal(principal);
        return zapisRepository.findAllUsersById(user);
    }

    public void deleteZapis(Long id, Principal principal){
        Zapis zapis = getZapById(id, principal);
        zapisRepository.delete(zapis);
    }

    private User getUserByPrincipal(Principal principal) {
        String email = principal.getName();
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found" + email));
    }
}
