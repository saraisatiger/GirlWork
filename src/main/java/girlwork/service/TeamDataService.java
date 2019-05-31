package girlwork.service;

import girlwork.domain.Analysis;
import girlwork.domain.SiteData;
import girlwork.domain.TeamData;
import girlwork.repository.TeamDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamDataService {
    @Autowired
    TeamDataRepository repo;

    public List<TeamData> getAllTeamData() {
        return repo.findAll();
    }

    private double getRatioNeedsService() {
        long numNeedsService = repo.findAll()
                .stream()
                .filter(v -> v.getNeedsService())
                .count();

        long numNeedsNoService = repo.findAll()
                .stream()
                .filter(v -> !v.getNeedsService())
                .count();

        return Math.round((double)numNeedsService / (double)numNeedsNoService * 100);
    }

    public Analysis getAnalysis() {
        SiteData maxCapacity = repo.findAll()
                .stream()
                .max(Comparator.comparing( v -> (v.getCapacityPerUnit() * v.getUpUnits()) ))
                .map( v -> {
                        SiteData site = new SiteData("Maximum Operating Capacity",
                                        v.getSiteName(),
                                        v.getTeamName(),
                                        v.getGenerationType(),
                                        v.getUpUnits(),
                                        (v.getTotalUnits() - v.getUpUnits()));
                        site.setTotalCapacity(v.getTotalUnits() * v.getCapacityPerUnit());
                        site.setOperatingCapacity(v.getUpUnits() * v.getCapacityPerUnit());

                        return site;
                    }
                ).get();

        SiteData maxUnits = repo.findAll()
                .stream()
                .max(Comparator.comparing(v -> v.getTotalUnits()))
                .map( v -> {
                        SiteData site = new SiteData("Maximum Units",
                                    v.getSiteName(),
                                    v.getTeamName(),
                                    v.getGenerationType(),
                                    v.getUpUnits(),
                                    (v.getTotalUnits() - v.getUpUnits()));
                        site.setTotalCapacity(v.getTotalUnits() * v.getCapacityPerUnit());
                        site.setOperatingCapacity(v.getUpUnits() * v.getCapacityPerUnit());

                        return site;
                    }
                ).get();

        SiteData maxWind = repo.findAll()
                .stream()
                .filter(v -> v.getGenerationType().trim().equals("Wind"))
                .max(Comparator.comparing( v -> (v.getCapacityPerUnit() * v.getUpUnits()) ))
                .map( v -> {
                        SiteData site = new SiteData("Maximum Wind Capacity",
                                    v.getSiteName(),
                                    v.getTeamName(),
                                    v.getGenerationType(),
                                    v.getUpUnits(),
                                    (v.getTotalUnits() - v.getUpUnits()));
                        site.setTotalCapacity(v.getTotalUnits() * v.getCapacityPerUnit());
                        site.setOperatingCapacity(v.getUpUnits() * v.getCapacityPerUnit());

                        return site;
                    }
                ).get();

        SiteData maxSolar = repo.findAll()
                .stream()
                .filter(v -> v.getGenerationType().trim().equals("Solar"))
                .max(Comparator.comparing( v -> (v.getCapacityPerUnit() * v.getUpUnits()) ))
                .map( v -> {
                        SiteData site = new SiteData("Maximum Solar Capacity",
                                    v.getSiteName(),
                                    v.getTeamName(),
                                    v.getGenerationType(),
                                    v.getUpUnits(),
                                    (v.getTotalUnits() - v.getUpUnits()));
                        site.setTotalCapacity(v.getTotalUnits() * v.getCapacityPerUnit());
                        site.setOperatingCapacity(v.getUpUnits() * v.getCapacityPerUnit());
                        return site;
                    }
                ).get();

        List<SiteData> needsServiceList = repo.findAll()
                .stream()
                .filter(v -> v.getNeedsService())
                .map( v -> {
                        SiteData site = new SiteData("Needs Service",
                                    v.getSiteName(),
                                    v.getTeamName(),
                                    v.getGenerationType(),
                                    v.getUpUnits(),
                                    (v.getTotalUnits() - v.getUpUnits()));
                        site.setTotalCapacity(v.getTotalUnits() * v.getCapacityPerUnit());
                        site.setOperatingCapacity(v.getUpUnits() * v.getCapacityPerUnit());
                        return site;
                    }
                )
                .collect(Collectors.toList());

        Analysis analysis = new Analysis(
                maxCapacity,
                maxUnits,
                maxWind,
                maxSolar,
                needsServiceList,
                getRatioNeedsService()
        );

        return analysis;
    }
}