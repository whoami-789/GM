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

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Category idC;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User idU;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "idZ")
    private List<Result> result = new ArrayList<>();

}
