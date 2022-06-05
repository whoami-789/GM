package com.example.gm.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "conclusion")
@AllArgsConstructor
@NoArgsConstructor
public class Conclusion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "path")
    private String path;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "conclusion")
    private List<Result> result = new ArrayList<>();

    protected boolean canEqual(final Object other) {
        return other instanceof Conclusion;
    }

    public void setUser(Long id) {
        this.id = id;
    }
}
