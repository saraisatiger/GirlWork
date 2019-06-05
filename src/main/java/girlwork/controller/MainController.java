package girlwork.controller;

import girlwork.repository.EnergyFarmRepository;
import girlwork.service.AnalysisService;
import girlwork.service.EnergyFarmService;
import girlwork.service.TeamDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired private EnergyFarmService service;
//    @Autowired private AnalysisService analysisService;

    @GetMapping("/")
    public String index() { return "index"; }

    @GetMapping("/data")
    public String getData(Model model) {
//        model.addAttribute("data", service.getAllTeamData());
//        model.addAttribute("analytics", service.getAnalysis());
        model.addAttribute("data", service.getAll());
        return "data";
    }

//    @GetMapping("/charts")
//    public String getCharts(Model model) {
//        model.addAttribute("genTypeData", analysisService.getGenTypeData());
//        model.addAttribute("serviceData", analysisService.getServiceData());
//        model.addAttribute("unitData", analysisService.getTeamUnitData());
//        return "chart";
//    }
}