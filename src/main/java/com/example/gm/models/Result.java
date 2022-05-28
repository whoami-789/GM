package com.example.gm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "result")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "result")
    private String result;
    @Column(name = "dicom")
    private String dicom;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Zapis resultZ;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User resultU;

}
