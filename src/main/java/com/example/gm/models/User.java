package com.example.gm.models;

import com.example.gm.models.enums.Roles;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "lastname", nullable = false)
    private String lastname;
    @Column(name = "bdate")
    private String bdate;
    @Column(name = "phoneNumber", unique = true)
    private String phoneNumber;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    public User(Long id, /*String username,*/ String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        //this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @JoinTable
    private Set<Roles> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Zapis> zapis;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Result> result;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Conclusion> conclusion = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Dicom> dicom = new ArrayList<>();

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
