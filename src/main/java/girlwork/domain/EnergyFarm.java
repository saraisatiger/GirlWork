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

    public String toString() {
        return this.name + ", " +
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
