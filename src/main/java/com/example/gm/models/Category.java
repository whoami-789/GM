package com.example.gm.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private int price;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy="idC")
    private List<Zapis> zapisC = new ArrayList<>();

    public Category(Long id, String title, int price, List<Zapis> zapisC) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.zapisC = zapisC;
    }

    public Category() {
    }
}
