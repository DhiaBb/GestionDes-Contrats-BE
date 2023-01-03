package tn.esprit.khaddemrevision.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khaddemrevision.entities.Equipe;
import tn.esprit.khaddemrevision.services.EquipeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/Equipe")
@AllArgsConstructor
public class EquipeController {

    EquipeServiceImpl equipeServiceImpl;

    @GetMapping("/getAllEquipe")
    public List<Equipe> retrieveAllEquipes(){
        return equipeServiceImpl.retrieveAllEquipes();
    }

    @PostMapping("/addEquipe")
    public Equipe addEquipe(@RequestBody Equipe e){
        return equipeServiceImpl.addEquipe(e);
    }

    @PutMapping("/updateEquipe")
    public Equipe updateEquipe(@RequestBody Equipe e){
        return equipeServiceImpl.updateEquipe(e);
    }

    @GetMapping("/getEquipe/{idEquipe}")
    public Equipe retrieveEquipe(@PathVariable("idEquipe") Integer idEquipe){
        return equipeServiceImpl.retrieveEquipe(idEquipe);
    }

    @PutMapping("/faireEvoluerEquipes")
    public void faireEvoluerEquipes(){
        equipeServiceImpl.faireEvoluerEquipes();
    }


}
