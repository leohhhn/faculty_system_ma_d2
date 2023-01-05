package rs.raf.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    @NotBlank(message = "Username is mandatory")
    private String username;

    @Column
    @NotBlank(message = "Password is mandatory")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column
    private String phone;

    @Column
    private Date birthDate;

    @Column
    private String indeks;

    @OneToMany(mappedBy = "profesor")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private List<Predmet> profaPredmeti;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JoinTable(
            name = "polozeniPredmeti",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "predmetId"))
    private List<Predmet> polozeniPredmeti;


    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String index) {
        this.indeks = index;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Predmet> getProfaPredmeti() {
        return profaPredmeti;
    }

    public void setProfaPredmeti(List<Predmet> profaPredmeti) {
        this.profaPredmeti = profaPredmeti;
    }

    public List<Predmet> getPolozeniPredmeti() {
        return polozeniPredmeti;
    }

    public void setPolozeniPredmeti(List<Predmet> polozeniPredmeti) {
        this.polozeniPredmeti = polozeniPredmeti;
    }

    //    @Column
//    @Version
//    private Integer version;


}
