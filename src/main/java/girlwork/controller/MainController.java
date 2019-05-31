package girlwork.controller;

import girlwork.service.TeamDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private TeamDataService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/getData")
    public String getAnalyzedData(Model model) {
        model.addAttribute("data", service.getAllTeamData());
        model.addAttribute("analytics", service.getAnalysis());
        return "data";
    }

    @GetMapping("/chart")
    public String getChart(Model model) {
//        model.addAttribute("data", service.getAllTeamData());
//        model.addAttribute("analytics", service.getAnalysis());
        return "chart";
    }
}