package tn.esprit.khaddemrevision.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Contrat")

public class Contrat implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContrat")

    private int idContrat;
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)
    private Date dateFinContrat ;
    private boolean archivee;
    private Specialite sp;
    private int montantContrat;


    @ManyToOne
    Etudiant etudiant;

}
