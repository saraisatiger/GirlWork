package girlwork.domain;

import java.util.List;

/**
 * Wrapper class for aggregated TeamData analysis
 */
public class Analysis {
    // class fields
    private SiteData maxCapacity;
    private SiteData maxUnits;
    private SiteData maxWind;
    private SiteData maxSolar;
    private List<SiteData> needsServiceList;
    private double ratioNeedsService;

    // getters
    public SiteData getMaxCapacity() { return this.maxCapacity; }
    public SiteData getMaxUnits() { return this.maxUnits; }
    public SiteData getMaxWind() { return this.maxWind; }
    public SiteData getMaxSolar() { return this.maxSolar; }
    public List<SiteData> getNeedsServiceSiteNames() { return this.needsServiceList; }
    public double getRatioNeedsService() { return this.ratioNeedsService; }

    // setters
    public void setMaxCapacity(SiteData maxCapacitySiteName) { this.maxCapacity = maxCapacitySiteName; }
    public void setMaxUnits(SiteData maxUnitsSiteName) { this.maxUnits = maxUnitsSiteName; }
    public void setMaxWind(SiteData maxWindSiteName) { this.maxWind = maxWindSiteName; }
    public void setMaxSolar(SiteData maxSolarSiteName) { this.maxSolar = maxSolarSiteName; }
    public void setNeedsServiceList(List<SiteData> needsServiceList) { this.needsServiceList = needsServiceList; }
    public void setRatioNeedsService(double ratioNeedsService) { this.ratioNeedsService = ratioNeedsService; }

    // custom constructor
    public Analysis(SiteData maxCapacity,
                    SiteData maxUnits,
                    SiteData maxWind,
                    SiteData maxSolar,
                    List<SiteData> needsServiceList,
                    double ratioNeedsService) {
        this.maxCapacity = maxCapacity;
        this.maxUnits = maxUnits;
        this.maxWind = maxWind;
        this.maxSolar = maxSolar;
        this.needsServiceList = needsServiceList;
        this.ratioNeedsService = ratioNeedsService;
    }

    // implemented for debugging purposes
    public String toString() {
        return maxCapacity + ", " +
                maxUnits + ", " +
                maxWind + ", " +
                maxSolar + ", " +
                needsServiceList + ", " +
                ratioNeedsService;
    }
}
