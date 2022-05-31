package com.example.gm.servises;

import com.example.gm.dto.AddressDTO;
import com.example.gm.models.Address;
import com.example.gm.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createAddress(AddressDTO addressDTO){
        Address address = new Address();
        address.setName(addressDTO.getName());

        return addressRepository.save(address);
    }

    public Address updateAddress(AddressDTO addressDTO){
        Address address = new Address();
        address.setName(addressDTO.getName());

        return addressRepository.save(address);
    }

    public List<Address> getAllAddress(String name){
        return addressRepository.findAllByName(name);
    }
}
