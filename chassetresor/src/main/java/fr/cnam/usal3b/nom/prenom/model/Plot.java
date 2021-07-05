package fr.cnam.usal3b.nom.prenom.model;

import javax.persistence.*;

@Entity
public class Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titre;
    private String description;
    @Enumerated(EnumType.STRING)
    private TypePlotEnum typePlot;

    public Plot() {
    }

    public Plot(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypePlotEnum getTypePlot() {
        return typePlot;
    }

    public void setTypePlot(TypePlotEnum typePlot) {
        this.typePlot = typePlot;
    }
}
