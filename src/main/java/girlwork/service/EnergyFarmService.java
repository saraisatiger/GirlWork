package girlwork.service;

import girlwork.domain.EnergyFarm;
import girlwork.repository.EnergyFarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

@Service
public class EnergyFarmService {
    @Autowired EnergyFarmRepository repo;

    // all data
    public List<EnergyFarm> getAll() {
        return repo.findAll();
    }

    public List<EnergyFarm> getAllByRenewableType(String renewableType) {
        return getAll().stream()
                .filter(v -> v.getRenewableType().toUpperCase().equals(renewableType))
                .collect(Collectors.toList());
    }

    // max total units
    public EnergyFarm maxTotalUnitsByRenewableType(String renewableType) {
        return getAll().stream()
                .filter(v -> v.getRenewableType().toUpperCase().equals(renewableType))
                .max(comparingInt(EnergyFarm::getTotalUnits))
                .get();
    }

    // max operating units
    public EnergyFarm maxOperatingUnitsByRenewabletype(String renewableType) {
        return getAll().stream()
                .filter(v -> v.getRenewableType().toUpperCase().equals(renewableType))
                .max(comparingInt(EnergyFarm::getOperatingUnits))
                .get();
    }

    // max total capacity
    public EnergyFarm maxTotalCapacityByRenewableType(String renewableType) {
        return getAll().stream()
                .filter(v -> v.getRenewableType().toUpperCase().equals(renewableType))
                .max(comparing(v -> v.getTotalUnits() * v.getUnitCapacity()))
                .get();
    }

    // max operating capacity
    public EnergyFarm maxOperatingCapacityByRenewableType(String renewableType) {
        return getAll().stream()
                .filter(v -> v.getRenewableType().toUpperCase().equals(renewableType))
                .max(comparing(v -> v.getOperatingUnits() * v.getUnitCapacity()))
                .get();
    }

    // renewable type pie chart (total wind, total solar)
    public Map<String, Long> countByRenewableType() {
        Map<String, Long> map = new HashMap<>();

        map.put("WIND", getAll().stream()
                .filter(v -> v.getRenewableType().toUpperCase().equals("WIND"))
                .count());

        map.put("SOLAR", getAll().stream()
                .filter(v -> v.getRenewableType().toUpperCase().equals("WIND"))
                .count());

        return map;
    }

    // deployment required pie chart (total true, total false)
    public Map<Boolean, Long> countByDeploymentRequired() {
        Map<Boolean, Long> map = new HashMap<>();

        map.put(true, getAll().stream().filter(v -> v.isDeploymentRequired()).count());
        map.put(false, getAll().stream().filter(v -> !v.isDeploymentRequired()).count());

        return map;
    }

    // service required pie chart (total true, total false)
    public Map<Boolean, Long> countByServiceRequired() {
        Map<Boolean, Long> map = new HashMap<>();

        map.put(true, getAll().stream().filter(v -> v.isServiceRequired()).count());
        map.put(false, getAll().stream().filter(v -> !v.isServiceRequired()).count());

        return map;
    }
}
