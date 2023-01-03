package tn.esprit.khaddemrevision.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.khaddemrevision.entities.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
    Etudiant findEtudiantsByNomEAndPrenomE(String nomE, String prenomE);
}
