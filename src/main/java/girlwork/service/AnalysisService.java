package girlwork.service;

import girlwork.domain.TeamData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnalysisService {
    @Autowired
    TeamDataService teamDataService;

    private List<TeamData> getData() {
        return teamDataService.getAllTeamData();
    }

    public List<GenTypeData> getGenTypeData() {
        GenTypeData windData = new GenTypeData("Wind", getData().stream().filter(v -> v.getGenerationType().equals("Wind")).count());
        GenTypeData solarData = new GenTypeData("Solar", getData().stream().filter(v -> v.getGenerationType().equals("Solar")).count());

        return new ArrayList<>(Arrays.asList(windData, solarData));
    }

    public List<ServiceData> getServiceData() {
        ServiceData trueData = new ServiceData(String.valueOf(true), getData().stream().filter(v -> v.getNeedsService()).count());
        ServiceData falseData = new ServiceData(String.valueOf(false), getData().stream().filter(v -> !v.getNeedsService()).count());

        return new ArrayList<>(Arrays.asList(trueData, falseData));
    }

    /**
     * helper classes for chart data
     */
    private class GenTypeData {
        String type;
        long total;

        public String getType() { return this.type; }
        public long getTotal() { return this.total; }

        public GenTypeData(String type, long total) {
            this.type = type;
            this.total = total;
        }
    }

    private class ServiceData {
        String serviceNeeded;
        long total;

        public String getServiceNeeded() { return this.serviceNeeded; }
        public long getTotal() { return this.total; }

        public ServiceData(String serviceNeeded, long total) {
            this.serviceNeeded = serviceNeeded;
            this.total = total;
        }
    }
}
