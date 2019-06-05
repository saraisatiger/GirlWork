package girlwork.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "energyFarm")
public class EnergyFarm {
    // mongodb id field (for document lookups)
    @Id                             private ObjectId _id;

    // class fields annotated with mongodb literal field names
    @Field("name")                  private String  name;
    @Field("renewable_type")        private String  renewableType;
    @Field("location")              private String  location;
    @Field("weather_quality")       private int     weatherQuality;
    @Field("weather_quality_type")  private String  weatherQualityType;
    @Field("total_units")           private int     totalUnits;
    @Field("operating_units")       private int     operatingUnits;
    @Field("condition")             private String  condition;
    @Field("deployment_required")   private boolean deploymentRequired;
    @Field("service_required")      private boolean serviceRequired;
    @Field("unit_capacity")         private int     unitCapacity;

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
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setRenewableType(String renewableType) {
//        this.renewableType = renewableType;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public void setWeatherQuality(int weatherQuality) {
//        this.weatherQuality = weatherQuality;
//    }
//
//    public void setWeatherQualityType(String weatherQualityType) {
//        this.weatherQualityType = weatherQualityType;
//    }
//
//    public void setTotalUnits(int totalUnits) {
//        this.totalUnits = totalUnits;
//    }
//
//    public void setOperatingUnits(int operatingUnits) {
//        this.operatingUnits = operatingUnits;
//    }
//
//    public void setCondition(String condition) {
//        this.condition = condition;
//    }
//
//    public void setDeploymentRequired(boolean deploymentRequired) {
//        this.deploymentRequired = deploymentRequired;
//    }
//
//    public void setServiceRequired(boolean serviceRequired) {
//        this.serviceRequired = serviceRequired;
//    }
//
//    public void setUnitCapacity(int unitCapacity) {
//        this.unitCapacity = unitCapacity;
//    }

//    public String toString() {
//        return this._id + ": " +
//                this.name + ", " +
//                this.renewableType + ", " +
//                this.location + ", " +
//                this.weatherQuality + ", " +
//                this.weatherQualityType + ", " +
//                this.totalUnits + ", " +
//                this.operatingUnits + ", " +
//                this.condition + ", " +
//                this.deploymentRequired + ", " +
//                this.serviceRequired + ", " +
//                this.unitCapacity;
//    }
}
