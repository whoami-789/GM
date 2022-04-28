package com.example.gm.models;

import com.example.gm.models.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "bdate")
    private String bdate;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "login")
    private String login;
    @Column(name = "pass")
    private String password;

    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @JoinTable
    private Set<Roles> roles = new HashSet<>();

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
