package com.example.gm.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "zapis")
@AllArgsConstructor
@NoArgsConstructor
public class Zapis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

 /*   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;*/

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "zapis")
    private List<Result> result = new ArrayList<>();


}
