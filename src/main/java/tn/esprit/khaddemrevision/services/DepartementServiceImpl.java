package tn.esprit.khaddemrevision.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.khaddemrevision.entities.Departement;
import tn.esprit.khaddemrevision.repository.DepartementRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class DepartementServiceImpl implements IDepartementService{

    DepartementRepository departementRepository;
    @Override
    public List<Departement> retrieveAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return departementRepository.findById(idDepart).get();
    }
}
