package tn.esprit.khaddemrevision.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailEquipe implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idDetailEquipe;
    private  int salle;
    private String Thematique;
    @OneToOne(mappedBy = "detailEquipe")
    Equipe equipe;

}
