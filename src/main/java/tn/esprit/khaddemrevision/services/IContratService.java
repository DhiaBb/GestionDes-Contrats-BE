package tn.esprit.khaddemrevision.services;

import tn.esprit.khaddemrevision.entities.Contrat;
import tn.esprit.khaddemrevision.entities.Etudiant;

import java.util.Date;
import java.util.List;

public interface IContratService {

    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat ce);

    Contrat addContrat (Contrat ce);

    Contrat retrieveContrat (Integer idContrat);

    void removeContrat (Integer idContrat);

    Etudiant addAndAssignEtudiantToEquipeAndContract (Etudiant e, Integer idContrat , Integer idEquipe);

    Contrat affectContratToEtudiant (Contrat ce, String nomE,String prenomE);

    float getChiffreAffaireEntreDeuxDate (Date startDate , Date endDate );

    Integer nbContratsValides (Date startDate , Date endDate);

    String retrieveAndUpdateStatusContrat();
}
