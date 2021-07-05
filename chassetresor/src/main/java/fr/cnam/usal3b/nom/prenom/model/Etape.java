package fr.cnam.usal3b.nom.prenom.model;

import javax.persistence.*;

@Entity
public class Etape {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titre;
    private String description;
    @ManyToOne
    @JoinColumn(name = "etape_id", nullable = false)
    private Scenario scenario;

    public Etape() {
    }

    public Etape(String titre, String description) {
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

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
}
