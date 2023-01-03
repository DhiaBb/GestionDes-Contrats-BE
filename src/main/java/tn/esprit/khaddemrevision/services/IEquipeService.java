package tn.esprit.khaddemrevision.services;

import tn.esprit.khaddemrevision.entities.Equipe;

import java.util.List;

public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();
    Equipe addEquipe (Equipe e);
    Equipe updateEquipe (Equipe e);
    Equipe retrieveEquipe(Integer idEquipe);

    void faireEvoluerEquipes ();
}
