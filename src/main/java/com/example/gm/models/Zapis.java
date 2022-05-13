package com.example.gm.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zapis")
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
    @JoinColumn(name = "idC")
    private Category idC;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idU")
    private User idU;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "idZ")
    private List<Result> result = new ArrayList<>();

    public Zapis(Long id, String date, String time, Category idC, User idU, List<Result> result) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.idC = idC;
        this.idU = idU;
        this.result = result;
    }

    public Zapis() {
    }

    public Long getId() {
        return this.id;
    }

    public String getDate() {
        return this.date;
    }

    public String getTime() {
        return this.time;
    }

    public Category getIdC() {
        return this.idC;
    }

    public User getIdU() {
        return this.idU;
    }

    public List<Result> getResult() {
        return this.result;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setIdC(Category idC) {
        this.idC = idC;
    }

    public void setIdU(User idU) {
        this.idU = idU;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Zapis)) return false;
        final Zapis other = (Zapis) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$time = this.getTime();
        final Object other$time = other.getTime();
        if (this$time == null ? other$time != null : !this$time.equals(other$time)) return false;
        final Object this$idC = this.getIdC();
        final Object other$idC = other.getIdC();
        if (this$idC == null ? other$idC != null : !this$idC.equals(other$idC)) return false;
        final Object this$idU = this.getIdU();
        final Object other$idU = other.getIdU();
        if (this$idU == null ? other$idU != null : !this$idU.equals(other$idU)) return false;
        final Object this$result = this.getResult();
        final Object other$result = other.getResult();
        if (this$result == null ? other$result != null : !this$result.equals(other$result)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Zapis;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $time = this.getTime();
        result = result * PRIME + ($time == null ? 43 : $time.hashCode());
        final Object $idC = this.getIdC();
        result = result * PRIME + ($idC == null ? 43 : $idC.hashCode());
        final Object $idU = this.getIdU();
        result = result * PRIME + ($idU == null ? 43 : $idU.hashCode());
        final Object $result = this.getResult();
        result = result * PRIME + ($result == null ? 43 : $result.hashCode());
        return result;
    }

    public String toString() {
        return "Zapis(id=" + this.getId() + ", date=" + this.getDate() + ", time=" + this.getTime() + ")";
    }
}
