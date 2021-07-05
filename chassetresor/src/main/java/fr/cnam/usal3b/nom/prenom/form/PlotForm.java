package fr.cnam.usal3b.nom.prenom.form;

import fr.cnam.usal3b.nom.prenom.model.TypePlotEnum;

public class PlotForm {
    private String titre;
    private String description;
    private TypePlotEnum typePlot;

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

    public TypePlotEnum getTypePlot() {
        return typePlot;
    }

    public void setTypePlot(TypePlotEnum typePlot) {
        this.typePlot = typePlot;
    }
}
