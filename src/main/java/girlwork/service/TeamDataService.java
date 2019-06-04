package girlwork.service;

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

    public List<TeamData> getAllTeamData() { return repo.findAll(); }

    private double getRatioNeedsService() {
        long numNeedsService = getAllTeamData()
                .stream()
                .filter(v -> v.getNeedsService())
                .count();

        long numNeedsNoService = getAllTeamData()
                .stream()
                .filter(v -> !v.getNeedsService())
                .count();

        return Math.round((double)numNeedsService / (double)numNeedsNoService * 100);
    }

//    public Analysis getAnalysis() {
//        SiteData maxCapacity = getAllTeamData()
//                .stream()
//                .max(Comparator.comparing( v -> (v.getCapacityPerUnit() * v.getUpUnits()) ))
//                .map( v -> {
//                        SiteData site = new SiteData("Maximum Operating Capacity",
//                                        v.getSiteName(),
//                                        v.getTeamName(),
//                                        v.getGenerationType(),
//                                        v.getUpUnits(),
//                                        (v.getTotalUnits() - v.getUpUnits()));
//                        site.setTotalCapacity(v.getTotalUnits() * v.getCapacityPerUnit());
//                        site.setOperatingCapacity(v.getUpUnits() * v.getCapacityPerUnit());
//
//                        return site;
//                    }
//                ).get();
//
//        SiteData maxUnits = getAllTeamData()
//                .stream()
//                .max(Comparator.comparing(v -> v.getTotalUnits()))
//                .map( v -> {
//                        SiteData site = new SiteData("Maximum Units",
//                                    v.getSiteName(),
//                                    v.getTeamName(),
//                                    v.getGenerationType(),
//                                    v.getUpUnits(),
//                                    (v.getTotalUnits() - v.getUpUnits()));
//                        site.setTotalCapacity(v.getTotalUnits() * v.getCapacityPerUnit());
//                        site.setOperatingCapacity(v.getUpUnits() * v.getCapacityPerUnit());
//
//                        return site;
//                    }
//                ).get();
//
//        SiteData maxWind = getAllTeamData()
//                .stream()
//                .filter(v -> v.getGenerationType().trim().equals("Wind"))
//                .max(Comparator.comparing( v -> (v.getCapacityPerUnit() * v.getUpUnits()) ))
//                .map( v -> {
//                        SiteData site = new SiteData("Maximum Wind Capacity",
//                                    v.getSiteName(),
//                                    v.getTeamName(),
//                                    v.getGenerationType(),
//                                    v.getUpUnits(),
//                                    (v.getTotalUnits() - v.getUpUnits()));
//                        site.setTotalCapacity(v.getTotalUnits() * v.getCapacityPerUnit());
//                        site.setOperatingCapacity(v.getUpUnits() * v.getCapacityPerUnit());
//
//                        return site;
//                    }
//                ).get();
//
//        SiteData maxSolar = getAllTeamData()
//                .stream()
//                .filter(v -> v.getGenerationType().trim().equals("Solar"))
//                .max(Comparator.comparing( v -> (v.getCapacityPerUnit() * v.getUpUnits()) ))
//                .map( v -> {
//                        SiteData site = new SiteData("Maximum Solar Capacity",
//                                    v.getSiteName(),
//                                    v.getTeamName(),
//                                    v.getGenerationType(),
//                                    v.getUpUnits(),
//                                    (v.getTotalUnits() - v.getUpUnits()));
//                        site.setTotalCapacity(v.getTotalUnits() * v.getCapacityPerUnit());
//                        site.setOperatingCapacity(v.getUpUnits() * v.getCapacityPerUnit());
//                        return site;
//                    }
//                ).get();
//
//        List<SiteData> needsServiceList = getAllTeamData()
//                .stream()
//                .filter(v -> v.getNeedsService())
//                .map( v -> {
//                        SiteData site = new SiteData("Needs Service",
//                                    v.getSiteName(),
//                                    v.getTeamName(),
//                                    v.getGenerationType(),
//                                    v.getUpUnits(),
//                                    (v.getTotalUnits() - v.getUpUnits()));
//                        site.setTotalCapacity(v.getTotalUnits() * v.getCapacityPerUnit());
//                        site.setOperatingCapacity(v.getUpUnits() * v.getCapacityPerUnit());
//                        return site;
//                    }
//                )
//                .collect(Collectors.toList());
//
//        Analysis analysis = new Analysis(
//                maxCapacity,
//                maxUnits,
//                maxWind,
//                maxSolar,
//                needsServiceList,
//                getRatioNeedsService()
//        );
//
//        return analysis;
//    }

    //    public List<GenTypeData> getGenTypeData() {
    //        GenTypeData windData = new GenTypeData("Wind", data.stream().filter(v -> v.getGenerationType().equals("Wind")).count());
    //        GenTypeData solarData = new GenTypeData("Solar", data.stream().filter(v -> v.getGenerationType().equals("Solar")).count());
    //
    //        return new ArrayList<>(Arrays.asList(windData, solarData));
    //    }
    //
    //    public List<ServiceData> getServiceData() {
    //        ServiceData trueData = new ServiceData(true, data.stream().filter(v -> v.getNeedsService()).count());
    //        ServiceData falseData = new ServiceData(false, data.stream().filter(v -> !v.getNeedsService()).count());
    //
    //        return new ArrayList<>(Arrays.asList(trueData, falseData));
    //    }
    //
    //    /**
    //     * helper classes for chart data
    //     */
    //    private class GenTypeData {
    //        String type;
    //        long total;
    //
    //        public GenTypeData(String type, long total) {
    //            this.type = type;
    //            this.total = total;
    //        }
    //    }
    //
    //    private class ServiceData {
    //        boolean serviceNeeded;
    //        long total;
    //
    //        public ServiceData(boolean serviceNeeded, long total) {
    //            this.serviceNeeded = serviceNeeded;
    //            this.total = total;
    //        }
    //    }
}