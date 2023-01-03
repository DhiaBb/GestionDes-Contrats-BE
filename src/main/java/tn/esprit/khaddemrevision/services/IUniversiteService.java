package tn.esprit.khaddemrevision.services;

import tn.esprit.khaddemrevision.entities.Departement;
import tn.esprit.khaddemrevision.entities.Universite;

import java.util.Date;
import java.util.List;

public interface IUniversiteService {

    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);

    void assignUniversiteToDepartement (Integer idUniversite , Integer idDepartement);

    List<Departement> retrieveDepartementsByUniversite (Integer idUniversite);


}
