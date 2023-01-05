package rs.raf.demo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import rs.raf.demo.model.*;
import rs.raf.demo.repositories.*;

import java.util.*;


@Component
public class BootstrapData implements CommandLineRunner {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final PredmetRepository predmetRepository;

    @Autowired
    public BootstrapData(UserRepository userRepository, PasswordEncoder passwordEncoder, PredmetRepository predmetRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.predmetRepository = predmetRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Data...");

        try {

            Predmet p1 = new Predmet();
            p1.setNaziv("Mata");

            User user3 = new User();
            user3.setUsername("student2");
            user3.setPassword(this.passwordEncoder.encode("user2"));
            user3.setIndeks("RI5/2019");
            user3.setBirthDate(new Date());
            user3.setPhone("123");
            user3.setEmail("lol@user3.com");


            User profa = new User();
            profa.setUsername("profa");
            profa.setPassword(this.passwordEncoder.encode("profa"));
            profa.setIndeks("cfhgvjb");
            profa.setBirthDate(new Date());
            profa.setPhone("123");
            profa.setEmail("lol@profa.com");

            List<User> p1Studenti = new ArrayList<User>();
            List<Predmet> profaPredmeti = new ArrayList<Predmet>();
            List<Predmet> polozeni = new ArrayList<Predmet>();

            profaPredmeti.add(p1);
            polozeni.add(p1);

            profa.setProfaPredmeti(profaPredmeti);

            this.userRepository.save(profa);
            this.userRepository.save(user3);

            p1Studenti.add(user3);
            p1.setStudenti(p1Studenti);
            p1.setProfesor(profa);

            this.predmetRepository.save(p1);

            user3.setPolozeniPredmeti(polozeni);
            this.userRepository.save(user3);


        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Data loaded!");
    }
}
