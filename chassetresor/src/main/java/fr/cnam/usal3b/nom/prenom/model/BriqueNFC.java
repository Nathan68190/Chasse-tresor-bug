package fr.cnam.usal3b.nom.prenom.model;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class BriqueNFC extends Brique {
    private UUID identifiantNFC;

    public UUID getIdentifiantNFC() {
        return identifiantNFC;
    }

    public void setIdentifiantNFC(UUID identifiantNFC) {
        this.identifiantNFC = identifiantNFC;
    }
}
