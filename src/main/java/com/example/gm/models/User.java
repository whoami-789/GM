package com.example.gm.models;

import com.example.gm.models.enums.Roles;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "bdate")
    private String bdate;
    @Column(name = "phoneNumber", unique = true)
    private String phoneNumber;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "pass")
    private String password;

    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @JoinTable
    private Set<Roles> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="idU")
    private List<Zapis> zapisU;

    public boolean isAdmin() {
        return roles.contains(Roles.ADMIN);
    }
    public boolean isDoctor() {
        return roles.contains(Roles.DOCTOR);
    }
    public boolean isPerson() {
        return roles.contains(Roles.PERSON);
    }

}
