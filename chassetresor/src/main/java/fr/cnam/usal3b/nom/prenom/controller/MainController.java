package fr.cnam.usal3b.nom.prenom.controller;

import fr.cnam.usal3b.nom.prenom.form.ScenarioForm;
import fr.cnam.usal3b.nom.prenom.model.Scenario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private static List<Scenario> scenarios = new ArrayList<Scenario>();

    static {
        scenarios.add(new Scenario("Où est Charlie", "Trouvez Charlie"));
        scenarios.add(new Scenario("Mais où est donc Ornicar", "Dans ta conjonction de coordination"));
    }

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = {"/scenarioList"}, method = RequestMethod.GET)
    public String scenarioList(Model model) {

        model.addAttribute("scenarios", scenarios);

        return "scenarioList";
    }

    @RequestMapping(value = {"/addScenario"}, method = RequestMethod.GET)
    public String showAddScenarioPage(Model model) {

        ScenarioForm scenarioForm = new ScenarioForm();
        model.addAttribute("scenarioForm", scenarioForm);

        return "addScenario";
    }

    @RequestMapping(value = {"/addScenario"}, method = RequestMethod.POST)
    public String saveScenario(Model model, @ModelAttribute("scenarioForm") ScenarioForm scenarioForm) {

        String titre = scenarioForm.getTitre();
        String description = scenarioForm.getDescription();

        if (titre != null && titre.length() > 0 //
                && description != null && description.length() > 0) {
            Scenario newScenario = new Scenario(titre, description);
            scenarios.add(newScenario);

            return "redirect:/scenarioList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addScenario";
    }

}
