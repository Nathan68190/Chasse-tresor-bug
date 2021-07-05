package fr.cnam.usal3b.nom.prenom.model;

import javax.persistence.*;

@Entity
public class Coordonnees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String latitude;
    private String longitude;
    @OneToOne
    @JoinColumn(name = "coord_id", referencedColumnName = "id")
    private BriqueGeoloc briqueGeoloc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
