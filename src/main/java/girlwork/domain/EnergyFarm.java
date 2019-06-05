package girlwork.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "energyFarm")
public class EnergyFarm {
    // MongoDB field (used by the repository for document lookup)
    @Id
    private ObjectId _id;

    // class fields
    private String name;
    private String renewableType;
    private String location;
    private int weatherQuality;
    private String weatherQualityType;
    private int totalUnits;
    private int operatingUnits;
    private String condition;
    private boolean deploymentRequired;
    private boolean serviceRequired;
    private int unitCapacity;

    // standard getters
    public String getName() {
        return this.name;
    }

    public String getRenewableType() {
        return this.renewableType;
    }

    public String getLocation() {
        return this.location;
    }

    public long getWeatherQuality() {
        return this.weatherQuality;
    }

    public String getWeatherQualityType() {
        return this.weatherQualityType;
    }

    public int getTotalUnits() {
        return this.totalUnits;
    }

    public int getOperatingUnits() {
        return this.operatingUnits;
    }

    public String getCondition() {
        return this.condition;
    }

    public boolean isDeploymentRequired() {
        return this.deploymentRequired;
    }

    public boolean isServiceRequired() {
        return this.serviceRequired;
    }

    public int getUnitCapacity() {
        return this.unitCapacity;
    }

    // standard setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRenewableType(String renewableType) {
        this.renewableType = renewableType;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWeatherQuality(int weatherQuality) {
        this.weatherQuality = weatherQuality;
    }

    public void setWeatherQualityType(String weatherQualityType) {
        this.weatherQualityType = weatherQualityType;
    }

    public void setTotalUnits(int totalUnits) {
        this.totalUnits = totalUnits;
    }

    public void setOperatingUnits(int operatingUnits) {
        this.operatingUnits = operatingUnits;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setDeploymentRequired(boolean deploymentRequired) {
        this.deploymentRequired = deploymentRequired;
    }

    public void setServiceRequired(boolean serviceRequired) {
        this.serviceRequired = serviceRequired;
    }

    public void setUnitCapacity(int unitCapacity) {
        this.unitCapacity = unitCapacity;
    }

    public String toString() {
        return this._id + ": " +
                this.name + ", " +
                this.renewableType + ", " +
                this.location + ", " +
                this.weatherQuality + ", " +
                this.weatherQualityType + ", " +
                this.totalUnits + ", " +
                this.operatingUnits + ", " +
                this.condition + ", " +
                this.deploymentRequired + ", " +
                this.serviceRequired + ", " +
                this.unitCapacity;
    }
}
