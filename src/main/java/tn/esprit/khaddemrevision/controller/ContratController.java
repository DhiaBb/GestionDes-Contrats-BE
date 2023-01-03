package tn.esprit.khaddemrevision.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khaddemrevision.entities.Contrat;
import tn.esprit.khaddemrevision.entities.Etudiant;
import tn.esprit.khaddemrevision.services.ContratServiceImpl;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Contrat")
@AllArgsConstructor
public class ContratController {

    ContratServiceImpl contratServiceImpl;

    @GetMapping("/getAllContrat")
    public List<Contrat> retrieveAllContrats(){
        return contratServiceImpl.retrieveAllContrats();
    }

    @PostMapping("/addContrat")
    public Contrat addContrat(@RequestBody Contrat ce){
        return contratServiceImpl.addContrat(ce);
    }

    @PutMapping("/updateContrat")
    public Contrat updateContrat(@RequestBody Contrat ce){
        return contratServiceImpl.updateContrat(ce);
    }

    @GetMapping("/getContrat/{idContrat}")
    public Contrat retrieveContrat(@PathVariable("idContrat") Integer idContrat){
        return contratServiceImpl.retrieveContrat(idContrat);
    }

    @DeleteMapping("/removeContrat/{idContrat}")
    public void removeContrat(@PathVariable("idContrat") Integer idContrat){
        contratServiceImpl.removeContrat(idContrat);
    }

    @PostMapping("/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,
                                                            @PathVariable("idContrat") Integer idContrat ,@PathVariable("idEquipe") Integer idEquipe){
        return contratServiceImpl.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }

    @PutMapping("/affectContratToEtudiant/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce,@PathVariable("nomE") String nomE,
                                           @PathVariable("prenomE") String prenomE){
        return contratServiceImpl.affectContratToEtudiant(ce,nomE,prenomE);
    }

    @GetMapping("/getChiffreAffaireEntreDeuxDate/{startDate}/{endDate}")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return contratServiceImpl.getChiffreAffaireEntreDeuxDate( startDate, endDate);
    }

    @GetMapping("/nbContratsValides")
    public Integer nbContratsValides(@RequestParam("startDate")
                                     @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                     @RequestParam("endDate")
                                     @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return contratServiceImpl.nbContratsValides(startDate,endDate);
    }
}
