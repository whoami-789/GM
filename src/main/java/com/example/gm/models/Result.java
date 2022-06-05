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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Dicom dicom;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Conclusion conclusion;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Zapis zapis;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    public void setUser(Long id) {
        this.id = id;
    }
}
