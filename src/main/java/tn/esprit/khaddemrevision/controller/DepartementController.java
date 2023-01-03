package tn.esprit.khaddemrevision.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khaddemrevision.entities.Departement;
import tn.esprit.khaddemrevision.services.DepartementServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Departement")
public class DepartementController {

    DepartementServiceImpl departementServiceImpl;

    @PostMapping("/addDepartement")
    public Departement addDepartement (@RequestBody Departement d){
        return departementServiceImpl.addDepartement(d);
    }

    @GetMapping("/getAllDepartement")
    public List<Departement> retrieveAllDepartements(){
        return departementServiceImpl.retrieveAllDepartements();
    }

    @PutMapping("/updateDepartement")
    public Departement updateDepartement (@RequestBody Departement d){
        return departementServiceImpl.updateDepartement(d);
    }

    @GetMapping("/getDepartement/{idDepart}")
    public Departement retrieveDepartement (@PathVariable("idDepart") Integer idDepart){
        return departementServiceImpl.retrieveDepartement(idDepart);
    }
}
