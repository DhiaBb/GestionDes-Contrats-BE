package tn.esprit.khaddemrevision.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.khaddemrevision.entities.Contrat;
import tn.esprit.khaddemrevision.entities.Departement;
import tn.esprit.khaddemrevision.entities.Universite;
import tn.esprit.khaddemrevision.repository.ContratRepository;
import tn.esprit.khaddemrevision.repository.DepartementRepository;
import tn.esprit.khaddemrevision.repository.UniversiteRepository;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService{

    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;
    ContratRepository contratRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite universite = universiteRepository.findById(idUniversite).get();
        Departement departement = departementRepository.findById(idDepartement).get();
        List<Departement> l= universite.getDepartements();
        l.add(departement);
        universite.setDepartements(l);
        universiteRepository.save(universite);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).get();
        return universite.getDepartements();
    }

}
