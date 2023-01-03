package tn.esprit.khaddemrevision.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtudiant")

    private int idEtudiant;
    private String prenomE ;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option op;


    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Equipe> equipes;

    @JsonIgnore
    @OneToMany(mappedBy = "etudiant",cascade = CascadeType.ALL)
    private Set<Contrat> contrats;


    @ManyToOne
    @JsonIgnore
    private Departement departement;

}
