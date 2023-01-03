package tn.esprit.khaddemrevision.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khaddemrevision.entities.Etudiant;
import tn.esprit.khaddemrevision.services.EtudiantServiceImpl;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/Etudiant")
@AllArgsConstructor
public class EtudiantController {
    EtudiantServiceImpl etudiantServiceImpl;

    @GetMapping("/getAllEtudiant")
    public List<Etudiant> retrieveAllEtudiants(){
        return etudiantServiceImpl.retrieveAllEtudiants();
    }


    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant (@RequestBody Etudiant e){
        return etudiantServiceImpl.addEtudiant(e);
    }

    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e){
        return etudiantServiceImpl.updateEtudiant(e);
    }

    @GetMapping("/getEtudiant/{idEtudiant}")
    public Etudiant retrieveEtudiant(@PathVariable("idEtudiant") Integer idEtudiant){
        return etudiantServiceImpl.retrieveEtudiant(idEtudiant);
    }

    @DeleteMapping("/removeEtudiant/{idEtudiant}")
    public void removeEtudiant(@PathVariable("idEtudiant") Integer idEtudiant){
        etudiantServiceImpl.removeEtudiant(idEtudiant);
    }

    @PutMapping("/assignEtudiantToDepartement/{etudiantId}/{departementId}")
    public void assignEtudiantToDepartement(@PathVariable("etudiantId") Integer etudiantId,@PathVariable("departementId") Integer departementId){
        etudiantServiceImpl.assignEtudiantToDepartement(etudiantId,departementId);
    }

    @GetMapping("/getEtudiantsByDepartement/{idDepartement}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("idDepartement") Integer idDepartement){
        return etudiantServiceImpl.getEtudiantsByDepartement(idDepartement);
    }

}
