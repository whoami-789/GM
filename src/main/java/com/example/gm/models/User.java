package com.example.gm.models;

import com.example.gm.models.enums.Roles;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
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
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
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

    public User(String name, String surname, String bdate, String phoneNumber, String email, String password, Set<Roles> roles, List<Zapis> zapisU) {
        this.name = name;
        this.surname = surname;
        this.bdate = bdate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.zapisU = zapisU;
    }

    public User() {
    }

    public boolean isAdmin() {
        return roles.contains(Roles.ADMIN);
    }
    public boolean isDoctor() {
        return roles.contains(Roles.DOCTOR);
    }
    public boolean isPerson() {
        return roles.contains(Roles.PERSON);
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getBdate() {
        return this.bdate;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public Set<Roles> getRoles() {
        return this.roles;
    }

    public List<Zapis> getZapisU() {
        return this.zapisU;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public void setZapisU(List<Zapis> zapisU) {
        this.zapisU = zapisU;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$surname = this.getSurname();
        final Object other$surname = other.getSurname();
        if (this$surname == null ? other$surname != null : !this$surname.equals(other$surname)) return false;
        final Object this$bdate = this.getBdate();
        final Object other$bdate = other.getBdate();
        if (this$bdate == null ? other$bdate != null : !this$bdate.equals(other$bdate)) return false;
        final Object this$phoneNumber = this.getPhoneNumber();
        final Object other$phoneNumber = other.getPhoneNumber();
        if (this$phoneNumber == null ? other$phoneNumber != null : !this$phoneNumber.equals(other$phoneNumber))
            return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$roles = this.getRoles();
        final Object other$roles = other.getRoles();
        if (this$roles == null ? other$roles != null : !this$roles.equals(other$roles)) return false;
        final Object this$zapisU = this.getZapisU();
        final Object other$zapisU = other.getZapisU();
        if (this$zapisU == null ? other$zapisU != null : !this$zapisU.equals(other$zapisU)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $surname = this.getSurname();
        result = result * PRIME + ($surname == null ? 43 : $surname.hashCode());
        final Object $bdate = this.getBdate();
        result = result * PRIME + ($bdate == null ? 43 : $bdate.hashCode());
        final Object $phoneNumber = this.getPhoneNumber();
        result = result * PRIME + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $roles = this.getRoles();
        result = result * PRIME + ($roles == null ? 43 : $roles.hashCode());
        final Object $zapisU = this.getZapisU();
        result = result * PRIME + ($zapisU == null ? 43 : $zapisU.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", name=" + this.getName() + ", surname="
                + this.getSurname() + ", bdate=" + this.getBdate() + ", phoneNumber="
                + this.getPhoneNumber() + ", email=" + this.getEmail() + ", password="
                + this.getPassword() + ", roles=" + this.getRoles() + ")";
    }
}
