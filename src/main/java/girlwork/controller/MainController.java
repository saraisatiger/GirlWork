package girlwork.controller;

import girlwork.domain.RenewableType;
import girlwork.service.EnergyFarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired private EnergyFarmService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/analysis")
    public String getData(Model model) {
        // site data
        model.addAttribute("siteData", service.getAll());

        // wind stats
        model.addAttribute("maxTotalUnitsWind", service.maxTotalUnitsByRenewableType(RenewableType.WIND.toString()));
        model.addAttribute("maxOperatingUnitsWind", service.maxOperatingUnitsByRenewabletype(RenewableType.WIND.toString()));
        model.addAttribute("maxTotalCapacityWind", service.maxTotalCapacityByRenewableType(RenewableType.WIND.toString()));
        model.addAttribute("maxOperatingCapacityWind", service.maxOperatingCapacityByRenewableType(RenewableType.WIND.toString()));

        // solar stats
        model.addAttribute("maxTotalUnitsSolar", service.maxTotalUnitsByRenewableType(RenewableType.SOLAR.toString()));
        model.addAttribute("maxOperatingUnitsSolar", service.maxOperatingUnitsByRenewabletype(RenewableType.SOLAR.toString()));
        model.addAttribute("maxTotalCapacitySolar", service.maxOperatingCapacityByRenewableType(RenewableType.SOLAR.toString()));
        model.addAttribute("maxOperatingCapacitySolar", service.maxOperatingCapacityByRenewableType(RenewableType.SOLAR.toString()));

        // charts
        model.addAttribute("renewableTypeData", service.countByRenewableType());
        model.addAttribute("deploymentStatusData", service.countByDeploymentRequired());
        model.addAttribute("serviceStatusData", service.countByServiceRequired());
        model.addAttribute("windUnitData", service.getAllByRenewableType(RenewableType.WIND.toString()));
        model.addAttribute("solarUnitData", service.getAllByRenewableType(RenewableType.SOLAR.toString()));

        return "analysis";
    }
}