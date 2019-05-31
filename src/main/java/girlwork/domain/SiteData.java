package girlwork.domain;

/**
 * Helper class for building analysis categories
 */
public class SiteData {
    // class fields
    private String category = "";
    private String siteName;
    private String teamName;
    private double operatingCapacity;
    private double totalCapacity;
    private String generationType;
    private double unitsUp;
    private double unitsDown;

    // getters
    public String getCategory() { return this.category; }
    public String getSiteName() { return this.siteName; }
    public String getTeamName() { return this.teamName; }
    public double getOperatingCapacity() { return this.operatingCapacity; }
    public double getTotalCapacity() { return this.totalCapacity; }
    public String getGenerationType() { return this.generationType; }
    public double getUnitsUp() { return this.unitsUp; }
    public double getUnitsDown() { return this.unitsDown; }

    // setters
    public void setCategory(String category) { this.category = category; }
    public void setSiteName(String siteName) { this.siteName = siteName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public void setOperatingCapacity(double operatingCapacity) { this.operatingCapacity = operatingCapacity; }
    public void setTotalCapacity(double totalCapacity) { this.totalCapacity = totalCapacity; }
    public void setGenerationType(String generationType) { this.generationType = generationType; }
    public void setUnitsUp(double unitsUp) { this.unitsUp = unitsUp; }
    public void setUnitsDown(double unitsDown) { this.unitsDown = unitsDown; }

    // custom constructor
    public SiteData(String category,
                    String siteName,
                    String teamName,
                    String generationType,
                    double unitsUp,
                    double unitsDown
    ) {
        this.category = category;
        this.siteName = siteName;
        this.teamName = teamName;
        this.generationType = generationType;
        this.unitsUp = unitsUp;
        this.unitsDown = unitsDown;
    }
}
