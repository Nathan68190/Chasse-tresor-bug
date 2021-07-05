package fr.cnam.usal3b.nom.prenom.form;


import javax.persistence.Id;

public class ScenarioForm {
    private String titre;
    private String description;
    private Integer id;

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

    public void setId(Object id) {
    }
}
