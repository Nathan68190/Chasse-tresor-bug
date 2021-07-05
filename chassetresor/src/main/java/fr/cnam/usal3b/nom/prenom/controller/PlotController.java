package fr.cnam.usal3b.nom.prenom.controller;

import fr.cnam.usal3b.nom.prenom.form.PlotForm;
import fr.cnam.usal3b.nom.prenom.model.Plot;
import fr.cnam.usal3b.nom.prenom.repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlotController {

    @Autowired
    private PlotRepository plotRepository;


    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;


    @RequestMapping(value = {"/plotList"}, method = RequestMethod.GET)
    public String plotList(Model model) {

        Iterable<Plot> plotsDb = plotRepository.findAll();
        model.addAttribute("plots", plotsDb);

        return "plotList";
    }

    @RequestMapping(value = {"/addPlot"}, method = RequestMethod.GET)
    public String showAddPlotPage(Model model) {

        PlotForm plotForm = new PlotForm();
        model.addAttribute("plotForm", plotForm);

        return "addPlot";
    }

    @RequestMapping(value = {"/addPlot"}, method = RequestMethod.POST)
    public String savePlot(Model model, @ModelAttribute("plotForm") PlotForm plotForm) {

        String titre = plotForm.getTitre();
        String description = plotForm.getDescription();

        if (titre != null && titre.length() > 0 //
                && description != null && description.length() > 0) {
            Plot newPlot = new Plot(titre, description);
            plotRepository.save(newPlot);

            return "redirect:/plotList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addPlot";
    }

}
