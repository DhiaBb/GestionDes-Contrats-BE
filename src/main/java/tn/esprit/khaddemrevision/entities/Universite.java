package tn.esprit.khaddemrevision.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idUniv;

    private String nomUniv;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Departement> departements;

}
