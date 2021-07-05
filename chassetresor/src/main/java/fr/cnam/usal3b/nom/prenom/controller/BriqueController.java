package fr.cnam.usal3b.nom.prenom.controller;

import fr.cnam.usal3b.nom.prenom.form.BriqueForm;
import fr.cnam.usal3b.nom.prenom.model.Brique;
import fr.cnam.usal3b.nom.prenom.repository.BriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BriqueController {

    @Autowired
    private BriqueRepository briqueRepository;

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/briqueList"}, method = RequestMethod.GET)
    public String briqueList(Model model) {

        Iterable<Brique> briquesDb = briqueRepository.findAll();
        model.addAttribute("briques", briquesDb);

        return "briqueList";
    }

    @RequestMapping(value = {"/addBrique"}, method = RequestMethod.GET)
    public String showAddBriquePage(Model model) {

        BriqueForm briqueForm = new BriqueForm();
        model.addAttribute("briqueForm", briqueForm);

        return "addBrique";
    }

    @RequestMapping(value = {"/addBrique"}, method = RequestMethod.POST)
    public String saveBrique(Model model, @ModelAttribute("briqueForm") BriqueForm briqueForm) {

        String titre = briqueForm.getTitre();
        String description = briqueForm.getDescription();

        if (titre != null && titre.length() > 0 //
                && description != null && description.length() > 0) {
            Brique newBrique = new Brique(titre, description);
            briqueRepository.save(newBrique);

            return "redirect:/briqueList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addBrique";
    }

}
