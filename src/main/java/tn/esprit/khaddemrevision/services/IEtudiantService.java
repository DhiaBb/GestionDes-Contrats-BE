package tn.esprit.khaddemrevision.services;

import tn.esprit.khaddemrevision.entities.Etudiant;

import java.util.List;
import java.util.Set;

public interface IEtudiantService
{

    List<Etudiant>  retrieveAllEtudiants();

      Etudiant addEtudiant (Etudiant e);

      Etudiant updateEtudiant (Etudiant e);

      Etudiant retrieveEtudiant(Integer idEtudiant);

     void removeEtudiant(Integer idEtudiant);

     void assignEtudiantToDepartement (Integer etudiantId , Integer departementId );

    List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);


}
