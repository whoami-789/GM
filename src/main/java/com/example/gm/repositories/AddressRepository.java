package com.example.gm.repositories;

import com.example.gm.models.Address;
import com.example.gm.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findAddressById(Long id);

    List<Address> findAllByName(String name);

    List<Address> findByName(String name);
}
