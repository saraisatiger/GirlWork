package girlwork.controller;

import girlwork.service.EnergyFarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired private EnergyFarmService service;

    @GetMapping("/")
    public String index() { return "index"; }

    @GetMapping("/data")
    public String getData(Model model) {
        model.addAttribute("data", service.getAll());

        model.addAttribute("maxTotalUnitsWind", service.maxTotalUnitsByRenewableType("WIND"));
        model.addAttribute("maxOperatingUnitsWind", service.maxOperatingUnitsByRenewabletype("WIND"));
        model.addAttribute("maxTotalCapacityWind", service.maxTotalCapacityByRenewableType("WIND"));
        model.addAttribute("maxOperatingCapacityWind", service.maxOperatingCapacityByRenewableType("WIND"));

        model.addAttribute("maxTotalUnitsSolar", service.maxTotalUnitsByRenewableType("SOLAR"));
        model.addAttribute("maxOperatingUnitsSolar", service.maxOperatingUnitsByRenewabletype("SOLAR"));
        model.addAttribute("maxTotalCapacitySolar", service.maxOperatingCapacityByRenewableType("SOLAR"));
        model.addAttribute("maxOperatingCapacitySolar", service.maxOperatingCapacityByRenewableType("SOLAR"));

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