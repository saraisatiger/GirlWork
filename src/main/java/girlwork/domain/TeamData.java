package girlwork.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teamdata")
public class TeamData {
    // MongoDB field (used by the repository for lookup)
    @Id
    private ObjectId _id;

    // class fields
    private String teamName;
    private String siteName;
    private String generationType;
    private String weatherConditions;
    private int totalUnits;
    private double upUnits;
    private double downUnits;
    private double capacityPerUnit;
    private boolean needsService;

    // getters
    public String getTeamName() { return teamName; }
    public String getSiteName() { return siteName; }
    public String getGenerationType() { return generationType; }
    public String getWeatherConditions() { return weatherConditions; }
    public int getTotalUnits() { return totalUnits; }
    public double getCapacityPerUnit() { return capacityPerUnit; }
    public boolean getNeedsService() { return needsService; }
    public double getUpUnits() { return this.upUnits; }
    public double getDownUnits() { return this.downUnits; }

    // setters
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public void setSiteName(String siteName) { this.siteName = siteName; }
    public void setGenerationType(String generationType) { this.generationType = generationType; }
    public void setWeatherConditions(String weatherConditions) { this.weatherConditions = weatherConditions; }
    public void setTotalUnits(int totalUnits) { this.totalUnits = totalUnits; }
    public void setCapacityPerUnit(double capacityPerUnit) { this.capacityPerUnit = capacityPerUnit; }
    public void setNeedsService(boolean needsService) { this.needsService = needsService; }
    public void setUpUnits(double upUnits) { this.upUnits = upUnits; }
    public void setDownUnits(double downUnits) { this.downUnits = downUnits; }

    // implemented for debugging purposes
//    public String toString() {
//        return teamName + ", " +
//                siteName + ", " +
//                generationType + ", " +
//                weatherConditions + ", " +
//                numUnits + ", " +
//                capacityPerUnit + ", " +
//                needsService;
//    }
}