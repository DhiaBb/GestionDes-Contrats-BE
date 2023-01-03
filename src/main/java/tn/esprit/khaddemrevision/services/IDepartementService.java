package tn.esprit.khaddemrevision.services;

import tn.esprit.khaddemrevision.entities.Departement;

import java.util.List;

public interface IDepartementService {
    List<Departement> retrieveAllDepartements();

    Departement addDepartement (Departement d);

    Departement updateDepartement (Departement d);

    Departement retrieveDepartement (Integer idDepart);
}
