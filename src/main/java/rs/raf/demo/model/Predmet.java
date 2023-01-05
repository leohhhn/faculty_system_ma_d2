package rs.raf.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Predmet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long predmetId;
    @ManyToOne
    @JsonIgnore
    private User profesor;

    @Column
    private String naziv;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private List<User> studenti;

//    @Column
//    @Version
//    private Integer version;


    public User getProfesor() {
        return profesor;
    }

    public void setProfesor(User profesor) {
        this.profesor = profesor;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<User> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<User> studenti) {
        this.studenti = studenti;
    }

    public Long getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(Long userId) {
        this.predmetId = userId;
    }


}
