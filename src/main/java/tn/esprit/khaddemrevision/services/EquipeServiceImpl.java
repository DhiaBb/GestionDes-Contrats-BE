package tn.esprit.khaddemrevision.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.khaddemrevision.entities.Contrat;
import tn.esprit.khaddemrevision.entities.Equipe;
import tn.esprit.khaddemrevision.entities.Etudiant;
import tn.esprit.khaddemrevision.repository.EquipeRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static tn.esprit.khaddemrevision.entities.Niveau.*;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements IEquipeService{
    EquipeRepository equipeRepository;
    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).get();
    }

    @Override
    @Scheduled(cron = "0 0 1 1 1")
    public void faireEvoluerEquipes() {
        ZoneId zoneId;
        LocalDate now = LocalDate.now();
        for(Equipe equipe : equipeRepository.findAll()){
            if( (equipe.getNiveau()==JUNIOR) || (equipe.getNiveau()==SENIOR) ){
                if(equipe.getEtudiants().size()>=3){
                    for (Etudiant etudiant:equipe.getEtudiants()){
                        for(Contrat contrat : etudiant.getContrats()){
                            LocalDate dd = contrat.getDateDebutContrat().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            long daysUntilTargetDate = ChronoUnit.YEARS.between(dd,now);
                            if(daysUntilTargetDate>=1){
                                if(equipe.getNiveau()==JUNIOR){
                                    equipe.setNiveau(SENIOR);
                                }
                                else
                                    equipe.setNiveau(EXPERT);
                            }
                        }
                    }
                }
            }
        }
    }
}
