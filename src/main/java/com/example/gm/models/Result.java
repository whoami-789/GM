package com.example.gm.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "result")
@Data
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private Long size;
    @Column(name = "contentType")
    private String contentType;
    @Lob
    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "idZ")
    private Zapis idZ;

    public Result(String name, Long size, String contentType, byte[] bytes, Zapis idZ) {
        this.name = name;
        this.size = size;
        this.contentType = contentType;
        this.bytes = bytes;
        this.idZ = idZ;
    }

    public Result() {
    }
}
