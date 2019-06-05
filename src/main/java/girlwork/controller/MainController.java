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
        // all data
        model.addAttribute("data", service.getAll());

        // wind stats
        model.addAttribute("maxTotalUnitsWind", service.maxTotalUnitsByRenewableType("WIND"));
        model.addAttribute("maxOperatingUnitsWind", service.maxOperatingUnitsByRenewabletype("WIND"));
        model.addAttribute("maxTotalCapacityWind", service.maxTotalCapacityByRenewableType("WIND"));
        model.addAttribute("maxOperatingCapacityWind", service.maxOperatingCapacityByRenewableType("WIND"));

        // solar stats
        model.addAttribute("maxTotalUnitsSolar", service.maxTotalUnitsByRenewableType("SOLAR"));
        model.addAttribute("maxOperatingUnitsSolar", service.maxOperatingUnitsByRenewabletype("SOLAR"));
        model.addAttribute("maxTotalCapacitySolar", service.maxOperatingCapacityByRenewableType("SOLAR"));
        model.addAttribute("maxOperatingCapacitySolar", service.maxOperatingCapacityByRenewableType("SOLAR"));

        // charts
        model.addAttribute("renewableTypeData", service.countByRenewableType());
        model.addAttribute("deploymentStatusData", service.countByDeploymentRequired());
        model.addAttribute("serviceStatusData", service.countByServiceRequired());

        return "data";
    }
}