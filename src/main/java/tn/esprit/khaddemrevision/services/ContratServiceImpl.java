package tn.esprit.khaddemrevision.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.khaddemrevision.entities.*;
import tn.esprit.khaddemrevision.repository.ContratRepository;
import tn.esprit.khaddemrevision.repository.EquipeRepository;
import tn.esprit.khaddemrevision.repository.EtudiantRepository;
import tn.esprit.khaddemrevision.repository.UniversiteRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class ContratServiceImpl implements IContratService{
    private final UniversiteRepository universiteRepository;

    EtudiantRepository etudiantRepository;

    ContratRepository contratRepository;

    EquipeRepository equipeRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).get();
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.deleteById(idContrat);
        log.info("Deleted:"+idContrat);
    }

    @Override
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        Contrat contrat = contratRepository.findById(idContrat).get();

        Set<Equipe> l = new HashSet<>();
        l.add(equipe);
        e.setEquipes(l);

        contrat.setEtudiant(e);
        contratRepository.save(contrat);

        return etudiantRepository.save(e);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) throws IllegalArgumentException{
        Etudiant etudiant = etudiantRepository.findEtudiantsByNomEAndPrenomE(nomE, prenomE);
        if (etudiant.getContrats().size()<5){
            ce.setEtudiant(etudiant);
        }
        return contratRepository.save(ce);
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {

        // Difference des dates:
        ZoneId zoneId;
        LocalDate d1 = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate d2 = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Period age = Period.between(d1, d2);
        int years = age.getYears();
        int months = age.getMonths();
        int monthsDiff = (years * 12) + months;
        System.out.println(monthsDiff);

        float s = 0;
        float r = 1;
        for (Universite u : universiteRepository.findAll()) {
            for (Departement departement : u.getDepartements()) {
                for (Etudiant etudiant : departement.getEtudiants()) {
                    for (Contrat contrat : etudiant.getContrats()) {
                        if ((contrat.getDateDebutContrat().before(startDate)) &&
                        (contrat.getDateFinContrat().after(endDate)) && (!contrat.isArchivee())){
                            switch (contrat.getSp()) {
                                case IA:
                                    r = 300;
                                    break;
                                case RESEAUX:
                                    r = 350;
                                    break;
                                case CLOUD:
                                    r = 400;
                                    break;
                                case SECURITE:
                                    r = 450;
                                    break;
                            }
                            s = s + (monthsDiff * r);
                        }
                    }
                }
            }
        }

        return s;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {

        int s = 0;
        for(Universite u: universiteRepository.findAll()){
            for(Departement departement : u.getDepartements()){
                for (Etudiant etudiant : departement.getEtudiants()){
                    for (Contrat contrat: etudiant.getContrats()){
                        if ((contrat.getDateDebutContrat().before(startDate))&&
                                (contrat.getDateFinContrat().after(endDate))&&(!contrat.isArchivee())){
                            s = s + 1;
                        }
                    }
                }
            }
        }
        return s;
    }

    @Override
    @Scheduled(cron = "0 13 * * *")
    public String retrieveAndUpdateStatusContrat() {
        String s = null;
        for(Contrat contrat : contratRepository.findAll()){
            ZoneId zoneId;
            LocalDate df = contrat.getDateFinContrat().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate now = LocalDate.now();

            long daysUntilTargetDate = ChronoUnit.DAYS.between(now,df);
            if (daysUntilTargetDate <= 15) {
                s = s + "There are " + daysUntilTargetDate + " days left until the end Date "
                        + contrat.getDateFinContrat() + "of the Contrat of the student "
                        + contrat.getEtudiant().getPrenomE() +" "+contrat.getEtudiant().getNomE()
                        + "with the speciality " + contrat.getSp() ;
            }
            if (daysUntilTargetDate <= 0){
                contrat.setArchivee(false);
                contratRepository.save(contrat);
            }
        }
        return s;
    }


}
