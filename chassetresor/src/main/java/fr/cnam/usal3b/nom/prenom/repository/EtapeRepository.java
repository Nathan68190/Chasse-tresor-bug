package fr.cnam.usal3b.nom.prenom.repository;

import fr.cnam.usal3b.nom.prenom.model.Etape;
import fr.cnam.usal3b.nom.prenom.model.Scenario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EtapeRepository extends CrudRepository<Etape, Integer> {

    List<Etape> findByScenario(Scenario scenario);
}