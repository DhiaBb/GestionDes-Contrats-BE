package tn.esprit.khaddemrevision.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idDepart;

    private String nomDepart;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "departement")
    private List<Etudiant> etudiants;
}


