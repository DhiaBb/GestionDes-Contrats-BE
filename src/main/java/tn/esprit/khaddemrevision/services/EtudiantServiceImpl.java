package tn.esprit.khaddemrevision.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.khaddemrevision.entities.Departement;
import tn.esprit.khaddemrevision.entities.Etudiant;
import tn.esprit.khaddemrevision.repository.DepartementRepository;
import tn.esprit.khaddemrevision.repository.EtudiantRepository;

import java.util.List;
import java.util.Set;


@Service
@Slf4j
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService{

    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants()
    {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
        log.info("Deleted:"+idEtudiant);
    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        Departement departement = departementRepository.findById(departementId).get();
        Etudiant etudiant = etudiantRepository.findById(etudiantId).get();
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        Departement departement = departementRepository.findById(idDepartement).get();
        return departement.getEtudiants();
    }
}
