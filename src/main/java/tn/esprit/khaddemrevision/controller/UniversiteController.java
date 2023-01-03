package tn.esprit.khaddemrevision.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khaddemrevision.entities.Departement;
import tn.esprit.khaddemrevision.entities.Universite;
import tn.esprit.khaddemrevision.services.UniversiteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/Universite")
@AllArgsConstructor
public class UniversiteController {

    UniversiteServiceImpl universiteServiceImpl;

    @GetMapping("/getAllUniversite")
    public List<Universite> retrieveAllUniversites(){
        return universiteServiceImpl.retrieveAllUniversites();
    }

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite u){
        return universiteServiceImpl.addUniversite(u);
    }

    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite u){
        return universiteServiceImpl.updateUniversite(u);
    }

    @GetMapping("/getUniversite/{idUniversite}")
    public Universite retrieveUniversite(@PathVariable("idUniversite") Integer idUniversite){
        return universiteServiceImpl.retrieveUniversite(idUniversite);
    }

    @PutMapping("/assignUniversiteToDepartement/{idUniversite}/{idDepartement}")
    public void assignUniversiteToDepartement(@PathVariable("idUniversite") Integer idUniversite,@PathVariable("idDepartement") Integer idDepartement){
        universiteServiceImpl.assignUniversiteToDepartement(idUniversite,idDepartement);
    }

    @GetMapping("/retrieveDepartementsByUniversite/{idUniversite}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable("idUniversite") Integer idUniversite){
        return universiteServiceImpl.retrieveDepartementsByUniversite(idUniversite);
    }
}
