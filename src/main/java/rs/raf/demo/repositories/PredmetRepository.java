package rs.raf.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.raf.demo.model.Predmet;
import rs.raf.demo.model.User;

@Repository
public interface PredmetRepository extends JpaRepository<Predmet, Long> {
        public Predmet findPredmetByNaziv(String naziv);
}
